package comp.prep2019.less1000;

public class Prob392 {
	public boolean isSubsequence(String s, String t) {
		char[] arr = t.toCharArray();
		int i = 0;
        for (char c : s.toCharArray()) {
        	while(i < t.length() && arr[i] != c) i++;
        	if (i == arr.length) return false;
        	i++;
        }
        return true;
    }
}
