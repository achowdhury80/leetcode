package com.prep2020.medium;
import java.util.*;
public class Problem1648 {
	public int maxProfit(int[] inventory, int orders) {
        long modulo = 1000000007;
        Arrays.sort(inventory);
        
        int cnt = 0, i  = inventory.length - 1;
        long sum = 0;
        while (orders > 0) {
            cnt++;
            int n = inventory[i];
            int d = i >= 1? n - inventory[i - 1] : 0; // difference between next ball

            if (d == 0 && i != 0) {
                i--;
                continue;
            }


            if (i > 0 && orders >= d * cnt) {
                sum += (long) (n - d + 1 + n) *d / 2 * cnt;
                orders -=  d * cnt;
            } else {
                int a = orders / cnt;
                sum += (long) (n - a + 1 + n) * a / 2 * cnt;
                int b = orders % cnt;
                sum += (long) (n - a) * b;
                orders = 0;
            }
            sum = (sum + modulo) % modulo;
            i--;
        }
        return (int) sum;     
    }
	
	public static void main(String[] args) {
		Problem1648 problem = new Problem1648();
		//System.out.println(problem.maxProfit(new int[] {3,  5}, 6));
		System.out.println(problem.maxProfit(new int[] {497978859,167261111,483575207,
				591815159}, 836556809));
	}
}
