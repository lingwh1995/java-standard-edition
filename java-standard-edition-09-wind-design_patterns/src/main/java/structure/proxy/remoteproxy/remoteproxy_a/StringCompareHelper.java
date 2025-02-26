package structure.proxy.remoteproxy.remoteproxy_a;

/**
 * CompareHellper接口的其中一种实现. 用于处理String类型.
 * @author ronin
 * @version V1.0
 * @since 2019/9/24 17:41
 */

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StringCompareHelper extends UnicastRemoteObject implements CompareHelper<String> {
    protected StringCompareHelper() throws RemoteException {
    }

    @Override
    public boolean compare(String object1, String object2) throws RemoteException {
        return object1.compareTo(object2) > 0;
    }

    @Override
    public String append(String object1, String object2) throws RemoteException {
        return object1 + object2;
    }
}
