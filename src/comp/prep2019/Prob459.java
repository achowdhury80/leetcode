package comp.prep2019;

public class Prob459 {
	public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) < s.length();
    }
}
