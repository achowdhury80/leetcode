package comp.prep2019;

public class Prob1180 {
	public int countLetters(String S) {
        int i = 1, j = 0;
        char[] arr = S.toCharArray();
        int result = 1;
        while(i < arr.length) {
        	if (arr[i] == arr[j]) {
        		result += i - j + 1;
        	} else {
        		result++;
        		j = i;
        	}
        	i++;
        }
        return result;
    }
}
