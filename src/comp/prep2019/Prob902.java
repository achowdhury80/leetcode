package comp.prep2019;
public class Prob902 {
	/**
	 * O(logN) time and space
	 * @param D
	 * @param N
	 * @return
	 */
	public int atMostNGivenDigitSet(String[] D, int N) {
        int size = D.length;
        // find the length of the number
        int len = (int)Math.floor(Math.log10(N)) + 1;
        int result = 0;
        if (len > 1) {
        	// if size is 4 and len is 3, then two digit and one digit combination
        	// sum . size^1 + size^2 .. which is a gp series
        	result += gpSum(size, len - 1, size);
        }
        // case for numbers with same length
        result += findNumberCount(D, "" + N);
        return result;
    }
	
	private int findNumberCount(String[] d, String num) {
		int result = 0;
		for (int i = 0; i < d.length; i++) {
			// if fist num greater, then remaining positions can be filled by any 
			// combination
			if (num.charAt(0) > d[i].charAt(0)) 
				result += num.length() == 1 ? 1 
						: Math.pow(d.length, num.length() - 1);
			// if lesse, no num
			else if (num.charAt(0) < d[i].charAt(0)) continue;
			// if equal, check for the substring combinations
			else result += num.length() == 1 ? 1 
					: findNumberCount(d, num.substring(1));
		}
		return result;
	}

	private int gpSum(int firstTerm, int count, int ratio) {
		if (ratio == 1) return firstTerm * count;
		return Double.valueOf(firstTerm 
				* ((Math.pow(ratio, count) - 1) / (ratio - 1))).intValue();
	}
	
	public static void main(String[] args) {
		Prob902 prob = new Prob902();
		/*System.out.println(prob.atMostNGivenDigitSet(
		 * 		new String[] {"1","3","5","7"}, 100));*/
		/*System.out.println(prob.atMostNGivenDigitSet(new String[] {"7"}, 
				8)); */
		/*System.out.println(prob.atMostNGivenDigitSet(new String[] {"3", "4", "8"}, 
				4));*/
//		System.out.println(prob.atMostNGivenDigitSet(new String[] {"9"}, 
//			55));
		System.out.println(prob.atMostNGivenDigitSet(new String[] {"1"}, 
				834));
	}
}
