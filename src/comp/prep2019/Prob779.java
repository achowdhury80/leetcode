package comp.prep2019;

public class Prob779 {
	public int kthGrammar(int N, int K) {
        if (N == 1 || K == 1) return 0;
        return K % 2 == 0 
        		? (kthGrammar(N - 1, K / 2) == 0 ? 1 : 0) :
        			(kthGrammar(N - 1, (K + 1)/ 2) == 0 ? 0 : 1);
    }
}
