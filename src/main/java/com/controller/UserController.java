package com.controller;
import com.bean.User;
import com.datasource.DynamicDataSource;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired(required=true)
    private UserService userService;

    @GetMapping(value = "/test")
    public String test(){
        return "ok";
    }

    /**
     * http://localhost:8080/user/add?name=abc&passwd=123&appid=95955542783
     * 添加用户
     */
    @GetMapping(value = "/add")
    public User save(@RequestParam(value = "name") String name,
                     @RequestParam(value = "passwd",defaultValue = "0") String passwd,
                     @RequestParam(value = "appid",defaultValue = "0") String appid){
        //切换数据源，设置后 可以随时切换过来
        DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_MYSQL);

        User user = new User(name,passwd,appid);
        //执行插入，返回主键ID
        userService.addUser(user);
        return user;
    }

    /**
     * http://localhost:8080/user/list
     */
    @GetMapping(value = "/list")
    public int getUserList(){
        //切换数据源，设置后 可以随时切换过来
        DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_MSSQL);
        return userService.getUserCount();
    }
}
