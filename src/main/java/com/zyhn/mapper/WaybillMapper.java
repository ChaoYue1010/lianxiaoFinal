package com.zyhn.mapper;

import com.zyhn.entity.Waybill;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author chaoyue
 */
@Mapper
public interface WaybillMapper {

	@Insert({ "insert into waybill(json_data, create_at) values (#{jsonData}, #{createAt})"})
	int insert(Waybill waybill);

	@Delete("DELETE FROM waybill WHERE DATE_SUB(CURDATE(), INTERVAL 60 DAY) >= date(create_at)")
	int delete();

}