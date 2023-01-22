package com.prep2020.hard;
import java.util.*;
public class Problem2355 {
	public long maximumBooks(int[] books) {
		int n = books.length;
        Map<Integer, Long> cache = new HashMap<>();
        long result = 0;
        for (int i = 0; i < n; i++) {
        	if (i == n - 1 || books[i] > books[i + 1]) {
        		result = Math.max(result, findCount(books, i, books[i], cache));
        	}
        }
        return result;
    }

	private long findCount(int[] books, int index, int bookToBeTaken, Map<Integer, Long> cache) {
		int key = (index << 14) | bookToBeTaken;
		if (cache.containsKey(key)) return cache.get(key);
		long result = bookToBeTaken;
		if (bookToBeTaken > 1 && index > 0 && books[index - 1] > 0) {
			result += findCount(books, index - 1, Math.min(bookToBeTaken - 1, books[index - 1]), cache);
		}
		cache.put(key, result);
		return result;
	}
}
