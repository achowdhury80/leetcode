package com.leet.algo;

/**
 * Created by ayanc on 2/4/18.
 */
public class Prob779 {
  public int kthGrammar(int N, int K) {
    if (N == 1 || K == 1) return 0;
    return K % 2 == 0 ? (kthGrammar(N - 1, K / 2) == 0 ? 1 : 0) : (kthGrammar(N - 1, (K + 1) / 2) == 0 ? 0 : 1);
  }

  public static void main(String[] args) {
    Prob779 prob779 = new Prob779();
    System.out.println(prob779.kthGrammar(1, 1));
    System.out.println(prob779.kthGrammar(2, 1));
    System.out.println(prob779.kthGrammar(2, 2));
    System.out.println(prob779.kthGrammar(4, 5));
  }
}
