package com.dao;

import com.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.mapping.StatementType;

public interface UserDAO {

    @Insert("INSERT INTO user (name, passwd, appid) value (#{user.name}, #{user.passwd}, #{user.appid})")
    @SelectKey(before = false, keyProperty = "user.id", resultType = Integer.class, statementType = StatementType.STATEMENT, statement = "SELECT LAST_INSERT_ID() AS id")
    Integer addUser(@Param("user") User user);

    Integer getUserCount();

    @Insert("INSERT INTO user (name, passwd, appid) value (#{user.name}, #{user.passwd}, #{user.appid})")
    @SelectKey(before = false, keyProperty = "user.id", resultType = Integer.class, statementType = StatementType.STATEMENT, statement = "SELECT LAST_INSERT_ID() AS id")
    Integer insertUser(@Param("user") User user);
}