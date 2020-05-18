package comp.prep2019;

public class Prob926 {
	public int minFlipsMonoIncr(String S) {
        int flipToZero = 0, flipToOne = 0;
        char[] arr = S.toCharArray();
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] == '0') {
        		flipToOne = 1 + Math.min(flipToZero, flipToOne);
        	} else {
        		flipToOne = Math.min(flipToZero, flipToOne);
        		flipToZero = 1 + flipToZero;
        	}
        }
        
        return Math.min(flipToZero, flipToOne);
    }
}
