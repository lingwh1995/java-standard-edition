package org.bluebridge.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/9/24 16:38
 */
public interface MyRemote extends Remote{
    public String sayHello() throws RemoteException;
    public String sayHello(String message) throws RemoteException;

}
