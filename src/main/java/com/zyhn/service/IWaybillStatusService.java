package com.zyhn.service;

import com.alibaba.fastjson.JSONObject;


/**
 * @author chaoyue
 */
public interface IWaybillStatusService {

	void addOrUpdateWaybillStatus(JSONObject waybill);

}