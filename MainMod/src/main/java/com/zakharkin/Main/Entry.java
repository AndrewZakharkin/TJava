package com.zakharkin.Main;


import com.zakharkin.Add.TestCls;

import java.io.IOException;

public class Entry {
    static{
        //real lib name is libFirstTest.so
        //LD_LIBRARY_PATH or -Djava.library.path must be set properly
        //System.loadLibrary("FirstTest");
    }
    public static void main(String[]args){
        System.out.println("Hi");
       // var o = tst("Test string");
        //estCls ttt = (TestCls)o;
        //System.out.println(ttt.getStat());
        System.out.println( "HelloAgent is running" );
        HelloAgent agent = new HelloAgent();

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static native Object tst(String tst);
}
