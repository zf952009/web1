package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.utils.HibernateUtils;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Map;

/**
 * codening:utf-8
 *
 * @author :UserServiceImpl
 * @time :2019.07.12,13:57
 * @file :cn.itcast.service.impl.UserServiceImpl.jave
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public void add(User user) {
        Transaction transaction = HibernateUtils.getSession().beginTransaction();
        userDao.add(user);
        transaction.commit();
    }

    @Override
    public List getAll() {
        Transaction transaction = HibernateUtils.getSession().beginTransaction();
        List all = userDao.getAll();
        transaction.commit();
        return all;
    }

    @Override
    public void regisrer(User user) {
        this.add(user);
    }

    @Override
    public Map login(User user) {
        return this.find(user);
    }

    @Override
    public Map find(User user) {
        Transaction transaction = HibernateUtils.getSession().beginTransaction();
        Map map = userDao.find(user);
        transaction.commit();
        return map;
    }
}
