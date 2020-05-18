package comp.prep2019;

public class Prob796 {
	public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).indexOf(B, 1) > -1;
    }
}
