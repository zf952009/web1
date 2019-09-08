package cn.itcast.service;

import cn.itcast.domain.User;

import java.util.List;
import java.util.Map;

/**
 * codening:utf-8
 *
 * @author :UserService
 * @time :2019.07.12,13:56
 * @file :cn.itcast.service.UserService.jave
 */
public interface UserService {
    void add(User user);
    Map find(User user);
    void regisrer(User user);
    Map login(User user);
    List getAll();
}
