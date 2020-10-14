package comp.prep2019.less1000;

public class Prob744 {
	public char nextGreatestLetter(char[] letters, char target) {
		if (letters[letters.length - 1] <= target) return letters[0];
        int low = 0, high = letters.length - 1;
        while(low < high) {
        	int mid = low + (high - low) / 2;
        	if (letters[mid] <= target) low = mid + 1;
        	else high = mid;
        }
        return letters[low];
    }
}
