package com.zyhn.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author wcy
 * @date 2021/9/16 下午4:47
 */
@Data
public class PlanState {

	/**主键id**/
	private Integer id;

	/**业务类型**/
	private String type;

	/**业务唯一码**/
	private String code;

	/**状态**/
	private String status;

	/**实发量**/
	private String actualQuantity;

	/**作废原因**/
	private String cancelReason;

	/**作废完成时间**/
	private String recordTime;

	/**创建时间**/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createAt;

	/**修改时间**/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateAt;

}
