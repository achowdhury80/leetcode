package comp.prep2019;
import java.util.*;

public class Prob1507 {
	public String reformatDate(String date) {
        Map<String, String> map = new HashMap<>();
        map.put("Jan", "-01-");
        map.put("Feb", "-02-");
        map.put("Mar", "-03-");
        map.put("Apr", "-04-");
        map.put("May", "-05-");
        map.put("Jun", "-06-");
        map.put("Jul", "-07-");
        map.put("Aug", "-08-");
        map.put("Sep", "-09-");
        map.put("Oct", "-10-");
        map.put("Nov", "-11-");
        map.put("Dec", "-12-");
        String[] arr = date.split(" ");
        StringBuilder result = new StringBuilder();
        result.append(arr[2]).append(map.get(arr[1]));
        int d = arr[0].charAt(0) - '0';
        if (Character.isDigit(arr[0].charAt(1))) 
        	d = d * 10 + (arr[0].charAt(1) - '0');
        result.append(d < 10 ? "0" + d : "" + d);
        return result.toString();
        
    }
	
	public static void main(String[] args) {
		Prob1507 prob = new Prob1507();
		System.out.println(prob.reformatDate("20th Oct 2052"));
	}
}
