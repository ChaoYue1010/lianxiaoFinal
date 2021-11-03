package com.zyhn.controller;

import com.alibaba.fastjson.JSONObject;
import com.zyhn.service.IPlanStateService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wcy
 * @date 2021/9/16 下午4:51
 */
@RestController
@RequestMapping(value = "/api/v1/planState")
public class PlanStateRestController {

	@Resource
	private IPlanStateService iPlanStateService;
	/**
	 * 查询code
	 * @param
	 * @return
	 */
	@GetMapping(value = "/select")
	public List<String> select (String code) {
		return iPlanStateService.selectCode(code);
	}

	/**
	 * 新增
	 * @param jsonData
	 * @return
	 */
	@PostMapping(value = "/addPlanState", produces = "application/json")
	public int addPlanState(@RequestBody JSONObject jsonData) {
		return iPlanStateService.addPlanState(jsonData);

	}
	/**
	 * 修改
	 * @param jsonData
	 * @return
	 */
	@PostMapping(value = "/updatePlanState", produces = "application/json")
	public int updatePlanState(@RequestBody JSONObject jsonData) {
		return iPlanStateService.updatePlanState(jsonData);

	}


}
