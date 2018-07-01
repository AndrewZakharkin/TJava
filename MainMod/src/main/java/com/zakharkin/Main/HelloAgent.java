package com.zakharkin.Main;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;

public class HelloAgent {
    private MBeanServer mbs = null;

    public HelloAgent()
    {
        mbs = MBeanServerFactory.createMBeanServer( "HelloAgent" );
       // com.sun.tools.attach.VirtualMachine.
        //HtmlAdaptorServer adapter = new HtmlAdaptorServer();
        HelloWorld hw = new HelloWorld();
        ObjectName adapterName = null;
        ObjectName helloWorldName = null;
        try
        {
            helloWorldName =
                    new ObjectName( "HelloAgent:name=helloWorld1" );
            mbs.registerMBean( hw, helloWorldName );
            adapterName =
                    new ObjectName( "HelloAgent:name=htmladapter,port=9092" );
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}
