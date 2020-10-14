package comp.prep2019.less2000;

public class Prob1009 {
	public int bitwiseComplement(int N) {
        if (N == 0) return 1;
        int temp = N;
        int mask = 0;
        while(temp > 0) {
        	mask = (mask << 1) | 1;
        	temp >>= 1;
        }
        return N ^ mask;
    }
	
	public static void main(String[] args) {
		Prob1009 prob = new Prob1009();
		System.out.println(prob.bitwiseComplement(5));
	}
}
