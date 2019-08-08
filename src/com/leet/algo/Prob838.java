package com.leet.algo;
public class Prob838 {
	/**
	 * Intuition

Between every group of vertical dominoes ('.'), we have up to two non-vertical dominoes bordering this group. Since additional dominoes outside this group do not affect the outcome, we can analyze these situations individually: there are 9 of them (as the border could be empty). Actually, if we border the dominoes by 'L' and 'R', there are only 4 cases. We'll write new letters between these symbols depending on each case.

Algorithm

Continuing our explanation, we analyze cases:

If we have say "A....B", where A = B, then we should write "AAAAAA".

If we have "R....L", then we will write "RRRLLL", or "RRR.LLL" if we have an odd number of dots. If the initial symbols are at positions i and j, we can check our distance k-i and j-k to decide at position k whether to write 'L', 'R', or '.'.

(If we have "L....R" we don't do anything. We can skip this case.)
	 * @param dominoes
	 * @return
	 */
	public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] index = new int[n + 2];
        char[] arr = dominoes.toCharArray();
        index[0] = -1;
        int len = 1;
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] != '.') {
        		index[len] = i;
        		len++;
        	}
        }
        index[len] = n;
        char[] ans = dominoes.toCharArray();
        for (int i = 0; i < len; i++) {
        	int j = index[i];
        	int k = index[i + 1];
        	char x = i == 0 ? 'L' : arr[j];
        	char y = (i + 1) == len ? 'R' : arr[k];
        	if(x == y) {
        		for (int l = j + 1; l < k; l++) ans[l] = x;
        	} else if (x > y){
        		for (int l = j + 1; l < k; l++) 
        			ans[l] = l - j == k - l ? '.' : l - j < k - l ? 'R' : 'L';
        	}
        }
        return new String(ans);
    }
}
