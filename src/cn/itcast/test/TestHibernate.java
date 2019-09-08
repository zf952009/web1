package cn.itcast.test;

import cn.itcast.dao.Tb_WebDao;
import cn.itcast.dao.impl.Tb_WebDaoImpl;
import cn.itcast.domain.Tb_web;
import org.junit.Test;

import java.util.List;

public class TestHibernate {
    @Test
    public void test1(){
        Tb_WebDao tb_webDao = new Tb_WebDaoImpl();
        List<Tb_web> all = tb_webDao.getAll();
        System.out.println(all);
    }
}
