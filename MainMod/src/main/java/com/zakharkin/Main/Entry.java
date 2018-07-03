package com.zakharkin.Main;


import com.zakharkin.Add.TestCls;
import com.zakharkin.Graph.Algo;
import com.zakharkin.Graph.Builder;
import com.zakharkin.Graph.Node;

import java.io.IOException;

public class Entry {
    static{
        //real lib name is libFirstTest.so
        //LD_LIBRARY_PATH or -Djava.library.path must be set properly
        System.loadLibrary("FirstTest");
    }
    public static void main(String[]args){
        System.out.println("Hi");
        var o = tst("Test string");
        TestCls ttt = (TestCls)o;
        System.out.println(ttt.getStat());
        System.out.println( "HelloAgent is running" );
        HelloAgent agent = new HelloAgent();

        var graph = new Builder().BuildGraph();
        new Algo(graph.left, graph.right).runAlgo(graph.left);
        for(Node node : graph.right){
            System.out.println(String.format("Node %s has weight %d", node.getName(), node.getWeight()));
        }
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static native Object tst(String tst);
}
