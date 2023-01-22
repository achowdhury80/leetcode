package com.prep2020.medium;

public class Problem1927 {
	/**
	 * O(N)
	 * @param num
	 * @return
	 */
	public boolean sumGame(String num) {
        int firstHalf = 0, secondHalf = 0, firstHalfQ = 0, 
        		secondHalfQ = 0, n = num.length();
        for (int i = 0; i < n; i++) {
        	if (num.charAt(i) == '?') {
        		if (i < n / 2) firstHalfQ++;
        		else secondHalfQ++;
        	}
        	else {
        		if (i < n / 2) firstHalf += num.charAt(i) - '0';
        		else secondHalf += num.charAt(i) -'0';
        	}
        }
        if ((firstHalfQ + secondHalfQ) % 2 == 1) return true;
        if (firstHalfQ > secondHalfQ) {
        	firstHalfQ -= secondHalfQ;
        	secondHalfQ = 0;
        } else {
        	secondHalfQ -= firstHalfQ;
        	firstHalfQ = 0;
        }
        if (firstHalfQ == secondHalfQ) return firstHalf != secondHalf;
        if (firstHalfQ > secondHalfQ) {
        	if (firstHalf >= secondHalf) return true;
        	int diff =  secondHalf - firstHalf;
        	int perHead = firstHalfQ / 2;
        	if (perHead * 9 > diff) return true;
        	if (perHead * 9 < diff) return true;
        	return false;
        } else {
        	if (secondHalf >= firstHalf) return true;
        	int diff = firstHalf - secondHalf;
        	int perHead = secondHalfQ / 2;
        	if (perHead * 9 < diff) return true;
        	if (perHead * 9 > diff) return true;
        	return false;
        }
    }
	
	public static void main(String[] args) {
		Problem1927 problem = new Problem1927();
		//System.out.println(problem.sumGame("5023"));
		//System.out.println(problem.sumGame("?3295???"));
		System.out.println(problem.sumGame("?0?91172275656701?361205452?62??99?9??4478?7967373994600735??4?079246???5827572?81087461?089"));
		//System.out.println(problem.sumGame("25??"));
	}
}
