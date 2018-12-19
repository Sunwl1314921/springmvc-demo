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

    MyInvocationHandler(Object target) {
        this.target = target;
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
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(new MyServicesImpl2());

        MyServices myServices = (MyServices) Proxy.newProxyInstance(MyInvocationHandler.class.getClassLoader(),
                new Class[]{MyServices.class}, myInvocationHandler);
        myServices.test("aba");
    }
}
