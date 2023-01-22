package com.prep2020.medium;

public class Problem1915 {
	public long wonderfulSubstrings(String word) {
        long[] count = new long[1024];
        count[0]=1;
        int cur = 0;
        long res=0L;
        for(char c: word.toCharArray()) {
            int idx= c-'a';
            cur^=1<<idx;
            res+=count[cur]++;
            for(int i=0;i<10;i++) {
                int temp = cur ^ (1<<i);
                res+=count[temp];
            }
        }
        return res;
    }
}
