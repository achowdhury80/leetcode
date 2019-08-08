package com.leet.algo;

public class Prob820 {
	public int minimumLengthEncoding(String[] words) {
       Trie root = new Trie();
       int result = 0;
       for (String w : words) {
    	   Trie cur = root;
    	   char[] arr = w.toCharArray();
    	   reverse(arr);
    	   for (int i = 0; i < arr.length; i++) {
    		   char c = arr[i];
    		   if (cur.children[c - 'a'] != null) {
    			   if (cur.children[c - 'a'].end) {
    				   i++;
    				   if (i < arr.length) {
    					   cur.children[c - 'a'].end = false;
    					   cur = cur.children[c - 'a'];
    					   while(i < arr.length) {
    						   char ch = arr[i];
    						   cur.children[ch - 'a'] = new Trie();
    						   cur = cur.children[ch - 'a'];
    						   i++;
    						   result++;
    					   }
    					   cur.end = true;
    				   }
    				   break;
    			   }
    			   cur = cur.children[c - 'a'];
    		   } else {
    			   result += (i + 1);
    			   while(i < arr.length) {
    				   char ch = arr[i];
					   cur.children[ch - 'a'] = new Trie();
					   cur = cur.children[ch - 'a'];
					   i++;
					   result++;
    			   }
    			   cur.end = true;
    			   break;
    		   }
    	   }
    	   
       }
       return result;
    }
	
	private void reverse(char[] arr) {
		int i = 0, j = arr.length - 1;
		while (i < j) {
			exchange(arr, i, j);
			i++;
			j--;
		}
	}
	
	private void exchange(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	class Trie {
		Trie[] children = new Trie[26];
		boolean end;
	}
	
	public static void main(String[] args) {
		Prob820 prob = new Prob820();
		//System.out.println(prob.minimumLengthEncoding(new String[] {"time", "me", "bell"}));
		System.out.println(prob.minimumLengthEncoding(new String[] {"me", "time"}));
	}
}
