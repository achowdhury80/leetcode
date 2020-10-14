package comp.prep2019.less1000;

public class Prob389 {
	public char findTheDifference(String s, String t) {
        int sum = 0;
        for (char c : t.toCharArray()) sum += c;
        for (char c : s.toCharArray()) sum -= c;
        return (char)sum;
    }
}
