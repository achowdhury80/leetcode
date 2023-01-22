package com.prep2020.easy;

public class Problem1933 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public boolean isDecomposable(String s) {
		boolean twoFound = false;
		int count = 0;
		Character last = null;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (last == null) {
				last = c;
				count = 1;
			}else if (c == last) {
				count++;
				if (count == 3) {
					count = 0;
					last = null;
				}
			} else {
				if (count == 2) {
					if (twoFound) return false;
					twoFound = true;
					count = 1;
					last = c;
				}
				else return false;
			}
		}
		if (count == 2) {
			if (twoFound) return false;
			return true;
		}
		return count == 0 && twoFound;
    }
	
	public static void main(String[] args) {
		Problem1933 problem = new Problem1933();
		System.out.println(problem.isDecomposable("00011111222"));
	}
}
