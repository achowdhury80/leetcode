package comp.prep2019.less1000;

public class Prob791 {
	/**
	 * O(m + n) time and space
	 * @param S
	 * @param T
	 * @return
	 */
	public String customSortString(String S, String T) {
        char[] arr = T.toCharArray();
        String[] map = new String[26];
        for (char c : arr) map[c - 'a'] = map[c - 'a'] == null ? ("" + c) : map[c - 'a'] + c;
        String result = "";
        for (char c : S.toCharArray()) {
        	if (map[c - 'a'] != null) {
        		result += map[c - 'a'];
        		map[c - 'a'] = null;
        	}
        }
        for (int i = 0; i < 26; i++) {
        	if (map[i] != null) result += map[i];
        }
        return result;
    }
}
