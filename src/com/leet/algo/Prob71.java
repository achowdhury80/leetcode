package com.leet.algo;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by ayanc on 12/29/17.
 */
public class Prob71 {
  public String simplifyPath(String path) {
    if(path == null || path.length() == 0) return "";
    String[] arr = path.split("/");
    Stack<String> stack = new Stack<>();
    int ignoreCount = 0;
    for(int i = 0; i < arr.length; i++){
      if(arr[i].trim().equals("") || arr[i].equals(".")) continue;
      if(arr[i].equals("..")) {
        ignoreCount++;
        if(ignoreCount > 0){
          if(stack.isEmpty()) ignoreCount--;
          else stack.pop();
        }
      } else stack.add(arr[i]);
    }
    String result = "";
    if(stack.isEmpty()) return "/";
    while(!stack.isEmpty()){
      String element = stack.pop();
      result = "/" + element + result;
    }
    return result;
  }

  public static void main(String[] args){
    Prob71 prob71 = new Prob71();
    System.out.println(prob71.simplifyPath("/home/"));
    System.out.println(prob71.simplifyPath("/a/./b/../../c/"));
    System.out.println(prob71.simplifyPath("/home//foo/"));
    System.out.println(prob71.simplifyPath("/../"));
  }
}
