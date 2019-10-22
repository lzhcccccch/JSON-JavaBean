package com.liuzhichao.demo.transformation;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.liuzhichao.demo.jsonutils.JsonUtils;

/** 
* @author : liuzhichao
* @date   : 2019.10.16 15:21:55
* @version: 
* @description: 复杂的转换(嵌套)
*/
public class ComplexTransformation {

	static String string = JsonUtils.getJsonString();
	
	/**
	 * 	1.JSONObject的几点用法
	 */
	@SuppressWarnings("unused")
	public static void test01(String string) {
		// 1.将JSON格式的字符串转为JSONObject
		JSONObject jsonObject = JSONObject.parseObject(string);
		// 2.获取JSON串中键为data的值(值不能是List类型)
		JSONObject jsonObject1 = jsonObject.getJSONObject("data");
		// 3.获取JSON串中键为tenantDatabaseList的List对象
		JSONArray jsonArray = jsonObject1.getJSONArray("tenantDatabaseList");
		// 4.获取JSON串中基本类型的值[getString(),getInteger()...]
		Integer statusCode = jsonObject.getInteger("statusCode");
		String msg = jsonObject.getString("msgDesc");
	}
	
	// 1.JavaBean<List<T>>多层嵌套
	/**
	 * 	对于多层的嵌套转换,可分解逐步转换,使用JSONObject的方法进行获取,逐步转换
	 * 	对于多层的List嵌套要一步转换到位,可使用net.sf.json.JSONObject类进行
	 */
	
}
