package comp.prep2019.less1000;

public class Prob383 {
	/**
	 * trick is to find charMap for ransom note, not for magazine
	 * @param ransomNote
	 * @param magazine
	 * @return
	 */
	public boolean canConstruct(String ransomNote, String magazine) {
		if("".equals(ransomNote)) return true;
        int[] arr = new int[26];
        int count = 0;
        for (char c : ransomNote.toCharArray()) {
        	arr[c - 'a']++;
        	count++;
        }
        for (char c : magazine.toCharArray()) {
        	if (arr[c - 'a'] > 0) {
        		arr[c - 'a']--;
        		count--;
        		if (count == 0) return true;
        	}
        }
        return false;
    }
}
