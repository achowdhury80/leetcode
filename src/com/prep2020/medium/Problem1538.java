package com.prep2020.medium;

public class Problem1538 {
	public int guessMajority(ArrayReader reader) {
		// The main idea is that if we knew two elements to be the same, then
		// including their indices in the query() call lets us figure out the
		// other two. For example, if we knew elements at indices X and Y to be
		// the same, then invoking query(X, Y, A, B) would mean that
		//
		// - if we got 0, then the elements at both A and B are different from
		//   the elements at X and Y;
		// - if we got 2, then one of the elements at A and B is the same as
		//   the elements at X and Y, but the other one is different;
		// - if we got 4, then the elements at both A and B are the same as
		//   the elements at X and Y.
		//
		// So, our objective is to locate among the first four indices the two whose
		// elements are the same (which is guaranteed to exist). Since the query()
		// function can only return three potential results, by the pigeonhole
		// principle invoking it four times will produce at least two identical 
		// results. And if we select the arguments to query() such that in two
		// invocations three out four arguments are the same, then the different
		// values of the fourth argument are the indices at which the elements are 
		// equal.
		int a = reader.query(1, 2, 3, 4);
		int b = reader.query(0, 2, 3, 4);
		int c = reader.query(0, 1, 3, 4);
		int d = reader.query(0, 1, 2, 4);

		// It does not matter whether the matching two elements are 0s or 1s,
		// but we will assume them to be 0s. Also, we'll track the position
		// of at least a single 1 to return it in case 1s are the majority.
		// We pick the highest of the remaining indices as the position of
		// a potential 1 to slightly optimize index rearranging towards the end.
		int zeroPos1, zeroPos2, potentialOnePos;
		int res;
		if (a == b) {
			zeroPos1 = 0;
			zeroPos2 = 1;
			potentialOnePos = 2;
		} else if (a == c) {
			zeroPos1 = 0;
			zeroPos2 = 2;
			potentialOnePos = 3;
		} else if (a == d) {
			zeroPos1 = 0;
			zeroPos2 = 3;
			potentialOnePos = 2;
		} else if (b == c) {
			zeroPos1 = 1;
			zeroPos2 = 2;
			potentialOnePos = 3;
		} else if (b == d) {
			zeroPos1 = 1;
			zeroPos2 = 3;
			potentialOnePos = 2;
		} else {
			zeroPos1 = 2;
			zeroPos2 = 3;
			potentialOnePos = 1;
		}

		int lastOnePos = -1;
		int zeroCount = 2;
		int oneCount = 0;

		// As discussed, let's figure out what the other two elements
		// (those NOT at indices zeroPos1 and zeroPos2) are.
		// Notice that we do not care about the result of 2 because
		// it does not change the balance of 0s and 1s.
		res = reader.query(0, 1, 2, 3);
		if (res == 0) {
			oneCount += 2;
			lastOnePos = potentialOnePos;
		} else if (res == 4) {
			zeroCount += 2;
		}

		// Now that we're done with the first four indices, let's process
		// the remainder of the array, two elements at a time.
		int l = reader.length();
		for (int i = 4; i < l - 1; i += 2) {
			// Once again, the result of 2 is not interesting to us.
			res = reader.query(zeroPos1, zeroPos2, i, i + 1);
			if (res == 0) {
				oneCount += 2;
				lastOnePos = i;
			} else if (res == 4) {
				zeroCount += 2;
			}
		}

		// In case we had an odd number of elements, check the last one. The first
		// 2 indices are still zeroPos1 and zeroPos2, but for the third we'll pick
		// the index of 1. If we have no index for 1, then 0s are the majority.
		// However, if we do, then we need to make sure that we feed the arguments
		// in an ascending order, so we do a bit of rearranging.
		if (l % 2 == 1) {
			if (lastOnePos >= 0) {
				if (lastOnePos < zeroPos2) {
					int temp = zeroPos2;
					zeroPos2 = lastOnePos;
					lastOnePos = temp;
				}

				if (zeroPos2 < zeroPos1) {
					int temp = zeroPos2;
					zeroPos2 = zeroPos1;
					zeroPos1 = temp;
				}

				res = reader.query(zeroPos1, zeroPos2, lastOnePos, l - 1);
				if (res == 0) {
					oneCount++;
				} else {
					zeroCount++;
				}
			}
		}

		if (oneCount > zeroCount) {
			return lastOnePos;
		} else if (zeroCount > oneCount) {
			return zeroPos1;
		} else {
			return -1;
		}
	}
	interface ArrayReader {
		   // Compares 4 different elements in the array
		      // return 4 if the values of the 4 elements are the same (0 or 1).
		      // return 2 if three elements have a value equal to 0 and one element has value equal to 1 or vice versa.
		      // return 0 : if two element have a value equal to 0 and two elements have a value equal to 1.
		      public int query(int a, int b, int c, int d);
		 
		      // Returns the length of the array
		      public int length();
		  }
}
