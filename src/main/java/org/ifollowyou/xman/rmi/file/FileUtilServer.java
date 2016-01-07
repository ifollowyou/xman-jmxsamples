package org.ifollowyou.xman.rmi.file;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class FileUtilServer {

    public static void main(String argv[]) {
        try {
            IFileUtil file = new FileUtilImpl();
            LocateRegistry.createRegistry(1099);
            // 加上此程序，就可以不要在控制台上开启RMI的注册程序，1099是RMI服务监视的默认端口

            Naming.rebind("rmi://127.0.0.1/FileUtilServer", file);
            System.out.print("Ready");
        } catch (Exception e) {
            System.out.println("FileUtilServer: " + e.getMessage());

            e.printStackTrace();
        }
    }
}