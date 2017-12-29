package com.leet.algo;

import java.util.Arrays;

/**
 * Created by ayanc on 12/28/17.
 */
public class Prob468 {
  public String validIPAddress(String IP) {
    if(IP == null || IP.length() < 7) return "Neither";
    if(IP.indexOf(':') > -1) return isValidIPv6(IP);
    if(IP.indexOf('.') > -1) return isValidIPv4(IP);
    return "Neither";
  }

  private String isValidIPv4(String ip){
    if(ip.startsWith(".") || ip.endsWith(".")) return "Neither";
    String[] arr = ip.split("\\.");
    if(arr.length != 4) return "Neither";
    for(int i = 0; i < 4; i++){
      if(arr[i].length() > 1 && arr[i].startsWith("0") || arr[i].startsWith("-")) return "Neither";
      try{
        int block = Integer.parseInt(arr[i]);
        if(block < 0 || block > 255) return "Neither";
      }catch (Exception ex){
        return "Neither";
      }
    }
    return "IPv4";
  }

  private String isValidIPv6(String ip){
    if(ip.startsWith(":") || ip.endsWith(":")) return "Neither";
    String[] arr = ip.split(":");
    if(arr.length != 8) return "Neither";
    for(int i = 0; i < 8; i++){
      if(arr[i].trim().equals("") || arr[i].length() > 4) return "Neither";
      for(int j = 0; j < arr[i].length(); j++){
        char c = arr[i].charAt(j);
        if(!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) return "Neither";
      }
    }
    return "IPv6";
  }

  public static void main(String[] args){
    Prob468 prob468 = new Prob468();
    System.out.println(prob468.validIPAddress("1.1.1.1."));
    System.out.println(prob468.validIPAddress("1.2.3.4"));
    System.out.println(prob468.validIPAddress("172.16.254.1"));
    System.out.println(prob468.validIPAddress("256.256.256.256"));
    System.out.println(prob468.validIPAddress("2001:0db8:85a3::8A2E:0370:7334"));
    System.out.println(prob468.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
    System.out.println(prob468.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));


    //prob468.isValidIPv6("2001:0db8:85a3::8A2E:0370:7334");
  }
}
