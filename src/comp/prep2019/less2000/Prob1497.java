package comp.prep2019.less2000;
public class Prob1497 {
	public boolean canArrange(int[] arr, int k) {
        int[] rem = new int[k];
        for (int num : arr) {
        	int r = ((num % k) + k) % k;
        	rem[r]++;
        }
        if (rem[0] % 2 != 0) return false;
        for (int i = 1; i < (k + 1) / 2; i++) {
        	if (rem[i] != rem[k - i]) return false;
        }
        if (k % 2 == 0 && rem[k / 2] % 2 != 0) return false; 
        return true;
    }
	
	public static void main(String[] args) {
		Prob1497 prob = new Prob1497();
		System.out.println(prob.canArrange(new int[] {-1,1,-2,2,-3,3,-4,4}, 3));
		System.out.println(prob.canArrange(new int[] {-1,-1,-1,-1,2,2,-2,-2}, 3));
	}
}
