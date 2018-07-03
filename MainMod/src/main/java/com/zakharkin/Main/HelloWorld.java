package com.zakharkin.Main;

import javax.management.*;

public class HelloWorld implements HelloWorldMBean/*, NotificationBroadcaster */{
    private String greeting = null;
    public HelloWorld(){
        this.greeting = "Hello World! I am a Standard MBean";
    }

    public HelloWorld( String greeting )
    {
        this.greeting = greeting;
    }

    @Override
    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public String getGreeting() {
        return greeting;
    }

    @Override
    public void printGreeting() {
        System.out.println( greeting );
    }

    @Override
    public void myOperation(String str) {
        System.out.println(str);
    }

    /*@Override
    public void addNotificationListener(NotificationListener listener, NotificationFilter filter, Object handback)
            throws IllegalArgumentException {

    }

    @Override
    public void removeNotificationListener(NotificationListener listener) throws ListenerNotFoundException {

    }

    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {
        return new MBeanNotificationInfo[0];
    }*/
}
