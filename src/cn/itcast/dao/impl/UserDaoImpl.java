package cn.itcast.dao.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * codening:utf-8
 *
 * @author :UserDaoImpl
 * @time :2019.07.12,13:33
 * @file :cn.itcast.dao.impl.UserDaoImpl.jave
 */
public class UserDaoImpl implements UserDao {
    @Override
    public List getAll() {
        Session session = HibernateUtils.getSession();
        return session.createQuery("from User ").list();
    }

    @Override
    public void register(User user) {
        this.add(user);
    }

    @Override
    public Map login(User user) {
        return this.find(user);
    }

    @Override
    public void add(User user) {
        Session session = HibernateUtils.getSession();
        session.save(user);
    }

    @Override
    public Map find(User user) {
        Session session = HibernateUtils.getSession();
        String name = user.getName();
        String password = user.getPassword();
        Map<String, String> map = new LinkedHashMap<>();
        LinkedHashMap<String, Object> userMap = new LinkedHashMap<>();
        if (name == null) {
            map.put("name", "The user does not exist");
        }
        if (password == null) {
            map.put("password", "Password is empty");
        }
        if (name != null && password != null) {
            //查询用户名
            Query query = session.createQuery("from User where name=:name");
            List list = query.setParameter("name", name).list();
            if (list.size() == 1) {
                User o = (User) list.get(0);
                String password2 = user.getPassword();
                String password1 = o.getPassword();
                if (password1.length() != password2.length()) {
                    map.put("password", "User name and password do not match");
                } else {
                    for (int i = 0; i < password1.length(); i++) {
                        if (password1.charAt(i) != password2.charAt(i)) {
                            map.put("password", "User name and password do not match");
                        }
                    }
                    userMap.put("user", o);
                }

            } else {
                map.put("name", "The user does not exist");
            }
        }
        userMap.put("result", map);
        if (userMap.get("user")==null){
            userMap.put("user",user);
        }
        return userMap;
    }
}
