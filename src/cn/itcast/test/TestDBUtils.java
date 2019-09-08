package cn.itcast.test;

import cn.itcast.c3p0.C3P0Utlis1;
import cn.itcast.domain.Tb_web;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class TestDBUtils {

    /*
    * 查询指列。指定列数
    * */
    @Test
    public void selectTesrAllByIndex(){
        QueryRunner queryRunner = new QueryRunner(C3P0Utlis1.getDataSource());
        String sql = "select id,name,url,web from tb_web";
        try {
            List<Integer> list = queryRunner.query(sql,new ColumnListHandler<Integer>(1));
            for (int id : list){
                System.out.println(id);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*
    * 查询指定的列,指定的列名
    * */
    @Test
    public void selectTesrAllByName(){
        QueryRunner queryRunner = new QueryRunner(C3P0Utlis1.getDataSource());
        String sql = "select id,name,url,web from tb_web";
        try {
           List<String> list = queryRunner.query(sql,new ColumnListHandler<String>("url"));
           for (String name : list){
               System.out.println(name);
           }
           
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *查询所有
     * 返回的是数据的结构是List<Map<String(字段名),Object(数据)>>
     *
     */
    @Test
    public void selecTestAll(){
        QueryRunner queryRunner = new QueryRunner(C3P0Utlis1.getDataSource());
        String sql = "select id,name,url,web from tb_web";
        try {
           List<Map<String,Object>> list  =queryRunner.query(sql,new MapListHandler());
           for (Map<String,Object> map : list){
               System.out.println(map);
           }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /*
    * 查询记录数
    *
    * */
    @Test
    public void seletCountTest(){
        QueryRunner queryRunner = new QueryRunner(C3P0Utlis1.getDataSource());
        String sql = "select count(*) from tb_web";
        try {
           long res= queryRunner.query(sql,new ScalarHandler<Long>());
           System.out.println(res);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*
    * 条件查询
    * */
    @Test
    public void selectByIdTest(){
        QueryRunner queryRunner = new QueryRunner(C3P0Utlis1.getDataSource());
        String sql = "select id,name,url,web from tb_web where id=?";
        try {
            Object[] params = {5};
            Tb_web list = queryRunner.query(sql,new BeanHandler<Tb_web>(Tb_web.class),params);
            //遍历结果集合
           System.out.println(list);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*
    * 查询数据
    * */
    @Test
    public void selecTest(){

        QueryRunner queryRunner = new QueryRunner(C3P0Utlis1.getDataSource());
        String sql = "select id,name,url,web from tb_web";
        try {
           List<Tb_web> list = queryRunner.query(sql, new BeanListHandler<Tb_web>(Tb_web.class));
           //遍历结果集合
            for (Tb_web web : list){
                System.out.println(web);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /*
    * 删除数据
    * */
    @Test
    public void deleteTest(){
        QueryRunner queryRunner = new QueryRunner(C3P0Utlis1.getDataSource());
        String sql = "delete from tb_web where id=?";
        Object[] params ={"15"};
        try {
            int resl = queryRunner.update(sql,params);
            if (resl>0){
                System.out.println("ok");
            }else {
                System.out.println("eroor");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*
    * 修改信息
    * */
    @Test
    public void setTest(){
        QueryRunner queryRunner = new QueryRunner(C3P0Utlis1.getDataSource());
        String sql = "update tb_web set name=? where id=?";
        Object[] params ={"ceshi1111","15"};
        try {
            int resl = queryRunner.update(sql,params);
            if (resl>0){
                System.out.println("ok");
            }else {
                System.out.println("eroor");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /*
    * 添加信息
    * */
    @Test
    public void addTest(){
        QueryRunner queryRunner = new QueryRunner(C3P0Utlis1.getDataSource());
        String sql = "insert into tb_web values(null,?,?,?)";
        Object[] params ={"ceshi","www.baidu.com","php"};
        try {
            int resl = queryRunner.update(sql,params);
            if (resl>0){
                System.out.println("添加ok");
            }else {
                System.out.println("eroor");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
