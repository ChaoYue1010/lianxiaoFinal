package com.zyhn.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zyhn.entity.WaybillStatus;
import com.zyhn.mapper.WaybillStatusMapper;
import com.zyhn.service.IWaybillStatusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chaoyue
 */
@Service
@Slf4j
public class WaybillStatusServiceImpl implements IWaybillStatusService {

	@Resource
	private WaybillStatusMapper waybillStatusMapper;

	@Override
	public void addOrUpdateWaybillStatus(JSONObject jsonObject) {
		WaybillStatus waybillStatus = JSONObject.parseObject(jsonObject.toString(), WaybillStatus.class);
		int i = 0;
		if (jsonObject.getString("status") == null) {
			//创建时间
			Date createTime = new Date();
			JSONObject orderJsObj = jsonObject.getJSONObject("order");
			JSONArray jsonArray = orderJsObj.getJSONArray("carrier");
			for (Object obj : jsonArray) {
				String s = obj.toString();
				JSONObject parseObject = JSONObject.parseObject(s);
				waybillStatus.setCARRIER_CODE(parseObject.getString("businessLicense"));
				waybillStatus.setCARRIER_NAME(parseObject.getString("name"));
			}
			if (jsonArray.isEmpty() || jsonArray.size() < 1) {
				waybillStatus.setCARRIER_NAME("自提");
			}
			waybillStatus.setTRANS_NO(jsonObject.getString("code"));
			waybillStatus.setVEHICLE_NO(jsonObject.getString("vehicleNo"));
			String transportMode = orderJsObj.getString("transportMode");
			if ("公路运输".equals(transportMode)) {
				waybillStatus.setTRANS_MODE("RD");
			} else if ("铁路运输".equals(transportMode)) {
				waybillStatus.setTRANS_MODE("RL");
			} else if ("水路运输".equals(transportMode)) {
				waybillStatus.setTRANS_MODE("WT");
			} else if ("全部".equals(transportMode)) {
				waybillStatus.setTRANS_MODE("AL");
			} else {
				waybillStatus.setTRANS_MODE("");
			}
			waybillStatus.setORDER_STATE("3");
			waybillStatus.setSEND_ADDRESS(orderJsObj.getJSONObject("supplier").getString("province"));
			waybillStatus.setMANU_ENT_CODE(orderJsObj.getJSONObject("supplier").getString("businessLicense"));
			waybillStatus.setMANU_ENT_NAME(orderJsObj.getJSONObject("supplier").getString("name"));
			waybillStatus.setRECV_ADDRESS(orderJsObj.getJSONObject("customer").getString("province"));
			waybillStatus.setRECV_DEALER_NAME(orderJsObj.getJSONObject("customer").getString("name"));
			waybillStatus.setMATERIAL_CODE(orderJsObj.getJSONObject("material").getString("code"));
			waybillStatus.setMATERIAL_NAME(orderJsObj.getJSONObject("material").getString("name"));
			waybillStatus.setLOAD_QTY(Double.parseDouble(orderJsObj.getString("quantity")));
			waybillStatus.setPACK_UNIT(orderJsObj.getString("unit"));
			waybillStatus.setOWNER_ID("35900000");
			waybillStatus.setOWNER_SECTOR_CODE("30070000");
			waybillStatus.setOWNER_NAME("炼油销售");
			waybillStatus.setSOURCE_SYS("LXXT");
			waybillStatus.setORDER_ID(orderJsObj.getString("factoryOrderNo"));
			DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date startTime = null;
			Date endTime = null;
			try {
				startTime = format1.parse(jsonObject.getString("startTime"));
				endTime = format1.parse(jsonObject.getString("endTime"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			waybillStatus.setSEND_TIME(startTime);
			waybillStatus.setCREATE_TIME(createTime);
			waybillStatus.setUPDATE_TIME(createTime);
			waybillStatus.setEXPECTED_SEND_TIME(startTime);
			waybillStatus.setRECV_TIME(endTime);
			waybillStatus.setID_NUMBER(jsonObject.getJSONObject("driver").getString("idNumber"));

			log.info("新增运单 ：{}", waybillStatus);
			i = waybillStatusMapper.insertOrUpdate(waybillStatus);
		} else {
			Date updateTime = new Date();
			String status = jsonObject.getString("status");
			if ("-1".equals(status)) {
				status = "4";
			} else if ("99".equals(status)) {
				status = "7";
			} else {
				status = "3";
			}
			String code = jsonObject.getString("code");
			i = waybillStatusMapper.update(status, code, updateTime);
			log.info("修改运单状态 ：{}", waybillStatus);
		}
	}

}
