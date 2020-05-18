package comp.prep2019;

public class Prob345 {
	public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int l = 0, h = s.length() - 1;
        while(l < h) {
        	if ("aeiou".indexOf(Character.toLowerCase(arr[l])) < 0) {
        		l++;
        		continue;
        	}
        	if ("aeiou".indexOf(Character.toLowerCase(arr[h])) < 0) {
        		h--;
        		continue;
        	}
        	char c = arr[l];
        	arr[l] = arr[h];
        	arr[h] = c;
        	l++;
        	h--;
        }
        return new String(arr);
    }
}
