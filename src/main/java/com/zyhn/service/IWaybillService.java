package com.zyhn.service;

import com.alibaba.fastjson.JSONObject;


/**
 * @author chaoyue
 */
public interface IWaybillService {

	/**
	 * 新增
	 * @param waybill
	 */
	int addWaybill(JSONObject waybill);


}