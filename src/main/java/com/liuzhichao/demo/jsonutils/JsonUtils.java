package com.liuzhichao.demo.jsonutils;

import java.io.*;

/** 
* @author : liuzhichao
* @date   : 2019.09.29 09:19:41
* @version: 
* @description: 
*/

public class JsonUtils {

    /**
     * 	读取json文件，返回json串
     * @param fileName
     * @return
     */
    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);

            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * @author : liuzhichao
     * @date   : 2019.10.16 15:15:23
     * @description: 获取JSON串
     * @return
     */
    public static String getJsonString() {
    	String path = JsonUtils.class.getClassLoader().getResource("example.json").getPath();
        String jsonString = JsonUtils.readJsonFile(path);
        return jsonString;
    }
    
//    public static void main(String[] args) {
//    	String path = JsonTest.class.getClassLoader().getResource("yunwang.json").getPath();
//        String s = JsonUtils.readJsonFile(path);
//        JSONObject jsonObject = JSON.parseObject(s);
//
////        JSONObject data = jsonObject.getJSONObject("data");
//        JSONArray tenantArray = jsonObject.getJSONObject("data").getJSONArray("tenantDatabaseList");
//        List<TenantDatabaseListDto> tenantDatabaseList = JSONObject.parseArray(tenantArray.toString(), TenantDatabaseListDto.class);
//        System.out.println(tenantDatabaseList);
//	}
    
}
