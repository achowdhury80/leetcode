package comp.prep2019.less2000;

public class Prob1017 {
	public String baseNeg2(int N) {
        int a = 1;
        while(a < N) a = (a << 2) + 1;
        return Integer.toBinaryString(a ^ (a - N));
    }
}
