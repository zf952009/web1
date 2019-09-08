package cn.itcast.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * codening:utf-8
 *
 * @author :HibernateUtils
 * @time :2019.07.09,13:45
 * @file :cn.itcast.cn.itcast.utils.HibernateUtils.jave
 */
public class HibernateUtils {
    private static SessionFactory sessionFactory = null;
    static {
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
    }
    //获取全新的session
    public static Session openSession(){
        return sessionFactory.openSession();

    }
    //获取与线程绑定的session
    public static Session getSession(){
        return sessionFactory.getCurrentSession();
    }
}
