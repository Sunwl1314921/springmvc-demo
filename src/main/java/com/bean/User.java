package com.bean;
import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String passwd;
    private String appid;

    public User(int id, String name, String passwd, String appid) {
        this.id = id;
        this.name = name;
        this.passwd = passwd;
        this.appid = appid;
    }

    public User(String name, String passwd, String appid) {
        this.name = name;
        this.passwd = passwd;
        this.appid = appid;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passwd='" + passwd + '\'' +
                ", appid='" + appid + '\'' +
                '}';
    }
}
