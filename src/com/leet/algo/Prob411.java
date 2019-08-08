package com.leet.algo;
import java.util.*;
public class Prob411 {
	public String minAbbreviation(String target, String[] dictionary) {
		boolean sameLengthNotFound = true;
		for (String w : dictionary) {
			if (target.length() == w.length()) {
				sameLengthNotFound = false;
				break;
			}
		}
		if (sameLengthNotFound) return "" + target.length();
		List<Abbv> list = findAbbvs(target);
		PriorityQueue<Abbv> pq = new PriorityQueue<>((a, b) -> a.length - b.length);
		for (Abbv abbv : list) pq.offer(abbv);
		while(!pq.isEmpty()) {
			Abbv abbv = pq.poll();
			boolean found = true;
			for (String w : dictionary) {
				if (w.length() == target.length() && matchesAbbv(w, abbv)) {
					found = false;
					break;
				}
			}
			if (found) return abbv.abbv;
		}
		return "";
    }
	
	private List<Abbv> findAbbvs(String target) {
		List<Abbv> result = new ArrayList<>();
		for (int i = 0; i < Math.pow(2, target.length()); i++) {
			int j = i;
			int count = 0, masked = 0;
			String st = "";
			int numBits = 0;
			int k = target.length() - 1;
			while(j > 0) {
				if ((j & 1) == 1) {
					if (masked != 0) {
						st = masked + st;
						count++;
						masked = 0;
					}
					st = target.charAt(k) + st;
					count++;
				} else {
					masked++;
				}
				j >>= 1;
				k--;
				numBits++;
			}
			if (masked != 0) {
				st = masked + st;
				count++;
				masked = 0;
			} 
			if (numBits < target.length()) {
				st = (target.length() - numBits) + st;
				count++;
			}
			result.add(new Abbv(st, count));
		}
		return result;
	}
	
	private boolean matchesAbbv(String word, Abbv abbv) {
		for (int i = 0, k = 0; i < abbv.abbv.length(); i++) {
			char c;
			if (Character.isLetter((c = abbv.abbv.charAt(i)))) {
				if (c != word.charAt(k++)) return false;
			} else {
				String str = "" + abbv.abbv.charAt(i);
				int j;
				for (j = i + 1; j < abbv.abbv.length() && !Character.isLetter(abbv.abbv.charAt(j)); j++) {
					str += abbv.abbv.charAt(j);
				}
				int count = Integer.parseInt(str);
				i = j - 1;
				k += count;
			}
		}
		return true;
	}
	
	class Abbv {
		String abbv;
		int length;
		Abbv(String abbv, int length) {
			this.abbv = abbv;
			this.length = length;
		}
	}
	
	public static void main(String[] args) {
		Prob411 prob = new Prob411();
		System.out.println(prob.minAbbreviation("apple", new String[]{"blade"}));
	}
}
