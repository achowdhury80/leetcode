package comp.prep2019.less2000;

public class Prob1309 {
	/**
	 * O(N)
	 * for each step check '#' exist in next two step
	 * @param s
	 * @return
	 */
	public String freqAlphabets(String s) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
        	if (i + 2 < arr.length && arr[i + 2] == '#') {
        		int num = (arr[i] - '0') * 10 + arr[i + 1] - '0';
        		sb.append((char)(num - 10 + 'j'));
        		i += 2;
        	} else {
        		sb.append((char)(arr[i] - '0' - 1 + 'a'));
        	}
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		Prob1309 prob = new Prob1309();
		System.out.println(prob.freqAlphabets("10#11#12"));
	}
}
