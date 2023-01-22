package com.prep2020.medium;
public class Problem1953 {
	public long numberOfWeeks(int[] milestones) {
        if(milestones == null || milestones.length == 0) return 0;
        return maxNumberOfWeeks(milestones);
    }
    
    private long maxNumberOfWeeks(int[] milestones) {
        long sum = 0;
        long maxMilestone = 0;
        int n = milestones.length;
        for(int i=0;i<n;i++) {
            sum += milestones[i];
            maxMilestone = Math.max(maxMilestone, milestones[i]);
        }
        long maxPossibleMilestoneInProject = (long) Math.floor(sum / 2);
        if(maxPossibleMilestoneInProject < maxMilestone) {
            return (sum - maxMilestone) * 2 + 1;
        }
        return sum;
    }
}
