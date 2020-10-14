package comp.prep2019.less1000;

public class Prob926 {
	/**
	 * at ith position, find out min of (making zeros till ith position and rest ones)
	 * and (making zeros till (i-1)th position and rest 1's)
	 * 
	 * do it strating from zero
	 * @param S
	 * @return
	 */
	public int minFlipsMonoIncr(String S) {
        int allOne = 0;
        for (char c : S.toCharArray()) if (c == '0') allOne++;
        int result = allOne;
        int flipsToMakeZero = 0;
        for (int i = 0; i < S.length(); i++) {
        	if (S.charAt(i) == '0') {
        		result = Math.min(result, flipsToMakeZero + allOne - 1);
        		result = Math.min(result, flipsToMakeZero + allOne);
        		allOne--;
        	} else {
        		result = Math.min(result, flipsToMakeZero + 1 + allOne);
        		result = Math.min(result, flipsToMakeZero + allOne);
        		flipsToMakeZero++;
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob926 prob = new Prob926();
		System.out.println(prob.minFlipsMonoIncr("00110"));
	}
}
