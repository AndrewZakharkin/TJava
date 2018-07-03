package com.zakharkin.Main;

public interface HelloWorldMBean extends AdditionalMBean {
   void setGreeting(String greeting);
   String getGreeting();
   void printGreeting();
}
