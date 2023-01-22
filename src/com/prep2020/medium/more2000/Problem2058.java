package com.prep2020.medium.more2000;

import com.prep2020.ListNode;

public class Problem2058 {
	/**
	 * O(N)
	 * @param head
	 * @return
	 */
	public int[] nodesBetweenCriticalPoints(ListNode head) {
		 ListNode prev = head , curr = head.next;
		    int firstMin = -1;
		    int min = Integer.MAX_VALUE;
		    int prevMin = -1;
		    int i = 1;
		    
		    while(curr.next != null){
		        if((prev.val < curr.val && curr.next.val < curr.val) || (prev.val > curr.val && curr.next.val > curr.val)){
		            //setting first min
		            if(firstMin == -1)firstMin = i;
		            
		            if(prevMin != -1)min = Math.min(min, i-prevMin);
		            
		            prevMin = i;
		        }
		        
		        prev = curr;
		        curr = curr.next;
		        i++;
		    }
		    
		    if(firstMin==-1 || prevMin==firstMin) return new int[]{-1,-1};
		    else return new int[]{min,prevMin-firstMin};
    }
}
