package comp.prep2019.less1000;

public class Prob557 {
	/**
	 * O(N) time and space
	 * 
	 * @param s
	 * @return
	 */
	public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
        	if (arr[i] == ' ') {
        		reverse(arr, start, i - 1);
        		start = i + 1;
        	}
        }
        reverse(arr, start, arr.length - 1);
        return new String(arr);
    }
	
	private void reverse(char[] arr, int i, int j) {
		while(i < j) {
			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}
}
