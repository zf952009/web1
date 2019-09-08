package cn.itcast.test;

import cn.itcast.dao.FileListDao;
import cn.itcast.dao.impl.FileListDaoImpl;
import cn.itcast.domain.File_List;
import cn.itcast.service.FileListService;
import cn.itcast.service.impl.FileListServiceImpl;
import cn.itcast.utils.HibernateUtils;
import com.alibaba.fastjson.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import java.io.Serializable;
import java.util.*;

/**
 * codening:utf-8
 *
 * @author :FileListTest
 * @time :2019.07.09,13:56
 * @file :cn.itcast.test.FileListTest.jave
 */
public class FileListTest {
    @Test
    public void testGetAll() {
        FileListService fileListService = new FileListServiceImpl();
        List<File_List> all = fileListService.getAll();
        System.out.println(all);
    }

    @Test
    public void testFind() {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        File_List fileList = new File_List();
        fileList.setId(12);
        fileList.setName("jdbc");
        String hql = "from File_List where id = ? or name like :name";
        Query query = session.createQuery(hql);
        query.setParameter(0, fileList.getId());
        query.setParameter("name", "%" + fileList.getName() + "%");

        List list = query.list();
        System.out.println(list);
        transaction.commit();
    }

    @Test
    public void testFind1() {
        FileListDao fileListDao = new FileListDaoImpl();
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        File_List fileList = new File_List();
        fileList.setId(12);
        fileList.setName("jdbc");

        List<File_List> file_lists = fileListDao.find(fileList);
        System.out.println(file_lists.size());
        transaction.commit();
    }

    @Test
    public void testFind2() {
        FileListService fileListService = new FileListServiceImpl();
        Session session = HibernateUtils.getSession();
        File_List fileList = new File_List();
        fileList.setId(1233333);
        fileList.setName("jdbc56596262");
        List<File_List> file_lists = fileListService.find(fileList);
        System.out.println(file_lists);
    }

    @Test
    //数据维护，给所有的数据添加可读取标记：0，不可读标记：1
    public void test2Res() {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from File_List where id=?");
        query.setParameter(0, 1);
        List list = query.list();
        File_List o = (File_List) list.get(0);
        o.setRes(0);
        Serializable save = session.save(o);
        System.out.println(save);
        transaction.commit();
    }

    @Test
    public void testDel() {
        FileListService fileListService = new FileListServiceImpl();
        String delete = fileListService.delete(850);
        System.out.println(delete);

    }

    @Test
    public void testJSON() {
        File_List fileList = new File_List();
        fileList.setId(12);
        fileList.setName("邹芳");
        fileList.setRes(0);
        fileList.setUrl("http://www.zoufang.com");
        JSONObject jsonObject = JSONObject.fromObject(fileList);
        String string = jsonObject.toString();
        System.out.println(string);

        FileListService fileListService = new FileListServiceImpl();
        List<File_List> all = fileListService.getAll();
        JSONArray jsonArray = JSONArray.fromObject(all);
        Object[] objects = jsonArray.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }


        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", "zoufang");
        map.put("age", "18");
        map.put("url", "http://www.zoufang.com");
        JSONArray jsonArray1 = JSONArray.fromObject(map);
        String string1 = jsonArray1.toString();
        System.out.println(string1);

        List<String> list = new LinkedList<>();
        ((LinkedList<String>) list).addLast("zoufang");
        ((LinkedList<String>) list).addLast("age:18");
        ((LinkedList<String>) list).addLast("url");
        JSONArray jsonArray4 = JSONArray.fromObject(list);
        String string2 = jsonArray4.toString();
        System.out.println(string2);
    }

    @Test
    public void testJSON2Obj() {
        String json = "[{'res':0,'name':'测试文章','id':849,'url':'测试文章'}," +
                "{'res':0,'name':'测试文章','id':849,'url':'测试文章'}," +
                "{'res':0,'name':'测试文章','id':849,'url':'测试文章'}," +
                "{'res':0,'name':'测试文章','id':849,'url':'测试文章'}," +
                "]";

        JSONArray jsonArray = JSONArray.fromObject(json);
        Object o = (File_List) JSONArray.toArray(jsonArray, File_List.class);
        System.out.println(o.toString());
        /*JSONObject jsonObject = JSONObject.fromObject(json);
        File_List fileList = (File_List) JSONObject.toBean(jsonObject, File_List.class);
        System.out.println(fileList);*/

    }

    @Test
    public void testFastJSON() {
        File_List fileList = new File_List();
        fileList.setUrl("http://www.zoufang.com");
        fileList.setName("zoufang");
        String string = JSON.toJSONString(fileList);
        System.out.println(string);

        File_List fileList1 = new File_List();
        fileList1.setName("邹芳");
        fileList1.setId(16);
        List<File_List> lists = new LinkedList<File_List>();
        ((LinkedList<File_List>) lists).addLast(fileList);
        ((LinkedList<File_List>) lists).addLast(fileList1);
        String s = JSON.toJSONString(lists);
        System.out.println(s);

        Map<String, File_List> map = new LinkedHashMap<>();
        map.put("f1", fileList);
        map.put("f2", fileList1);
        String string1 = JSON.toJSONString(map);
        System.out.println(string1);

        String jsonStr = "{'res':0,'name':'测试文章','id':849,'url':'测试文章'}";
        File_List fileList2 = JSON.parseObject(jsonStr, File_List.class);
        System.out.println(fileList2);

        String jsonList = "[{'res':0,'name':'测试文章','id':849,'url':'测试文章'}," +
                "{'res':0,'name':'测试文章','id':849,'url':'测试文章'}," +
                "{'res':0,'name':'测试文章','id':849,'url':'测试文章'}," +
                "{'res':0,'name':'测试文章','id':849,'url':'测试文章'}," +
                "]";
        List<File_List> lists1 = JSON.parseArray(jsonList, File_List.class);
        System.out.println(lists1);

        String jsonMap = "{\"name\":\"邹芳\",\"age\":\"18\"}";
        Map<String, String> map1 = JSON.parseObject(jsonMap, Map.class);
        System.out.println(map1);

        String jsonMapObj = "{\"f1\":{\"name\":\"zoufang\",\"url\":\"http://www.zoufang.com\"},\"f2\":{\"id\":16,\"name\":\"邹芳\"}}";
        Map<String, File_List> mapobj = JSON.parseObject(jsonMapObj, Map.class);
        System.out.println(mapobj);

    }

    @Test
    public void testSubName() {
        String path = "D:\\毕业照片\\视频\\电影\\宠物坟场";
        String[] split = path.split("\\\\");
        String s = split[split.length - 1];
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
    }

    @Test
    public void FileAndFile() {
        Random random = new Random();
        int num = random.nextInt(999999);
        String randomNum = String.valueOf(num);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 6 - randomNum.length(); i++) {
            stringBuffer.append("0");
        }
        System.out.println(stringBuffer.append(randomNum).toString());
        System.out.println(stringBuffer.toString());
        System.out.println(randomNum);
    }

    @Test
    public void FileList() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int fileNumber = 21; fileNumber <= 50; fileNumber++) {
            stringBuffer.append("you-get https://www.bilibili.com/bangumi/play/ep1390"+fileNumber+"?from=search&seid=9751635674623286499 ");
        }
        System.out.println(stringBuffer.toString().trim());
    }
}
