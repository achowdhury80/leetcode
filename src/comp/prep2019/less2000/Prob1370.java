package comp.prep2019.less2000;

public class Prob1370 {
	/**
	 * o(N) time and o(1) space
	 * @param s
	 * @return
	 */
	public String sortString(String s) {
        int[] arr = new int[26];
        int min = 27, max = -1;
        for (char c : s.toCharArray()) {
        	int idx = c - 'a';
        	arr[idx]++;
        	min = Math.min(min, idx);
        	max = Math.max(max, idx);
        }
        StringBuilder sb = new StringBuilder("");
        int count = s.length();
        while(count > 0) {
        	for (int i = 0; i < 26; i++) {
        		if (arr[i] > 0) {
        			sb.append((char)(i + 'a'));
        			count--;
        			arr[i]--;
        		}
        	}
        	if (count > 0) {
	        	for (int i = 25; i > -1; i--) {
	        		if (arr[i] > 0) {
	        			sb.append((char)(i + 'a'));
	        			count--;
	        			arr[i]--;
	        		}
	        	}
        	}
        }
        return sb.toString();
    }
}
