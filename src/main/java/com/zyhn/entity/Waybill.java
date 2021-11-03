package com.zyhn.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chaoyue
 */
@Data
public class Waybill implements Serializable {

	/**数据**/
	private String jsonData;

	/**创建时间**/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createAt;

}
