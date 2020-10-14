package comp.prep2019;

public class Prob1533 {
	/**
	 * O(logN) time
	 * @param reader
	 * @return
	 */
	public int getIndex(ArrayReader reader) {
        int len = reader.length();
        int low = 0, high = len - 1;
        while (low < high) {
        	int count = high - low + 1;
        	if (count == 2) {
        		int retVal = reader.compareSub(low, low, high, high);
        		if (retVal == 1) return low;
        		return high;
        	}
        	int part = count / 3;
        	int retVal = reader.compareSub(low, low + part - 1, low + part, low + 2 * part - 1);
        	if (retVal == 0) {
        		low = low + 2 * part;
        	} else if (retVal == 1) {
        		high = low + part;
        	} else {
        		low = low + part;
        	}
        }
        return low;
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
