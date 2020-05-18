package com.leet.algo;

/**
 * Created by ayanc on 3/17/18.
 */
public class Prob660 {
	public int newInteger(int n) {
        return Integer.parseInt(Integer.toString(n, 9));
    }

  public static void main(String[] args) {
    Prob660 prob660 = new Prob660();
    System.out.println(prob660.newInteger(100));
    /*System.out.println(prob660.newInteger(9));
    System.out.println(prob660.newInteger(10));
    System.out.println(prob660.newInteger(11));*/
    //System.out.println(prob660.newInteger(800000000));

  }
}
