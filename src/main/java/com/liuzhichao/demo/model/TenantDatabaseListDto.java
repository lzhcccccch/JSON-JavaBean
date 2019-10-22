package com.liuzhichao.demo.model;
/** 
* @author : liuzhichao
* @date   : 2019.09.29 09:19:41
* @version: 
* @description: 
*/

import java.util.List;


import lombok.Data;

@Data
public class TenantDatabaseListDto {

	private String tenantId;
	
	private List<DatabasesDto> databases;
	
}
