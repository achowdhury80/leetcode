package comp.prep2019;

public class Prob1185 {
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
	
	public static void main(String[] args) {
		Prob1185 prob = new Prob1185();
		System.out.println(prob.dayOfTheWeek(21, 12, 1980));
		System.out.println(prob.dayOfTheWeek(27, 4, 1980));
		System.out.println(prob.dayOfTheWeek(6, 4, 1982));
		System.out.println(prob.dayOfTheWeek(22, 10, 2018));
	}
}
