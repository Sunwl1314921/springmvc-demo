package com.services;
import com.bean.User;
/**
 * @Author ：SunWenLong
 * @Date ：2018/11/15
 */
public interface UserService {

    Integer addUser(User user);

    Integer getUserCount();
}
