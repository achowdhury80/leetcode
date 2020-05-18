package comp.prep2019;

public class Prob1228 {
	public int missingNumber(int[] arr) {
        int cd = (arr[arr.length - 1] - arr[0]) / arr.length;
        for (int i = 1; i < arr.length; i++) {
        	int next = arr[i - 1] + cd;
        	if (next != arr[i]) return next;
        }
        return 0;
    }
	
	public static void main(String[] args) {
		Prob1228 prob = new Prob1228();
		System.out.println(prob.missingNumber(new int[] {1, 2, 3,5}));
	}
}
