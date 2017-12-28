package com.java8;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by ayanc on 11/28/17.
 */
public class Producer implements Runnable{
  private BlockingDeque<String>  q = new LinkedBlockingDeque<>(100);
  public void run(){
    try {
      while (true) {
        doSomethin(q.take());
      }
    }catch (InterruptedException ie){

    }
  }

  public void doSomethin(String s){

  }
}
