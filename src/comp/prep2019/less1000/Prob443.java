package comp.prep2019.less1000;

public class Prob443 {
	/**
	 * O(N)
	 * @param chars
	 * @return
	 */
	public int compress(char[] chars) {
        int idx = 1;
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
        	if (chars[i] == chars[i - 1]) {
        		count++;
        	} else {
        		if (count > 1) {
        			String s = "" + count;
        			count = 1;
        			for (char c : s.toCharArray()) {
        				chars[idx++] = c;
        			}
        		} 
        		chars[idx++] = chars[i];
        	}
        }
        if (count > 1) {
			String s = "" + count;
			for (char c : s.toCharArray()) {
				chars[idx++] = c;
			}
		} 
        return idx;
    }
}
