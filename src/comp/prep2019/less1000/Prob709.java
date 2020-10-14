package comp.prep2019.less1000;

public class Prob709 {
	/**
	 * O(n) time
	 * @param str
	 * @return
	 */
	public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
        	if (Character.isLetter(c)) sb.append(Character.toLowerCase(c));
        	else sb.append(c);
        }
        return sb.toString();
    }
}
