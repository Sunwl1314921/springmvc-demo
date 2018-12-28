package com.test;

import com.bean.User;
import com.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author ：xiaoyijia
 * @Date ：2018/12/19
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/spring-dao.xml");

        UserService user = applicationContext.getBean(UserService.class);
        User u = new User(1, "三四十", "123pass", "123app");
        user.addUser(u);

        //测试git  版本回退
    }
}
