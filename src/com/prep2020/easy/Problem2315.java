package com.prep2020.easy;

public class Problem2315 {
	public int countAsterisks(String s) {
        int bar = 0;
        int astrick_count = 0;
        
        char[] char_arr = s.toCharArray();
        
        for(char c:char_arr){
            if(c=='|'){
                bar++;
            }
            if(bar==2){
                bar = 0;
            }
            
            if(bar == 0 && c=='*'){
                astrick_count++;
            }
            
        }
            
        return astrick_count;
    }
}
