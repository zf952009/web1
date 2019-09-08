package cn.itcast.servler;

import java.util.Vector;

public class UserInfoList{
    private static UserInfoList userInfoList = new UserInfoList();
    private Vector vector = null;

    private UserInfoList(){
        this.vector=new Vector();
    }

    public static UserInfoList getInstance(){
        return userInfoList;
    }
    public boolean addUserInfoList(String user){
        if (user!=null){
            this.vector.add(user);
            return true;
        }else {
            return false;
        }
    }

    public Vector getList(){
        return vector;
    }

    public void removeUserInfo(String user){
        if (user!=null){
            vector.removeElement(user);
        }
    }
}