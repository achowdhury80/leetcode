package com.leet.algo;

public class Prob1055 {
	public int shortestWay(String source, String target) {
        int result = 0;
        char [] src = source.toCharArray();
        char[] targt = target.toCharArray();
        int cur = 0;
        boolean matched = false;
        for (int i = 0; i < targt.length; i++) {
        	if (cur == 0) result++;
        	if(src[cur] != targt[i]) i--;
        	else matched = true;
        	cur++;
        	if (cur == src.length) {
        		if(!matched) return -1;
        		cur = 0;
        		matched = false;
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob1055 prob = new Prob1055();
		System.out.println(prob.shortestWay("abc", "abcbc"));
		System.out.println(prob.shortestWay("abc", "acdbc"));
		System.out.println(prob.shortestWay("xyz", "xzyxz"));
	}
}
