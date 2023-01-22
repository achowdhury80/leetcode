package com.prep2020.medium;
import java.util.*;
public class Problem1654 {
	public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> set =new HashSet<>();
        for (int f : forbidden) set.add(f);
        Queue<int []> q=new ArrayDeque<>();
        q.add(new int[]{0,0,0});
        while(!q.isEmpty()){
            int[] cur=q.poll();
            if(cur[0] == x) return cur[1];
            if(!set.contains(cur[0] + a) && cur[0] + a<=6000){
                q.offer(new int[]{cur[0] + a, cur[1] + 1, 0});
                set.add(cur[0] + a);
            }
            if(!set.contains(cur[0] - b) && cur[2] == 0 && cur[0] - b >= 0) {
                q.offer(new int[]{cur[0] - b, cur[1] + 1, 1}); 
                //can't do it
            	//set.add(cur[0] - b);
            }
        }
        return -1;
    }
}
