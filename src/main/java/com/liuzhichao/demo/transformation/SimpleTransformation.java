package com.liuzhichao.demo.transformation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.liuzhichao.demo.model.DatabasesDto;

/**
 * 简单的转换
 * author : liuzhichao
 * version:
 * date : 2019.10.02 14:43:32
 */
public class SimpleTransformation {

    /**
     * JSON.toJSONString(init()) 格式化时会将空值过滤掉, 即JSON串中没有key
     * 可以通过设置以下参数将空值转为"": 比如 name: ""
     * SerializerFeature.WriteMapNullValue 将对象中的空值保留key, 赋值null; SerializerFeature.WriteNullStringAsEmpty 将null转为""
     * JSON.toJSONString(init(), SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty)
     * <p>
     * SerializerFeature的几种用法
     * QuoteFieldNames: 输出key时是否使用双引号, 默认为true
     * WriteMapNullValue: 是否输出值为null的字段, 默认为false
     * WriteNullNumberAsZero: 数值字段如果为null, 输出为0, 而非null
     * WriteNullListAsEmpty: List字段如果为null, 输出为[], 而非null
     * WriteNullStringAsEmpty: 字符类型字段如果为null, 输出为”“, 而非null
     * WriteNullBooleanAsFalse: Boolean字段如果为null, 输出为false, 而非null
     */

    private static DatabasesDto databasesDto = new DatabasesDto();

    // 1.JavaBean-->JSON
    public static String test01() {
        // 1.JavaBean转换为JSON格式的字符串
        String json = JSONObject.toJSONString(init());
        System.out.println(json);
        return json;
    }

    // 2.JSON-->JSONObject
    public static JSONObject test02() {
        // 1.JavaBean转换为JSON格式的字符串
        String json = JSONObject.toJSONString(init());
        // 2.String(JSON格式,对象的toString()方法不可)转换为JSONObject格式
        // Feature.OrderedField参数保证键值对有序[A-Z],否则键值对没有顺序
        JSONObject jsonObject = JSONObject.parseObject(json, Feature.OrderedField);
        System.out.println(jsonObject);
        return jsonObject;
    }

    // 3.JSON(JSONObject)-->JavaBean
    public static DatabasesDto test03() {
        // JavaBean转换为JSON格式的字符串
        String json = JSONObject.toJSONString(init());
        // 1.用parseObject()方法,入参为String类型,且该String必须是JSON格式的(键值对,对象的toString()方法不能直接转)
        DatabasesDto res = JSONObject.parseObject(json, DatabasesDto.class);
        System.out.println(res);
        // 2.用toJavaObject()方法,入参为JSONObject类型(父类JSON也可)
        JSONObject jsonObject = JSONObject.parseObject(json);
        res = JSONObject.toJavaObject(jsonObject, DatabasesDto.class);
        System.out.println(res);
        return res;
    }

    // 4.List<T>-->JSON
    public static String test04() {
        // 1.将List<T>集合转换为JSON格式的字符串
        String json = JSONObject.toJSONString(initList());
        System.out.println(json);
        // 2.将List<T>集合转换为JSON格式的字符串,作用同上
        String jsonObject = (String) JSONObject.toJSON(json);
        System.out.println(jsonObject);
        return json;
    }

    // 5.JSON-->List<T>
    public static List<DatabasesDto> test05() {
        // 1.将List<T>集合转换为JSON格式的字符串
        String json = JSONObject.toJSONString(initList());
        System.out.println(json);
        // 2.JSON格式的字符串转为List<T>
        List<DatabasesDto> list = JSONObject.parseArray(json, DatabasesDto.class);
        System.out.println(list);
        return list;
    }

    public static void main(String[] args) {
        test05();
    }

    public static DatabasesDto init() {
        databasesDto.setName("test");
        databasesDto.setDbSize(1001L);
        databasesDto.setTableCount(1001);
        databasesDto.setOwnerName("test");
        databasesDto.setApprovalTime(new Date());
        return databasesDto;
    }

    public static List<DatabasesDto> initList() {
        List<DatabasesDto> list = new ArrayList<>();
        DatabasesDto dto = new DatabasesDto();
        dto.setName("test02");
        list.add(dto);
        list.add(init());
        return list;
    }

}
