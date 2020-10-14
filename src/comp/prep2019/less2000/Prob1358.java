package comp.prep2019.less2000;

public class Prob1358 {
	public int numberOfSubstrings(String s) {
        char[] arr = s.toCharArray();
        int count = 0;
        int[] freq = new int[3];
        int start = 0, result = 0;
        for (int i = 0; i < arr.length; i++) {
        	int idx = arr[i] - 'a';
        	if (freq[idx] == 0) count++;
        	freq[idx]++;
        	while(count == 3) {
        		result += arr.length - i;
        		idx = arr[start] - 'a';
        		start++;
        		if (freq[idx] == 1) count--;
        		freq[idx]--;
        	}
        }
        return result;
    }
	
}
