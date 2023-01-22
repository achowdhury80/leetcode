package com.prep2020.medium;

public class Problem1256 {
	/**
	 * nlogn
	 * @param num
	 * @return
	 */
	public String encode(int num) {
        if (num == 0) return "";
        int lastSize = 1, lastVal = 0;
        while(lastVal + 2 * lastSize < num) {
        	lastSize = lastSize * 2;
        	lastVal += lastSize;
        }
        int pos = num - lastVal;
        if (pos > lastSize) pos -= lastSize;
        String s = encode(lastVal - (lastSize - pos));
        if (lastVal + lastSize >= num) return "0" + s;
        else return "1" + s;
    }
	
	public static void main(String[] args) {
		Problem1256 problem = new Problem1256();
		System.out.println(problem.encode(23));
	}
}
