package comp.prep2019.less2000;

public class Prob1147 {
	public int longestDecomposition(String text) {
        char[] arr = text.toCharArray();
        int result = 0, i = 0, j = arr.length - 1;
        String fwd = "", rev = "";
        while(i < j) {
        	fwd += arr[i];
        	rev = arr[j] + rev;
        	if (fwd.equals(rev)) {
        		result += 2;
        		fwd = "";
        		rev = "";
        	}
        	i++;
        	j--;
        }
        if (!"".equals(fwd) || i == j) result++;
        return result;
    }
}
