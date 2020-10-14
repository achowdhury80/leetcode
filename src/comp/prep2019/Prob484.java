package comp.prep2019;

public class Prob484 {
	/**
	 * O(N) time
	 * D is responsible for its last number includng the number int it's position
	 * so if input string ends with D, we don't need special case
	 * if it ends with I, we have to take care of last number
	 * whenever D is encountered, try to find number of consecutive Ds.
	 * 
	 * @param s
	 * @return
	 */
	public int[] findPermutation(String s) {
        char[] arr = s.toCharArray();
        int start = 1;
        int[] result = new int[arr.length + 1];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'D') {
                int count = 0;
                while(i < arr.length && arr[i] == 'D') {
                    count++;
                    i++;
                }
                start = start + count;
                for (int j = 0; j <= count; j++) {
                    result[idx++] = start - j;
                }
                start++;
                
            } else {
                result[idx++] = start++;
            }
        }
        if (arr[arr.length - 1] == 'I') result[idx] = start;
        return result;
    }
	
	public static void main(String[] args) {
		Prob484 prob = new Prob484();
		int[] result = prob.findPermutation("DDIIDI");
		//int[] result = prob.findPermutation("D");
		for (int num : result) {
			System.out.print(num + ", ");
		}
	}
}
