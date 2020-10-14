package comp.prep2019.less2000;

public class Prob1071 {
	/**
	 * O(n/m)
	 * @param str1
	 * @param str2
	 * @return
	 */
	public String gcdOfStrings(String str1, String str2) {
		if (str1.length() < str2.length()) return gcdOfStrings(str2, str1);
		if (!str1.startsWith(str2)) return "";
		if (str2.isEmpty()) return str1;
		return gcdOfStrings(str1.substring(str2.length()), str2);
    }
}
