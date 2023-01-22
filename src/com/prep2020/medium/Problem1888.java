package com.prep2020.medium;

public class Problem1888 {
	public int minFlips(String s) {
	      final int n = s.length();
	      final int totalOdd = n/2;
	      final int totalEven = totalOdd + (n % 2);
	      int onesInEven = 0;
	      int onesInOdd = 0;

	      for (int i = 0; i < n; i++) {
	        if (s.charAt(i) == '0') {
	          continue;
	        }

	        if (i % 2 == 0) {
	          // Even
	          onesInEven++;
	        } else {
	          // Odd
	          onesInOdd++;
	        }
	      }

	      int flipsForOneInEven = (totalEven - onesInEven) + onesInOdd;
	      int flipsForOneInOdd = (totalOdd - onesInOdd) + onesInEven;
	      int min = Math.min(flipsForOneInEven, flipsForOneInOdd);

	      if (n%2 == 0 || min == 0) {
	        return min;
	      }

	      int temp, tempMin;

	      for (int i=0; i < n-1; i++) {
	        char c = s.charAt(i);

	        temp = onesInEven;
	        onesInEven = onesInOdd;
	        onesInOdd = temp;

	        if (c == '1') {
	          onesInEven++;
	          onesInOdd--;
	        }

	        flipsForOneInEven = (totalEven - onesInEven) + onesInOdd;
	        flipsForOneInOdd = (totalOdd - onesInOdd) + onesInEven;
	        tempMin = Math.min(flipsForOneInEven, flipsForOneInOdd);
	        
	        if (tempMin == 0) {
	          return 0;
	        }
	        
	        if (tempMin < min) {
	          min = tempMin;
	        }
	      }

	      return min;
	    }
}
