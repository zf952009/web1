package cn.itcast.utils;

import java.security.MessageDigest;

/**
 * codening:utf-8
 *
 * @author :MessageUtils
 * @time :2019.07.12,15:11
 * @file :cn.itcast.cn.itcast.utils.MessageUtils.jave
 */
public class MessageUtils {
    //md5加密
    public static String MD5(Object o){
        String s = String.valueOf(o);
        return MessageDigest(s, "MD5");
    }

    //sha-256加密
    public static String SHA_256(Object o){
        String s = String.valueOf(o);
        return MessageDigest(s,"SHA-256");
    }

    //sha加密
    public static String SHA(Object o){
        String s = String.valueOf(o);
        return MessageDigest(s,"SHA");
    }

    //消息加密
    public static String MessageDigest(String string, String algorithm) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(string.getBytes());
            byte[] digest = messageDigest.digest();
            for (int i = 0; i < digest.length; i++) {
                stringBuffer.append(Integer.toHexString(0xFF & digest[i]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }
}
