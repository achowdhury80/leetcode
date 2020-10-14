package comp.prep2019.less1000;
import java.util.*;
public class Prob411 {
	/**
	 * https://leetcode.com/problems/minimum-unique-word-abbreviation/discuss/161070/Step-by-step-using-PriorityQueue
	 * @param target
	 * @param dictionary
	 * @return
	 */
	public String minAbbreviation(String target, String[] dictionary) {
        if (dictionary.length == 0) return "" + target.length();
        Queue<Pair> q = new PriorityQueue<>((x, y) -> x.length - y.length);
        populateAbbr(q, target, "", 0, 0, 0);
        while(!q.isEmpty()) {
        	Pair pair = q.poll();
        	if (!foundAbbr(dictionary, pair)) {
        		return pair.str;
        	}
        }
        return "";
    }
	
	private boolean foundAbbr(String[] dictionary, Pair pair) {
		for (String w : dictionary) {
			int i = 0, j = 0, count = 0;
			while(i < w.length() && j < pair.str.length()) {
				if (Character.isLetter(pair.str.charAt(j))) {
					if (i + count > w.length()) break;
					else i += count;
					count = 0;
					if (i < w.length() && w.charAt(i) != pair.str.charAt(j)) break;
					i++;
					j++;
				} else {
					count = count * 10 + (pair.str.charAt(j) - '0');
					j++;
				}
			}
			if (i == w.length() && j == pair.str.length() && count == 0) return true;
			if (i < w.length() && count > 0 && i + count == w.length()) return true;
		}
		return false;
	}

	private void populateAbbr(Queue<Pair> q, String target, String cur, int pos, 
			int count, int length) {
		if (pos == target.length()) {
			q.offer(new Pair(cur + (count == 0 ? "" : ("" + count)), 
					length + (count == 0 ? 0 : 1)));
			return;
		}
		populateAbbr(q, target, cur, pos + 1, count + 1, length);
		populateAbbr(q, target, cur + (count == 0 ? "" : ("" + count)) 
				+ target.charAt(pos), pos + 1, 0, length + 1 + (count == 0 ? 0 : 1));
	}
	
	class Pair {
		String str;
		int length;
		Pair(String str, int length) {
			this.str = str;
			this.length = length;
		}
	}
	
	public static void main(String[] args) {
		Prob411 prob = new Prob411();
		System.out.println(prob.minAbbreviation("apple", new String[]{"blade"}));
	}
}
