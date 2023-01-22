package com.prep2020.easy;

public class Problem38 {
	/**
	 * Time Complexity: \mathcal{O}(2^n)O(2 
n
 ) where nn is the index of the desired sequence.
First of all, we would invoke the function nextSequence() n-1n−1 times to get the desired sequence.
For each invocation of the function, we would scan the current sequence whose length is difficult to determine though.
Let us image in the worst scenario where any two adjacent digit in the sequence are not identical, then its next sequence would double the length, rather than having a reduced length. As a result, we could assume that in the worst case, the length of the sequence would grow exponentially.
As a result, the overall time complexity of the algorithm would be \mathcal{O}(\sum_{i=0}^{n-1}{2^i}) = \mathcal{O}(2^n)O(∑ 
i=0
n−1
​	
 2 
i
 )=O(2 
n
 ).
Space Complexity: \mathcal{O}(2^{n-1})O(2 
n−1
 ).
Within each invocation of the nextSequence() function, we are using a container to keep the result of the next sequence. The memory consumption of the container is proportional to the length of the sequence that the function needs to process, i.e 2^{n-1}2 
n−1
 .
Though we were applying the recursion function, which typically incurs some additional memory consumption in call stack. In our case though, the recursion is implemented in the form of tail recursion, and we assume that the compiler could optimize its execution which would not incur additional memory consumption.
One could also easily replace the recursion with the iteration in this case.
As a result, the overall space complexity of the algorithm would be dominated by the space needed to hold the final sequence, i.e. \mathcal{O}({2^{n-1}})O(2 
n−1
 ).
	 * @param n
	 * @return
	 */
	public String countAndSay(int n) {
        String last = "1";
        for (int i = 1; i < n; i++) last = say(last);
        return last;
    }
	
	private String say(String num) {
		char last = 'x';
		int count = 0;
		String result = "";
		for (int i = 0; i < num.length(); i++) {
			char c = num.charAt(i);
			if (last == 'x' || last == c) {
				last = c;
				count++;
			}
			else {
				result += count + "" + last;
				last = c;
				count = 1;
			}
		}
		result += count + "" + last;
		return result;
	}
	
	public static void main(String[] args) {
		Problem38 prob = new Problem38();
		System.out.println(prob.countAndSay(4));
	}
}
