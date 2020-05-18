package comp.prep2019;

public class Prob921 {
	public int minAddToMakeValid(String S) {
        if (S.length() < 1) return 0;
        char[] arr = S.toCharArray();
        int cur = 0;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] == '(') cur++;
        	else if (arr[i] == ')') cur--;
        	if (cur < 0) {
        		result++;
        		cur++;
        	}
        }
        result += cur;
        return result;
    }
}
