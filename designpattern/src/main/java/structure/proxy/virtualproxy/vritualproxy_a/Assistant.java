package structure.proxy.virtualproxy.vritualproxy_a;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/9/24 18:13
 */
public class Assistant implements Approvable{
    List<String> orders;
    volatile Boss boss;

    public Assistant() {
        orders = new LinkedList<>();
    }

    public void addOrder(String order) {
        if (boss != null) {
            System.out.println("Boss亲自将<" + order + ">任务添加到列表");
            boss.addOrder(order);
        } else {
            System.out.println("助手将<" + order + ">任务添加到列表");
            this.orders.add(order);
        }
    }

    @Override
    public void approve() {
        inviteBoss();
        boss.approve();
    }

    private void inviteBoss() {
        if (boss == null) {
            synchronized (this) {
                if (boss == null) {
                    boss = new Boss(orders);
                }
            }
        }
    }
}
