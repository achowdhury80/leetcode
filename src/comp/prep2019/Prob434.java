package comp.prep2019;

public class Prob434 {
	public int countSegments(String s) {
        char[] arr = s.toCharArray();
        int result = 0;
        boolean started = false;
        for (int i = 0; i < s.length(); i++) {
        	if (arr[i] == ' ' && started) {
        		result++;
        		started = false;
        	} 
        	if (arr[i] != ' ' && !started) {
        		started = true;
        	}
        }
        if (started) result++;
        return result;
    }
}
