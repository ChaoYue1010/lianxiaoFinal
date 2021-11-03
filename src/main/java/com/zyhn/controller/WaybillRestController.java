package com.zyhn.controller;

import com.alibaba.fastjson.JSONObject;
import com.zyhn.service.IWaybillService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chaoyue
 */
@RestController
@RequestMapping(value = "/api/v1/waybill")
public class WaybillRestController {

	@Resource
	private IWaybillService iWaybillService;

	/**
	 * 新增
	 * @param jsonData
	 * @return
	 */
	@PostMapping(value = "/addWaybill", produces = "application/json")
	public int addWaybill(@RequestBody JSONObject jsonData) {
		return iWaybillService.addWaybill(jsonData);

	}


}