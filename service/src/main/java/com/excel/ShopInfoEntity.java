package com.excel;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


/**
 * 店铺基本信息表
 * 
 * @author yu
 * @email 
 * @date 2018-08-31 13:53:25
 */
@Data
@ToString
public class ShopInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增主键，店铺ID
	private Long id;
	//店铺名
	private String shopName;
	//门店雇员
	private String shopEmployee;
	//状态 1:可用0:不可用
	private Integer status;
	//添加时间
	private Date addTime;
	//更新时间
	private Date updateTime;
	//地址
	private String address;
	//电话
	private String phone;
	//区域
	private String region;
	//经度
	private Double latitude;
	//纬度
	private Double longitude;
	//门店编码
	private String werks;
	//门店编码
	private String city;
	//门店头像
	private String head;
	//门店描述
	private String descible;

}
