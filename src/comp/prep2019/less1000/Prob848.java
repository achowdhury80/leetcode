package comp.prep2019.less1000;

public class Prob848 {
	public String shiftingLetters(String S, int[] shifts) {
        for (int i = shifts.length - 2; i > -1; i--) {
        	shifts[i] += shifts[i + 1] % 26;
        }
        StringBuilder result = new StringBuilder();
        char[] arr = S.toCharArray();
        for (int i = 0; i < shifts.length; i++) {
        	result.append((char)((arr[i] - 'a' + shifts[i]) % 26 + 'a'));
        }
        return result.toString();
    }
}
