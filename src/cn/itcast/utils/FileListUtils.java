package cn.itcast.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;

/**
 * codening:utf-8
 *
 * @author :FileListUtils
 * @time :2019.07.09,15:53
 * @file :cn.itcast.cn.itcast.utils.FileListUtils.jave
 */
public class FileListUtils {
    public static <T> T request2Object(HttpServletRequest request,Class<T> Objectclass){
        T newInstance = null;
        try {
            //反射创建需要封装的对象
            newInstance = Objectclass.newInstance();
            Enumeration<String> parameterNames = request.getParameterNames();
            while (parameterNames.hasMoreElements()){
                String key = parameterNames.nextElement();
                String value = request.getParameter(key);
                BeanUtils.setProperty(newInstance,key,value);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return newInstance ;
    }


}
