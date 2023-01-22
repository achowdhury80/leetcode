package com.prep2020.medium;
import java.util.*;
public class Problem2049 {
	public int countHighestScoreNodes(int[] parents) {
        int [] left = new int[parents.length];
        int [] right = new int[parents.length];
        int [] size = new int[parents.length];

       // Find children for each node
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        Arrays.fill(size, -1);

        for(int i=1;i<parents.length; i++){
            if (left[parents[i]] == -1)   {
                left[parents[i]] = i;
            } else{
                right[parents[i]] = i;
            }
        }

       // Find size of subtrees at each node
        treeSize(left, right, size, 0);
		
        int count = 0;
        long maxScore = 0;
        for(int i=0; i< parents.length; i++)
        {
            long score = findScore(left, right, size, i);
            if (score == maxScore) count ++;
            else if (score > maxScore) {
                maxScore = score;
                count = 1;
            }
        }
        return count;
    }




    public int treeSize(int[] left, int right[], int[] size, int index){
        if (index == -1) return 0;
        if (size[index] != -1) return size[index];
        size[index] = 1 + treeSize(left, right, size, left[index]) + treeSize(left, right, size, right[index]);
        return size[index];
    }


    private long findScore(int [] left, int[] right, int[] size, int index){
        int leftChildTreeSize = treeSize(left, right, size, left[index]);
        int rightChildTreeSize = treeSize(left, right, size, right[index]);
        int remaining = left.length - leftChildTreeSize - rightChildTreeSize - 1;
        return 1l * Math.max(leftChildTreeSize,1) * Math.max(rightChildTreeSize,1) * Math.max(remaining,1);
    }
	
	public static void main(String[] args) {
		Problem2049 problem = new Problem2049();
		System.out.println(problem.countHighestScoreNodes(new int[] {-1,2,0,2,0}));
	}
}
