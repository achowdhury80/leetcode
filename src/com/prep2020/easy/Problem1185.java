package com.prep2020.easy;

public class Problem1185 {
	/**
	 * 1st jan 1971 friday
	 * @param day
	 * @param month
	 * @param year
	 * @return
	 */
	public String dayOfTheWeek(int day, int month, int year) {
        String[] days = new String[] {"Thursday", "Friday", "Saturday", "Sunday", 
        		"Monday", "Tuesday", "Wednesday"};
        int sum = 0;
        int cur = 1971;
        while(cur < year) {
        	if (cur % 4 == 0) sum += 366;
        	else sum += 365;
        	cur++;
        }
        cur = 1;
        int[] monthDays = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        while (cur < month) {
        	if (cur != 2) sum += monthDays[cur - 1];
        	else {
        		if (year == 2100 || year % 4 != 0) sum += 28;
        		else sum += 29; 
        	}
        	cur++;
        }
        sum += day;
        return days[sum % 7];
    }
	
}
