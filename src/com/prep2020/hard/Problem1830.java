package com.prep2020.hard;

public class Problem1830 {
	// don't try to understand it
	long[] inv = new long[3001];
    long[] fact = new long[3001];
    long[] invfact = new long[3001];
    int M = (int)1e9+7;
    public int makeStringSorted(String s) {
        int[] count = new int[26];
        for (char ch : s.toCharArray()){
            count[ch-'a']++;
        }
        fact[0]=invfact[0]=fact[1]=invfact[1]=inv[1]=1;
        long ans = 0;
        for (int i = 2; i <= 3000; i++){ // mod inverse stuff
            inv[i] = M-M/i*inv[M%i]%M;
            fact[i] = fact[i-1]*i%M;
            invfact[i] = invfact[i-1]*inv[i]%M;
        }
        for (int j = 0; j < s.length(); j++){
            int ttl = 0, pos = s.charAt(j)-'a';
            for (int i = 0; i < pos; i++){
                ttl += count[i];
            }
            long cur = ttl * fact[s.length()-1-j] % M;
            for (int i = 0; i < 26; i++){
                cur *= invfact[count[i]];
                cur %= M;
            }
            count[pos]--;
            ans += cur;
            ans %= M;
        }
        return (int)ans;
    }
}
