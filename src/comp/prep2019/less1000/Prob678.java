package comp.prep2019.less1000;
public class Prob678 {
	public boolean checkValidString(String s) {
        return helper(s, '(', 0, 1, s.length()) && helper(s, ')', s.length() - 1, -1, s.length());
    }
	
	private boolean helper(String s, char c, int start, int dir, int len) {
		int starCount = 0;
        int count = 0;
        for (int i = 0; i < len; i++) {
        	char ch = s.charAt(start + i * dir);
        	if (ch == c) count++;
        	else if (ch == '*') starCount++;
        	else {
        		if (count > 0) count--;
        		else if (starCount > 0) starCount--;
        		else return false;
        	}
        }
        return count <= starCount;
	}
	
	public static void main(String[] args) {
		Prob678 prob = new Prob678();
		//System.out.println(prob.checkValidString("()"));
		System.out.println(prob.checkValidString("(*)"));
	}
	
}
