package com.test.version001;

/**
 * @Author ：xiaoyijia
 * @Date ：2018/12/19
 */
public class MyServicesImpl2  implements  MyServices{
    @Override
    public void test(String str) {
        System.out.println("--------test()方法"+ str);
        //此处直接调用 不会走aop代理了
        test2();
    }

    @Override
    public void test2() {
        System.out.println("-------test2()方法-------");
    }

    @Override
    public void abc(){
        System.out.println("-------abc()方法-------");
    }

}
