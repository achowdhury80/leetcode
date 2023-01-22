package com.prep2020.medium;

public class Problem12 {
	public String intToRoman(int num) {
        String[][] arr = new String[][] {
        	{"M", "MM", "MMM"},
        	{"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
        	{"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
        	{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}
        };
        String result = "";
        int i = 1000;
        int j = 0;
        do {
        	int val = num / i;
        	num = num % i;
        	i /= 10;
        	if (val > 0) {
        		result = result + arr[j][val - 1];
        	}
        	j++;
        } while(i > 0);
        return result;
    }
	
	public static void main(String[] args) {
		System.out.println(new Problem12().intToRoman(3));
	}
}
