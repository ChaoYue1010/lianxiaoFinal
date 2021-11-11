package com.zyhn.listener;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
import com.zyhn.service.IPlanStateService;
import com.zyhn.service.IWaybillService;
import com.zyhn.service.IWaybillStatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Component
public class PlanQueueListener {

	private static Logger logger = LoggerFactory.getLogger(PlanQueueListener.class);

	@Resource
	private IWaybillStatusService iWaybillStatusService;

	@Resource
	private IWaybillService iWaybillService;

	@Resource
	private IPlanStateService iPlanStateService;

	@RabbitListener(queues = "PlanQueue")
	public void PlanQueue(byte[] data, Message message, Channel channel) throws IOException{
		int i = 0;
		try {
			logger.debug("PlanQueue Receiving：" + new String(data, "utf-8"));
			String s = new String(data, "utf-8");
			JSONObject receive = JSONObject.parseObject(s);
			logger.info("新增运单数据 ：{}", receive);
			iWaybillStatusService.addOrUpdateWaybillStatus(receive);
			i = iWaybillService.addWaybill(receive);
			if (i > 0) {
				//告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
				channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//				channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
			}
			System.out.println("receiver success");
		} catch (IOException e) {
			e.printStackTrace();
			//消费失败这条消息还在
			channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
			System.out.println("receiver fail");
		}
	}


	@RabbitListener(queues = "PlanStatusQueue")
	public void PlanStatusQueue(byte[] data, Message message, Channel channel) throws IOException{
		int i = 0;
		try {
			logger.debug("PlanQueue Receiving：" + new String(data, "utf-8"));
			String s = new String(data, "utf-8");
			JSONObject receive = JSONObject.parseObject(s);
			String code = receive.getString("code");
			List<String> listCode = iPlanStateService.selectCode(code);
			if (null == listCode || listCode.size() == 0) {
				//插入
				logger.info("新增计划状态变更数据 ：{}", receive);
				iWaybillStatusService.addOrUpdateWaybillStatus(receive);
				i = iPlanStateService.addPlanState(receive);
			} else {
				for (String selectCode : listCode) {
					if (code.equals(selectCode)) {
						//修改
						logger.info("修改计划状态变更数据 ：{}", receive);
						iWaybillStatusService.addOrUpdateWaybillStatus(receive);
						i = iPlanStateService.updatePlanState(receive);
					}
				}
			}
			if (i > 0) {
				//告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
				channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//				channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
			}
			System.out.println("receiver success");
		} catch (IOException e) {
			e.printStackTrace();
			//消费失败这条消息还在
			channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
			System.out.println("receiver fail");
		}
	}
}
