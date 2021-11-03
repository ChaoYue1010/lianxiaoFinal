package com.zyhn.util;

import com.zyhn.mapper.PlanStateMapper;
import com.zyhn.mapper.WaybillMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;

@Configuration // 1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling // 2.开启定时任务
public class FashionableTimer {

	private static Logger logger = LoggerFactory.getLogger(FashionableTimer.class);

	@Resource
	private PlanStateMapper planStateMapper;
	@Resource
	private WaybillMapper waybillMapper;

	/**
	 * 定时删除一个月前数据
	 * cron表达式格式：{秒数} {分钟} {小时} {日期} {月份} {星期} {年份(可为空)}
	 */
	@Scheduled(cron="10 0 0 * * ?")
	public void end() {

		int deletePlanState = planStateMapper.delete();
		int deleteWaybill = waybillMapper.delete();
		logger.info("删除deletePlanState ：{}", deletePlanState);
		logger.info("删除deleteWaybill ：{}", deleteWaybill);

	}

}