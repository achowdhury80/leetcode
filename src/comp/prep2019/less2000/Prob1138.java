package comp.prep2019.less2000;

public class Prob1138 {
	public String alphabetBoardPath(String target) {
        char start = 'a';
        String result = "";
        for (char c : target.toCharArray()) {
        	result += helper(start, c);
        	result += '!';
        	start = c;
        }
        return result;
    }
	
	private String helper(char start, char end) {
		if (start == end) return "";
		int[] startPos = new int[] {(start - 'a') / 5, (start - 'a') % 5};
		int[] endPos = new int[] {(end - 'a') / 5, (end - 'a') % 5};
		String result = "";
		String horizontal = "";
		if (startPos[1] < endPos[1]) {
			horizontal += "RRRR".substring(0, endPos[1] - startPos[1]);
		} else if (startPos[1] > endPos[1]) {
			horizontal += "LLLL".substring(0, startPos[1] - endPos[1]);
		}
		String vertical = "";
		if (startPos[0] < endPos[0]) {
			vertical += "DDDDD".substring(0, endPos[0] - startPos[0]);
		} else if (startPos[0] > endPos[0]) {
			vertical += "UUUUU".substring(0, startPos[0] - endPos[0]);
		}
		if (start == 'z') {
			result = vertical + horizontal;
		} else {
			result = horizontal + vertical;
		}
		return result;
	}
}
