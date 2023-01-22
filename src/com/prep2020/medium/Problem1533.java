package com.prep2020.medium;

public class Problem1533 {
	/**
	 * O(logn)
	 * @param reader
	 * @return
	 */
	public int getIndex(ArrayReader reader) {
        return find(reader, 0, reader.length() - 1);
    }
	
	private int find(ArrayReader reader, int start, int end) {
		if (start == end) return start;
		int partLen = (end - start + 3) / 3;
		int l = start, r = start + partLen - 1, x = r + 1,
				y = x + partLen - 1;
		int retVal = reader.compareSub(l, r, x, y);
		if (retVal == 1) return find(reader, l, r);
		else if (retVal == -1) return find(reader, x, y);
		return find(reader, y + 1, end);
	}
	
	interface ArrayReader {
	      // Compares the sum of arr[l..r] with the sum of arr[x..y] 
	      // return 1 if sum(arr[l..r]) > sum(arr[x..y])
	      // return 0 if sum(arr[l..r]) == sum(arr[x..y])
	      // return -1 if sum(arr[l..r]) < sum(arr[x..y])
	      public int compareSub(int l, int r, int x, int y);
	 
	      // Returns the length of the array
	      public int length();
	  }
}
