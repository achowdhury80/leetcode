package comp.prep2019.less2000;

public class Prob151 {
	public String reverseWords(String s) {
		char[] arr = s.trim().toCharArray();
		int startIndex = -1;
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] != ' ') {
        		if (startIndex == -1) startIndex = i;
        	} else {
        		if (startIndex != -1) {
        			reverse(arr, startIndex, i - 1);
        			startIndex = -1;
        		}
        	}
        }
        if (startIndex != -1) reverse(arr, startIndex, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] == ' ' && arr[i - 1] == ' ') continue;
        	result.append(arr[i]);
        }
        return result.toString();
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
