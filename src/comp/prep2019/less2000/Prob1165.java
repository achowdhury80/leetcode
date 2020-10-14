package comp.prep2019.less2000;

public class Prob1165 {
	/**
	 *
	 * @param keyboard
	 * @param word
	 * @return
	 */
	public int calculateTime(String keyboard, String word) {
        int[] arr = new int[26];
        for (int i = 0; i < keyboard.length(); i++) 
        	arr[keyboard.charAt(i) - 'a'] = i;
        int last = 0;
        int result = 0;
        for (char c : word.toCharArray()) {
        	result += Math.abs(last - arr[c - 'a']);
        	last = arr[c - 'a'];
        }
        return result;
    }
}
