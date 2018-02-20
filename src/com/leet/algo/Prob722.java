package com.leet.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ayanc on 12/29/17.
 */
public class Prob722 {
  public List<String> removeComments(String[] source) {
    List<String> result = new ArrayList<>();
    if(source == null || source.length == 0) return result;
    StringBuilder sb = new StringBuilder();
    boolean open = false;
    for (String s : source) {
      for (int i = 0; i < s.length(); i++) {
        if (open) {
          if (s.charAt(i) == '*' && i < s.length() - 1 && s.charAt(i + 1) == '/') {
            open = false;
            i++;
          }
        } else {
          if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '/') break;
          else if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '*') {
            open = true;
            i++;
          } else sb.append(s.charAt(i));
        }
      }
      if (!open && sb.length() > 0) {
        result.add(sb.toString());
        sb = new StringBuilder();
      }
    }
    return result;
  }


  public static void main(String[] args){
    Prob722 prob722 = new Prob722();
    System.out.println(prob722.removeComments(new String[]{"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"}));
  }
}
