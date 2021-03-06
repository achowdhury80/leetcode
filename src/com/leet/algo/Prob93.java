package com.leet.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ayanc on 12/28/17.
 */
public class Prob93 {
  public List<String> restoreIpAddresses(String s) {
    List<String> result = new ArrayList<>();
    if(s == null || s.length() < 4 || s.length() > 12) return result;
//    List<String> result = restoreIpAddresses(s, 4);
//    if(result == null) return new ArrayList<>();
    restoreIpAddresses2(result, s, 4, "");
    return result;
  }
  private void restoreIpAddresses2(List<String> result, String s, int blockCount, String str){
    if (s.equals("") && blockCount == 0) {
      result.add(str.substring(0, str.length() - 1));
    }
    if (blockCount == 0 || s.equals("") || blockCount > s.length() || s.length() > blockCount * 3) return;

    for (int i = 1; i <= s.length() && i < 4; i++) {
      String sub = s.substring(0, i);
      if ((sub.length() < 2  || !sub.startsWith("0")) && !sub.equals("") && Integer.parseInt(sub) < 256)
        restoreIpAddresses2(result, s.substring(i), blockCount - 1, str + sub + ".");
    }

  }

  private List<String> restoreIpAddresses(String s, int blockCount){
    int length = s.length();
    if(length < blockCount || length > blockCount * 3 || blockCount == 0 || length == 0) return null;
    if(blockCount == 1){
      if(Integer.valueOf(s) > 255 || (s.length() > 1 && s.startsWith("0"))) return null;
      List<String> list = new ArrayList<>();
      list.add(s);
      return list;
    }
    List<String> result = new ArrayList<>();
    List<String> temp = new ArrayList<>();
    if((temp = restoreIpAddresses(s.substring(0, length - 1), blockCount - 1)) != null){
      String st = s.substring(length - 1);
      result.addAll(temp.stream().map(x -> x + "." + st).collect(Collectors.toList()));
    }
    if(length > 2 && !s.substring(length - 2).startsWith("0") && (temp = restoreIpAddresses(s.substring(0, length - 2), blockCount - 1)) != null){
      String st = s.substring(length - 2);
      result.addAll(temp.stream().map(x -> x + "." + st).collect(Collectors.toList()));
    }
    if(length > 3 && !s.substring(length - 3).startsWith("0") && Integer.valueOf(s.substring(length - 3)) < 256
        && (temp = restoreIpAddresses(s.substring(0, length - 3), blockCount - 1)) != null){
      String st = s.substring(length - 3);
      result.addAll(temp.stream().map(x -> x + "." + st).collect(Collectors.toList()));
    }
    if(result.size() < 1) return null;
    return result;

  }



  public static void main(String[] args){
    Prob93 prob93 = new Prob93();
    System.out.println(prob93.restoreIpAddresses("25525511135"));
    System.out.println(prob93.restoreIpAddresses("0000"));
    System.out.println(prob93.restoreIpAddresses("010010"));
  }
}
