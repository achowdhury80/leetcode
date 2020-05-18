package comp.prep2019;

public class Prob1013 {
	public boolean canThreePartsEqualSum(int[] A) {
        int[] sum = new int[A.length];
        sum[0] = A[0];
        for (int i = 1; i < A.length; i++) sum[i] = sum[i - 1] + A[i];
        if (sum[A.length - 1] % 3 != 0) return false;
        int part = sum[A.length - 1] / 3;
        int i;
        for (i = 0; i < A.length - 2; i++) {
        	if (sum[i] == part) break;
        	else if (sum[i] > part) return false;
        }
        while(i < A.length - 1) {
        	if (sum[i] == 2 * part) return true;
        	else if (sum[i] > 2 * part) return false;
        	i++;
        }
        return false;
    }
	
	public static void main(String[] args) {
		Prob1013 prob = new Prob1013();
		System.out.println(prob.canThreePartsEqualSum(new int[] {0,2,1,-6,6,7,9,-1,
				2,0,1}));
	}
}
