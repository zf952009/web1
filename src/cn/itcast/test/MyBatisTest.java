package cn.itcast.test;

import cn.itcast.utils.MyBatisUtlils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * codening:utf-8
 *
 * @author :MyBatisTest
 * @time :2019.07.17,23:05
 * @file :cn.itcast.test.MyBatisTest.jave
 */
public class MyBatisTest {

    @Test
    public void test() {
        SqlSession sqlSession = MyBatisUtlils.getSqlSession();
        Object selectOne = sqlSession.selectOne("test.findUserById", 12);
        System.out.println(selectOne);
    }

}
