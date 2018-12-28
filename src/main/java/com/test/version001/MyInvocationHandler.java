package com.test.version001;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author ：xiaoyijia
 * @Date ：2018/12/19
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    //方法一实现
    MyInvocationHandler(Object target) {
        this.target = target;
    }

    //方法二实现
    MyInvocationHandler(){}
    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("test")) {
            System.out.println("------目标方法--------");
        }
        return method.invoke(target, args);
    }

    //public static void main(String[] args) {
    //    MyInvocationHandler myInvocationHandler = new MyInvocationHandler(new MyServicesImpl());
    //
    //    MyServices myServices = (MyServices) Proxy.newProxyInstance(MyInvocationHandler.class.getClassLoader(),
    //            new Class[]{MyServices.class}, myInvocationHandler);
    //    myServices.test("aba");
    //    myServices.test2();
    //    myServices.abc();
    //}

    public static void main(String[] args) {
        //方法一实现
        //MyInvocationHandler myInvocationHandler = new MyInvocationHandler(new MyServicesImpl2());
        //
        //MyServices myServices = (MyServices) Proxy.newProxyInstance(MyInvocationHandler.class.getClassLoader(),
        //        new Class[]{MyServices.class}, myInvocationHandler);
        //myServices.test("aba");


        //方法二实现
        MyServices myServices = (MyServices)new MyInvocationHandler().bind(new MyServicesImpl2());
        myServices.test("aba");
    }
}