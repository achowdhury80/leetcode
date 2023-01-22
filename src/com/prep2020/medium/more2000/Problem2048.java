package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2048 {
	public int nextBeautifulNumber(int n) {
        int ans=0;
        for(int i=n+1;i<=1224444;i++){
            if(isGood(i)){
                return i;
            }
        }
        return 0;
    }
    public static boolean isGood(int n){
        String s=Integer.toString(n);
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(char a:map.keySet()){
            int b=map.get(a);
            int c=Character.getNumericValue(a);
            if(b!=c){
                return false;
            }
        }
        return true;
    }
}
