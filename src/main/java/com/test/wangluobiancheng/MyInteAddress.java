package com.test.wangluobiancheng;
import java.net.InetAddress;

/**
 * @Author ：xiaoyijia
 * @Date ：2018/12/20
 */
public class MyInteAddress {
    public static void main(String[] args) throws  Exception{
        InetAddress inetAddress = InetAddress.getByName("ytx5.com");
        System.out.println(inetAddress);
        //两个方法
        System.out.println(inetAddress.getHostName());
        System.out.println(inetAddress.getHostAddress());
        //获取本机的IP地址
        InetAddress inetLocal = InetAddress.getLocalHost();
        System.out.println(inetLocal);
    }

}
