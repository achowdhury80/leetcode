package comp.prep2019;

public class Prob1119 {
	/**
	 * O(N) time
	 * @param S
	 * @return
	 */
	public String removeVowels(String S) {
        char[] arr = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
        	if ("aeiou".indexOf(c) < 0) sb.append(c);
        }
        return sb.toString();
    }
}
