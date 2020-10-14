package comp.prep2019.less1000;

public class Prob521 {
	public int findLUSlength(String a, String b) {
        if (a.length() == b.length() && a.equals(b)) return -1;
        return Math.max(a.length(), b.length());
    }
}
