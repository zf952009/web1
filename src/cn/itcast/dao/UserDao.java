package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;
import java.util.Map;

/**
 * codening:utf-8
 *
 * @author :UserDao
 * @time :2019.07.12,13:32
 * @file :cn.itcast.dao.UserDao.jave
 */
public interface UserDao {
    void add(User user);
    Map find(User user);
    void register(User user);
    Map login(User user);
    List getAll();
}
