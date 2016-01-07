package org.ifollowyou.xman.rmi.file;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFileUtil extends Remote {

    public byte[] downloadFile(String fileName) throws RemoteException;

}