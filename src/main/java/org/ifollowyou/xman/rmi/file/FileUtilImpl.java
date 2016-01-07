package org.ifollowyou.xman.rmi.file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FileUtilImpl extends UnicastRemoteObject implements IFileUtil {

    protected FileUtilImpl() throws RemoteException {
        super();
    }

    private static final long serialVersionUID = 7594622080290821912L;

    public byte[] downloadFile(String fileName) throws RemoteException {

        File file = new File(fileName);
        byte buffer[] = new byte[(int) file.length()];
        int size = buffer.length;

        System.out.println("download file size = " + size + "b");

        if (size > 1024 * 1024 * 10) {//限制文件大小不能超过10M，文件太大可能导制内存溢出！
            throw new RemoteException("Error:<The File is too big!>");
        }

        try {
            BufferedInputStream input = new BufferedInputStream(
                    new FileInputStream(fileName));

            input.read(buffer, 0, buffer.length);
            input.close();
            System.out.println("Info:<downloadFile() hed execute successful!>");

            return buffer;
        } catch (Exception e) {
            System.out.println("FileUtilImpl: " + e.getMessage());
            e.printStackTrace();

            return null;
        }
    }
}