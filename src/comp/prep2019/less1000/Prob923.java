package comp.prep2019.less1000;

public class Prob923 {
	public int threeSumMulti(int[] A, int target) {
        int[] arr = new int[101];
        for (int a : A) arr[a]++;
        long result = 0;
        int mod = (int)(1e9 +7);
        for (int i = 0; i < 101; i++) {
        	if (3 * i > target) break;
        	if (arr[i] > 0) {
                int r = findTwoSum(arr, i + 1, target - i);
        		result = (result + (r * arr[i]) % mod) % mod;
        		if (arr[i] >= 3 && 3 * i == target) {
                    result = (result + (arr[i] * 1l * (arr[i] - 1)) * (arr[i] - 2) / 6) % mod;
                } else if (target > 3 * i && arr[i] > 1) {
                	int idx = target - 2 * i;
                	if (idx <= 100 && arr[idx] > 0) {
                		result = (result + (arr[idx] * (arr[i] * 1l * (arr[i] - 1)) / 2) % mod) % mod;
                	}
                }
        	}
        }
        return (int)result;
    }
	private int findTwoSum(int[] arr, int start, int target) {
		int mod = (int)(1e9 +7);
		long result = 0;
		for (int i = start; i < arr.length; i++) {
			if (i > target - i || target - i > 100) continue;
			int c1 = arr[i];
			int c2 = arr[target - i];
			if (i == target - i) {
				result = (result + c1 * 1l * (c1 - 1) / 2) % mod;
			} else result = (result + c1 * c2) % mod;
		}
		return (int)result;
	}
	
	public static void main(String[] args) {
		Prob923 prob = new Prob923();
		System.out.println(prob.threeSumMulti(new int[] {1,1,2,2,3,3,4,4,5,5},8));
		System.out.println(prob.threeSumMulti(new int[] {0, 0, 0},0));
	}
}
