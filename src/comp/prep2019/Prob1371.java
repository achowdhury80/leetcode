package comp.prep2019;

public class Prob1371 {
	public int findTheLongestSubstring(String s) {
        int mask = 0, result = 0;
        int[] pos = new int[32];
        for (int i = 0; i < 32; i++) pos[i] = -1;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
        	int a = -1;
        	if (arr[i] == 'a') a = 0;
        	else if (arr[i] == 'e') a = 1;
        	else if (arr[i] == 'i') a = 2;
        	else if (arr[i] == 'o') a = 3;
        	else if (arr[i] == 'u') a = 4;
        	if (a > -1) mask ^= (1 << a);
        	if (mask > 0 && pos[mask] == -1) {
        		pos[mask] = i;
        	} else {
        		result = Math.max(result, i - pos[mask]);
        	}
        }
        return result;
    }
}
