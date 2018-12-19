package com.services;
import com.bean.User;
/**
 * @Author ：xiaoyijia
 * @Date ：2018/11/15
 */
public interface UserService {

    Integer addUser(User user);

    Integer getUserCount();

    Integer insertUser(User user);
}
