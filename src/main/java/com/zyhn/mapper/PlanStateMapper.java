package com.zyhn.mapper;

import com.zyhn.entity.PlanState;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author wcy
 * @date 2021/9/16 下午4:52
 */
@Mapper
public interface PlanStateMapper {

	@Insert({ "insert into planstate(type, code, status, actualQuantity, cancelReason, recordTime, create_at) values (#{type}, #{code}, #{status}, #{actualQuantity}, #{cancelReason}, #{recordTime}, #{createAt})"})
	int insert(PlanState planState);

	int updatePlanState(PlanState planState);

	@Select({ "SELECT `code` from planstate WHERE `code` = #{code}"})
	List<String> selectCode(String code);

	@Delete("DELETE FROM planstate WHERE DATE_SUB(CURDATE(), INTERVAL 60 DAY) >= date(create_at)")
	int delete();

}
