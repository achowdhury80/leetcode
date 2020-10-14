package comp.prep2019.less2000;

public class Prob1189 {
	public int maxNumberOfBalloons(String text) {
        int[] arr = new int[26];
        for (char c : text.toCharArray()) {
        	arr[c - 'a']++;
        }
        int result = 0;
        while(true) {
        	boolean flag = true;
        	for (char c : "balloon".toCharArray()) {
        		if (arr[c - 'a'] > 0) {
        			arr[c - 'a']--;
        		} else {
        			flag = false;
        			break;
        		}
        	}
        	if (!flag) break;
        	result++;
        }
        return result;
    }
}
