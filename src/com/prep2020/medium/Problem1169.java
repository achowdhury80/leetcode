package com.prep2020.medium;
import java.util.*;
public class Problem1169 {
	public List<String> invalidTransactions(String[] transactions) {
        Arrays.sort(transactions, (x, y) -> compare(x, y));
        String last = "";
        int n = transactions.length;
        Deque<List<String>> dq = new ArrayDeque<>();
        boolean[] invalid = new boolean[n];
        Map<String, Integer> cityCount = new HashMap<>();
        for (int i = 0; i < transactions.length; i++) {
        	String[] arr = transactions[i].split(",");
        	if (Integer.parseInt(arr[2]) > 1000) invalid[i] = true;
        	if (!last.equals(arr[0])) {
        		cityCount.clear();
        		cityCount.put(arr[3], 1);
        		dq.clear();
        		List<String> list = new ArrayList<>();
        		for (String s : arr) list.add(s);
        		dq.offerLast(list);
        		last = arr[0];
        		continue;
        	}
        	
        	List<String> list = new ArrayList<>();
    		for (String s : arr) list.add(s);
    		dq.offerLast(list);
    		cityCount.put(arr[3], cityCount.getOrDefault(arr[3], 0) + 1);
    		
        	while(!dq.isEmpty() && Integer.parseInt(arr[1]) - Integer.parseInt(dq.peekFirst().get(1)) > 60) {
        		String city = dq.pollFirst().get(3);
        		cityCount.put(city, cityCount.get(city) - 1);
        		if (cityCount.get(city) == 0) cityCount.remove(city);
        	}
        	
        	if (cityCount.size() > 1) {
        		for (int j = 0; j < dq.size() ; j++) invalid[i - j] = true;
        	}
        	
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) if (invalid[i]) result.add(transactions[i]);
        return result;
    }

	private int compare(String x, String y) {
		String[] arr1 = x.split(","), arr2 = y.split(",");
		if (!arr1[0].equals(arr2[0])) return arr1[0].compareTo(arr2[0]);
		return Integer.parseInt(arr1[1]) - Integer.parseInt(arr2[1]);
	}
	
	public static void main(String[] args) {
		Problem1169 problem = new Problem1169();
		System.out.println(problem.invalidTransactions(new String[] {"alice,20,800,mtv","alice,50,100,beijing"}));
	}
}
