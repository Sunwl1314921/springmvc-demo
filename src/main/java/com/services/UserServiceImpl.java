package com.services;

import com.bean.User;
import com.dao.UserDAO;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author ：SunWenLong
 * @Date ：2018/11/15
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;


    @Transactional
    @Override
    public Integer addUser(User user) {
        Integer result = userDAO.addUser(user);

        try{
            //insertUser()方法 Propagation.REQUIRES_NEW
            //理想状态是 addUser() 插入成功insertUser()插入失败 回滚
            //实际结果addUser() 和insertUser() 都插入成功 没有回滚，
            // 解决方案：https://blog.csdn.net/qq_33863843/article/details/85091843
            User u2=new User(2,"电风扇地方","123pass","123app");
            //this 是当前对象  不走代理对象
//             this.insertUser(u2);
            //Transactional是通过aop代理来做的，直接调用的话 不会走代理
            //此处获取代理对象接口再调用方法才会走 aop事物代理
            ((UserService) AopContext.currentProxy()).insertUser(u2);
        }catch (Exception e){
            System.err.println(e);
        }

        return result;
    }


    @Override
    public Integer getUserCount() {
        return userDAO.getUserCount();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Integer insertUser(User user) {
        Integer result = userDAO.insertUser(user);
        //int i=1/0;
        return result;
    }
}
