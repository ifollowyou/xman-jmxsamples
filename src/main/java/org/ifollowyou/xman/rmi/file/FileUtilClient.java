package org.ifollowyou.xman.rmi.file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.rmi.Naming;

public class FileUtilClient {

    public static void main(String args[]) {
        String ip = "127.0.0.1";
        String fileName = "README.md";
        String dir = "c:/" + fileName;

        try {
            String name = "rmi://" + ip + "/FileUtilServer";
            IFileUtil fileUtil = (IFileUtil) Naming.lookup(name);

            byte[] filedata = fileUtil.downloadFile(fileName);

            if (filedata == null) {
                System.out.println("Error：<filedata is null!>");
                System.exit(0);
            }

            File file = new File(dir);
            System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());
            BufferedOutputStream output = new BufferedOutputStream(
                    new FileOutputStream(file.getAbsolutePath()));

            output.write(filedata, 0, filedata.length);
            output.flush();
            output.close();

            System.out.println("~~~~~End~~~~~");
        } catch (Exception e) {
            System.err.println("FileUtilServer exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}