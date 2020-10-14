package comp.prep2019.less2000;

public class Prob1287 {
	/**
	 * O(N)
	 * find the min count
	 * if a[i] == a[i + min count - 1} return a[i]
	 * @param arr
	 * @return
	 */
	public int findSpecialInteger(int[] arr) {
        int count = (arr.length + 4) % 4;
        for (int i = 0; i + count <= arr.length; i++) {
            if (arr[i] == arr[i + count - 1]) return arr[i];
        }
        return -1;
    }
	
	public static void main(String[] args) {
		Prob1287 prob = new Prob1287();
		System.out.println(prob.findSpecialInteger(new int[] {1,2,2,6,6,6,6,7,10}));
	}
}
