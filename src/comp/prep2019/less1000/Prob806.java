package comp.prep2019.less1000;

public class Prob806 {
	public int[] numberOfLines(int[] widths, String S) {
		int lines = 0, count = 0;
        for (char c : S.toCharArray()) {
        	if (count + widths[c - 'a'] <= 100) {
        		count = count + widths[c - 'a'];
        	} else {
        		lines++;
        		count = widths[c - 'a'];
        	}
        }
        return new int[] {lines + 1, count};
    }
}
