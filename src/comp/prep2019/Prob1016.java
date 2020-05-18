package comp.prep2019;

public class Prob1016 {
	public boolean queryString(String S, int N) {
		for (int i = N; i > N / 2; i--) 
        	if (!S.contains(Integer.toBinaryString(i))) return false;
        return true;
    }
}
