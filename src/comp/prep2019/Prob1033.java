package comp.prep2019;

import java.util.Arrays;

public class Prob1033 {
	public int[] numMovesStones(int a, int b, int c) {
        int[] arr = new int[] {a, b, c};
        Arrays.sort(arr);
        int[] result = new int[2];
        if (arr[1] - arr[0] == 2 || arr[2] - arr[1] == 2) result[0] = 1;
        else {
        	result[0] = (arr[1] - arr[0] > 1 ? 1 : 0) 
        			+ (arr[2] - arr[1] > 1 ? 1 : 0);
        }
        result[1] = arr[2] - arr[0] - 2;
        return result;
    }
	
	public static void main(String[] arsg) {
		Prob1033 prob = new Prob1033();
		System.out.println(prob.numMovesStones(1, 4, 5));
	}
}
