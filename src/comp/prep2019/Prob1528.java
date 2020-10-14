package comp.prep2019;

public class Prob1528 {
	/**
	 * O(N) time and space
	 * @param s
	 * @param indices
	 * @return
	 */
	public String restoreString(String s, int[] indices) {
       char[] arr = new char[s.length()];
       for (int i = 0; i < s.length(); i++) {
    	   arr[indices[i]] = s.charAt(i);
       }
       return new String(arr);
    }
}
