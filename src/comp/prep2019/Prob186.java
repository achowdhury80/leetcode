package comp.prep2019;

public class Prob186 {
	public void reverseWords(char[] s) {
        int startIndex = -1;
        for (int i = 0; i < s.length; i++) {
        	if (s[i] != ' ') {
        		if (startIndex == -1) startIndex = i;
        	} else {
        		if (startIndex != -1) {
        			reverse(s, startIndex, i - 1);
        			startIndex = -1;
        		}
        	}
        }
        if (startIndex != -1) reverse(s, startIndex, s.length - 1);
        reverse(s, 0, s.length - 1);
    }
	
	private void reverse(char[] arr, int start, int end) {
		while(start < end) {
			char temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
}
