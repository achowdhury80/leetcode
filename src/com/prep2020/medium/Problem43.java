package com.prep2020.medium;

public class Problem43 {
	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0"))
			return "0";
		int n = Math.max(num1.length(), num2.length());
		while (num1.length() < n)
			num1 = "0" + num1;
		while (num2.length() < n)
			num2 = "0" + num2;
		int[] pos = new int[num1.length() + num2.length()];
		for (int i = num1.length() - 1; i > -1; i--) {
			for (int j = num2.length() - 1; j > -1; j--) {
				pos[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				pos[i + j] += pos[i + j + 1] / 10;
				pos[i + j + 1] %= 10;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < pos.length; i++) {
			if (!(pos[i] == 0 && sb.length() == 0))
				sb.append(pos[i]);
		}
		return sb.toString();
	}
}
