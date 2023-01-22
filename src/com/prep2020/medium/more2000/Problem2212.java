package com.prep2020.medium.more2000;

public class Problem2212 {
	public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
	       // System.out.println((1<<aliceArrows.length-1)-1);
	        int max = 0 ;
	        int [] maxState = null;
	        for(int state = 1;state<=2047 ;state++){
	            int arrows = 0,score = 0 ;
	            int [] currMaxState = new int[aliceArrows.length];
	            for(int i = 0;i<aliceArrows.length;i++){
	                int aScore = aliceArrows[aliceArrows.length-i-1];
	                if((state & (1<<i))>0){
	                    arrows+=(aScore>0?(aScore+1):1);
	                    score+=aliceArrows.length-i-1;
	                    currMaxState[aliceArrows.length-i-1] = (aScore>0?(aScore+1):1);
	                }
	            }
	            if(arrows<=numArrows && score>max){
	                //System.out.println("Here");
	                max = score;
	                for(int i = 0;i<currMaxState.length;i++){
	                    if(currMaxState[i]>0 && arrows<numArrows){
	                        currMaxState[i]+=(numArrows-arrows);
	                        break;
	                    }
	                }
	                maxState = currMaxState;
	            }
	        }
	        //System.out.println(max);
	        return maxState;
	        
	    }
}
