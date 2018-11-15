package com.services;

import com.bean.User;
import com.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author ：SunWenLong
 * @Date ：2018/11/15
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;


    @Override
    public Integer addUser(User user) {
        return userDAO.addUser(user);
    }

    @Override
    public Integer getUserCount() {
        return userDAO.getUserCount();
    }
}
