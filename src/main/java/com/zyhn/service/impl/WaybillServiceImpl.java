package com.zyhn.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zyhn.entity.Waybill;
import com.zyhn.mapper.WaybillMapper;
import com.zyhn.service.IWaybillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author chaoyue
 */
@Service
@Slf4j(topic = "WaybillServiceImpl——————————")
public class WaybillServiceImpl implements IWaybillService {

	@Resource
	private WaybillMapper waybillMapper;

	/**
	 * 新增
	 **/
	@Override
	public int addWaybill(JSONObject jsonObject) {

		//创建时间
		Date now = new Date();
		Waybill waybill = JSONObject.parseObject(jsonObject.toString(), Waybill.class);
		waybill.setJsonData(jsonObject.toString());
		waybill.setCreateAt(now);
		log.info("新增 ：{}", waybill);
		return waybillMapper.insert(waybill);

	}


}
