package com.zyhn.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wcy
 * @date 2021/11/3 下午5:44
 */
@Data
public class WaybillStatus implements Serializable {

	private String TRANS_NO;
	private String VEHICLE_NO;
	private String CARRIER_CODE;
	private String CARRIER_NAME;
	private String TRANS_MODE;
	private String ORDER_STATE;
	private String SEND_ADDRESS;
	private String RECV_ADDRESS;
	private String SHIPPING_ADDRESS;
	private String MATERIAL_TYPE_BIG;
	private String MATERIAL_TYPE_BIG_NAME;
	private String MATERIAL_TYPE_SMALL;
	private String MATERIAL_TYPE_SMALL_NAME;
	private String MATERIAL_CODE;
	private String MATERIAL_NAME;
	private String MATERIAL_SPEC;
	private String MATERIAL_PACK;
	private String MATERIAL_ITEM;
	private String HCS_GRADE_CODE;
	private String HCS_GRADE_NAME;
	private Double LOAD_QTY;
	private String PACK_UNIT;
	private String MANU_ENT_CODE;
	private String MANU_ENT_NAME;
	private String OWNER_ID;
	private String CONTACT_NUMBER;
	private String SOURCE_ID;
	private String SALE_DEALER_NAME;
	private String RECV_DEALER_NAME;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date EXPECTED_SEND_TIME;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date SEND_TIME;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date EXPECTED_RECV_TIME;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date RECV_TIME;
	private String ORDER_ID;
	private String ORDER_NO;
	private String SOURCE_SYS;
	private String CREATE_USER;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date CREATE_TIME;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date UPDATE_TIME;
	private String DELETE_STATE;
	private String STANDARD_MANU_ENT_CODE;
	private String STANDARD_MANU_ENT_NAME;
	private String OWNER_SECTOR_CODE;
	private String OWNER_NAME;
	private String TRANSFER_TYPE;
	private String ID_NUMBER;

}
