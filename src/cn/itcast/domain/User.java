package cn.itcast.domain;

import cn.itcast.utils.MessageUtils;

/**
 * codening:utf-8
 *
 * @author :User
 * @time :2019.07.12,13:24
 * @file :cn.itcast.domain.User.jave
 */
public class User {
    private Integer id;
    private String name;
    private String password;
    private String email;

    public User() {
    }

    public User(Integer id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = MessageUtils.SHA_256(password);
    }
}
