package com.zyhn.controller;

import com.alibaba.fastjson.JSONObject;
import com.zyhn.service.IWaybillStatusService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wcy
 * @date 2021/11/5 下午4:29
 */
@RestController
@RequestMapping(value = "/api/v1/waybillStatus")
public class WaybillStatusRestController {

	@Resource
	private IWaybillStatusService iWaybillStatusService;

	/**
	 * 新增修改
	 * @param jsonData
	 * @return
	 */
	@PostMapping(value = "/addOrUpdateWaybillStatus", produces = "application/json")
	public String addOrUpdateWaybillStatus(@RequestBody JSONObject jsonData) {
		iWaybillStatusService.addOrUpdateWaybillStatus(jsonData);

		return "ok";
	}

}
