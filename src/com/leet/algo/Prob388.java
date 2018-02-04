package com.leet.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ayanc on 2/3/18.
 */
public class Prob388 {
  public int lengthLongestPath(String input) {
    if (input == null || input.length() < 1) return 0;
    String[] strs = input.split("\\n");
    int result = 0;
    Map<Integer, String> parentMap = new HashMap<>();
    parentMap.put(0, "");
    for (String str : strs) {
      int lastIndex = str.lastIndexOf("\t");
      int parentIndex = 0;
      if (lastIndex != -1) parentIndex = lastIndex + 1;
      String name = lastIndex == -1 ? str : str.substring(lastIndex + 1);
      if(name.indexOf(".") != -1) result = Math.max(result, (parentMap.get(parentIndex) + name).length());
      else parentMap.put(parentIndex + 1, parentIndex == 0 ? name + "/" : parentMap.get(parentIndex) + name + "/");
    }
    return result;
  }

  public static void main(String[] args){
//    String[] strs = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext".split("\\n");
    String str = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
    Prob388 prob388 = new Prob388();
    System.out.println(prob388.lengthLongestPath(str));
//    for (int i = 0; i < strs.length; i++) {
//      System.out.println(strs[i]);
//    }
//
//    System.out.println("abctxt.".indexOf("."));
//    System.out.println("abc\ttxt".indexOf("\t"));
  }

}
