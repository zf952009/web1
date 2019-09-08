package cn.itcast.test;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;
import cn.itcast.utils.MessageUtils;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

/**
 * codening:utf-8
 *
 * @author :UserTest
 * @time :2019.07.12,13:59
 * @file :cn.itcast.test.UserTest.jave
 */
public class UserTest {
    @Test
    public void testAdd() {
        User user =  new User();
        String password = MessageUtils.SHA_256("123456");
        String name = "admin";
        user.setPassword(password);
        user.setName(name);
        UserService userService = new UserServiceImpl();
        userService.add(user);
    }

    @Test
    public void testFind() {
        User user = new User();
        user.setName("admin2");
        String password = MessageUtils.MessageDigest("123456","SHA-256");
        user.setPassword(password);
        UserService userService = new UserServiceImpl();
        Map map = userService.find(user);
        String string = JSON.toJSONString(map);
        Object user1 = map.get("user");
        System.out.println(user1);
        System.out.println(map);
        System.out.println(string);
    }

    @Test
    public void testAdd1() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        User user = new User();
        user.setName("admin33");
        user.setPassword("1234562");
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(user.getPassword().getBytes("UTF-8"));
        byte[] digest = messageDigest.digest();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < digest.length; i++) {
            stringBuffer.append(Integer.toHexString(0xFF & digest[i]));
        }
        System.out.println(stringBuffer);
    }

    @Test
    public void test2(){
        String s = MessageUtils.MessageDigest("123456", "MD5");
        System.out.println(s);
        String s1 = MessageUtils.MessageDigest("123456", "SHA");
        System.out.println(s1);
        String s2 = MessageUtils.MessageDigest("123456","SHA-256");
        System.out.println(s2);
        String s3 = MessageUtils.MessageDigest("123456","HMAC");
        System.out.println(s3);
    }
    @Test
    public void test3(){
        UserService userService = new UserServiceImpl();
        User user =  new User();
        String password = MessageUtils.SHA_256("123456");
        String name = "admin";
        user.setPassword(password);
        user.setName(name);
        Map login = userService.login(user);
        System.out.println(login);
        List all = userService.getAll();
        System.out.println(all);
    }
}
