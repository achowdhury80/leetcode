package com.prep2020.medium;
import java.util.*;
public class Problem1717 {
	public int maximumGain(String s, int x, int y) {
        StringBuilder sb = new StringBuilder();
        char fc = 'a';
        char sc = 'b';

        if (x < y) {
            fc = 'b';
            sc = 'a';
        }

        int gain1 = calcGain(s.toCharArray(), Math.max(x, y), sb, fc, sc);
        int gain2 = calcGain(sb.toString().toCharArray(), Math.min(x, y), sb, sc, fc);

        return gain1 + gain2;
    }

    public static int calcGain(char[] arr, int gain, StringBuilder sb, char fc, char sc) {
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        for (char c : arr) {
            if (!stack.isEmpty() && stack.peek() == fc && c == sc) {
                stack.pop();
                sb.deleteCharAt(sb.length() - 1);
                ans += gain;
            } else {
                stack.push(c);
                sb.append(c);
            }
        }
        return ans;
    }
}
