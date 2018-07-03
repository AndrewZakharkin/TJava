package com.zakharkin.Main;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class HelloAgent {
    private MBeanServer mbs = null;

    public HelloAgent()
    {
        mbs = ManagementFactory.getPlatformMBeanServer();
       // com.sun.tools.attach.VirtualMachine.
        //HtmlAdaptorServer adapter = new HtmlAdaptorServer();
        HelloWorld hw = new HelloWorld();
        ObjectName additionalName = null;
        ObjectName helloWorldName = null;
        try
        {
            helloWorldName =
                    new ObjectName("HelloAgent:name=helloWorld");
            mbs.registerMBean( hw, helloWorldName );
            additionalName =
                    new ObjectName("HelloAgent:name=additional");
            mbs.registerMBean(hw, additionalName);
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}
