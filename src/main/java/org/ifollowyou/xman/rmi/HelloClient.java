package org.ifollowyou.xman.rmi;

import java.rmi.Naming;

public class HelloClient {

    public static void main(String args[]) {
        try {
            //在RMI服务注册表中查找名称为RHello的对象，并调用其上的方法 
            IHello rhello = (IHello) Naming.lookup("//localhost:8888/RHello");

            System.out.println(rhello.helloWorld());
            System.out.println(rhello.sayHelloToSomeBody("xman"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}