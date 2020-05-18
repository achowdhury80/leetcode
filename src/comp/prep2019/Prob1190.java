package comp.prep2019;
import java.util.*;
public class Prob1190 {
	public String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] == '(') stack.push(i + 1);
        	else if (arr[i] == ')') {
        		reverse(arr, stack.pop(), i - 1);
        	}
        }
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
        	if (c != '(' && c != ')') sb.append(c);
        }
        return sb.toString();
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
