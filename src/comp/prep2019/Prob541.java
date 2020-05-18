package comp.prep2019;

public class Prob541 {
	public String reverseStr(String s, int k) {
		if (k == 1) return s;
		char[] arr = s.toCharArray();
		int cur = 0;
		while(cur + 2 * k < arr.length) {
			reverse(arr, cur, cur + k - 1);
			cur += 2 * k;
		}
		reverse(arr, cur, Math.min(s.length() - 1, cur + k - 1));
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
