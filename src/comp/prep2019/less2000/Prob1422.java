package comp.prep2019.less2000;

public class Prob1422 {
	public int maxScore(String s) {
        char[] arr = s.toCharArray();
        int total1s = 0;
        for (char c : arr) {
        	if (c == '1') total1s++;
        }
        int result = 0, numZeros = 0;
        for (int i = 0; i < arr.length - 1; i++) {
        	if (arr[i] == '0') numZeros++;
        	else total1s--;
        	result = Math.max(result, numZeros + total1s);
        }
        return result;
    }
}
