package comp.prep2019;

import java.util.Arrays;

public class Prob1402 {
	public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int lineSum = 0, satCoeff = 0;
        for (int i = 0; i < satisfaction.length; i++) {
        	lineSum += satisfaction[i];
        	satCoeff += (i + 1) * satisfaction[i];
        }
        int result = satCoeff;
        for (int i = 0; i < satisfaction.length; i++) {
        	satCoeff -= lineSum;
        	lineSum -= satisfaction[i];
        	if (satCoeff < result) break;
        	result = satCoeff;
        }
        return result < 0 ? 0 : result;
    }
	
	public static void main(String[] args) {
		Prob1402 prob = new Prob1402();
		System.out.println(prob.maxSatisfaction(new int[] {-1,-8,0,5,-7}));
	}
}
