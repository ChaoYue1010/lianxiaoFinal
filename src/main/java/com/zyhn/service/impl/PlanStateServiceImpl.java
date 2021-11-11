package com.zyhn.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zyhn.entity.PlanState;
import com.zyhn.mapper.PlanStateMapper;
import com.zyhn.service.IPlanStateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author wcy
 * @date 2021/9/16 下午4:52
 */
@Service
@Slf4j
public class PlanStateServiceImpl implements IPlanStateService {

	@Resource
	private PlanStateMapper planStateMapper;

	/**
	 * 新增
	 **/
	@Override
	public int addPlanState(JSONObject jsonObject) {

		Date now = new Date();
		PlanState planState = JSONObject.parseObject(jsonObject.toString(), PlanState.class);
		planState.setCreateAt(now);
		log.info("新增 ：{}", planState);
		return planStateMapper.insert(planState);

	}
	/**
	 * 修改
	 **/
	@Override
	public int updatePlanState(JSONObject jsonObject) {

		Date now = new Date();
		PlanState planState = JSONObject.parseObject(jsonObject.toString(), PlanState.class);
		planState.setUpdateAt(now);
		log.info("修改 ：{}", planState);
		return planStateMapper.updatePlanState(planState);

	}

	@Override
	public List<String> selectCode(String code) {

		return planStateMapper.selectCode(code);
	}

}
