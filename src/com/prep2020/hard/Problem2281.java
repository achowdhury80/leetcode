package com.prep2020.hard;
import java.util.*;
public class Problem2281 {
	public int totalStrength(int[] strength) {
        // Null or empty check for input
        if (strength == null || strength.length == 0) return 0;

        int resStrength = 0;                            // Stores the sum of total strengths of all groups of wizards
        int mod = (int) Math.pow(10, 9) + 7;            // Modulus used for the answer
        int ac = 0;                                     //
        int n = strength.length;                        // Length of input

        // Init a Monotonic Stack - 
        // Used ArrayDeque for Stack instead of Stack as ArrayDeque does not require acquiring & releasing thread locks, which is costly in time
        Deque<Integer> stack = new ArrayDeque<Integer>();
        // Init an int arr to store accumulations
        int[] acc = new int[n + 2];

        // Iterate through all wizards strengths from the input arr
        for (int i = 0; i <= n; i++)
        {
            int a = i < n ? strength[i] : 0;

            ac = (ac + a) % mod;
            acc[i + 1] = (ac + acc[i]) % mod;

            while (!stack.isEmpty() && strength[stack.peek()] > a)
            {
                int j = stack.pop();
                int l = stack.isEmpty() ? -1 : stack.peek();

                long leftAcc = l < 0 ? acc[j] : acc[j] - acc[l];
                long rightAcc = acc[i] - acc[j];
                
                int ln = j - l;
                int rn = i - j;

                resStrength = (int) (resStrength + (rightAcc * ln - leftAcc * rn) % mod * strength[j] % mod) % mod;
            }

            stack.push(i);
        }

        // Return the sum of the total strengths of all contiguous groups of qizards in mod(10^9) + 7
        return (resStrength + mod) % mod;
    }
}
