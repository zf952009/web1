package cn.itcast.json.google;

import com.google.gson.Gson;
import org.junit.Test;

/**
 * codening:utf-8
 *
 * @author :JSONTest
 * @time :2019.07.10,18:21
 * @file :cn.itcast.json.google.JSONTest.jave
 * google json解析用例
 */
public class JSONTest {
    @Test
    //json2object json 转换成基本数据类型
    public void test(){
        Gson gson = new Gson();
        Integer integer = gson.fromJson("100", int.class);
        System.out.println(integer);
    }
    @Test
    public void test1(){
        Gson gson = new Gson();
        String s = gson.toJson("{\"name\":\"邹芳\"}");
        System.out.println(s);

    }
}
