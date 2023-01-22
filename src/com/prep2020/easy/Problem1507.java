package com.prep2020.easy;

public class Problem1507 {
	/**
	 * O(1)
	 * @param date
	 * @return
	 */
	public String reformatDate(String date) {
        String[] arr = date.split(" ");
        String[] months = new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", 
        		"Aug", "Sep", "Oct", "Nov", "Dec"};
        char c = arr[0].charAt(1);
        String day = "0";
        if (Character.isDigit(c)) day = arr[0].substring(0, 2);
        else day += arr[0].charAt(0);
        String month = "0";
        for (int i = 0; i < months.length; i++) {
        	if (months[i].equals(arr[1])) {
        		i++;
        		if (i < 10) month += i;
        		else month = "" + i;
        		break;
        	}
        }
        return arr[2] + "-" + month + "-" + day;
    }
	
	public static void main(String[] args) {
		Problem1507 problem = new Problem1507();
		System.out.println(problem.reformatDate("20th Oct 2052"));
	}
}
