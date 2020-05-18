package comp.prep2019;

public class Prob1154 {
	public int dayOfYear(String date) {
        String[] arr = date.split("-");
        int[] days = new int[] {31, 28, 31, 30, 31, 30, 31,31, 30, 31, 30, 31};
        int result = Integer.valueOf(arr[2]);
        int cur = 1;
        int month = Integer.valueOf(arr[1]);
        while(cur < month) {
        	if (cur != 2) result += days[cur - 1];
        	else {
        		int year = Integer.valueOf(arr[0]);
        		if (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0)) result += 28;
        		else result += 29;
        	}
        	cur++;
        }
        return result;
        
    }
}
