package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2300 {
	public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ret = new int[spells.length];
        int k = 0;
        Arrays.sort(potions);
        for(int i = 0 ; i< spells.length ;i++){
            int ans = -1;
             int start= 0 , end = potions.length -1;
            while(start <= end){
                int mid = start + (end - start )/2;
                long temp = 1;
                temp = temp * spells[i] * potions[mid];
                if(temp >=success  ){
                    ans = mid;
                    end = mid -1;
                }else{
                    start = mid+1;
                }
            }
            if(ans == -1)ret[k++] = 0;
            else
            ret[k++] = potions.length -ans;
           
        }
        return ret;
    }
}
