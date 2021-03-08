package com.chen.demo03;

public class Client {
    public static void main(String[] args) {
        //真实角色
        Host host = new Host();
        //代理角色
        ProxyInvocationHandler proxy = new ProxyInvocationHandler();
        //通过调用程序处理角色来处理我们要调用的额接口对象
        proxy.setRent(host);
        Rent proxy1 = (Rent) proxy.getProxy();//这里的proxy就是动态代理
        proxy1.rent();
    }
}
