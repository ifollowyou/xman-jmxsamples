package org.ifollowyou.xman.jmx.notification;

import com.sun.jdmk.comm.HtmlAdaptorServer;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class MyNotificationAgent implements NotificationListener {
    private MBeanServer mbs = null;

    public MyNotificationAgent() {

        // 使用该MBeanServer可以通过jconsole来查看MBean情况
        mbs = ManagementFactory.getPlatformMBeanServer();
        // 使用该MBeanServer需要通过访问页面http://localhost:9092来查看页面
        mbs = MBeanServerFactory.createMBeanServer("HelloSpy");

        HtmlAdaptorServer adapter = new HtmlAdaptorServer();
        adapter.setPort(9092);

        MyNotification hw = new MyNotification();

        ObjectName adapterName = null;
        ObjectName helloWorldName = null;

        try {
            helloWorldName = new ObjectName("HelloSpy:name=helloJmx");
            mbs.registerMBean(hw, helloWorldName);

            adapterName = new ObjectName("HelloSpy:name=htmladapter,port=9092");

            mbs.registerMBean(adapter, adapterName);
            hw.addNotificationListener(this, null, null);
            adapter.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unused")
    public static void main(String args[]) {
        MyNotificationAgent agent = new MyNotificationAgent();
    }

    public void handleNotification(Notification notif, Object handback) {
        System.out.println("Receiving notification...");
        System.out.println(notif.getType());
        System.out.println(notif.getMessage());
    }

}
