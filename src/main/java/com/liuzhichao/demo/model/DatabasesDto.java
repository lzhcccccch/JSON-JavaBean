package com.liuzhichao.demo.model;

import lombok.Data;

import java.util.Date;

/** 
* @author : liuzhichao
* @date   : 2019.09.29 09:19:41
* @version: 
* @description: 
*/
@Data
public class DatabasesDto {

	private String name;

    private Integer tableCount;

    private Long dbSize;

    private String ownerName;

    private Date approvalTime;

}
