package com.prep2020.hard;
import java.util.*;
public class Problem679 {
	public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>();
        for (int c : cards) list.add(0. + c);
        return helper(list);
    }

	private boolean helper(List<Double> list) {
		if (list.size() == 1) return list.get(0) == 24;
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				List<Double> temp = calculate(list, i, j, '+');
				if (helper(temp)) return true;
				temp = calculate(list, i, j, '-');
				if (helper(temp)) return true;
				temp = calculate(list, j, i, '-');
				if (helper(temp)) return true;
				temp = calculate(list, i, j, '*');
				if (helper(temp)) return true;
				if (list.get(j) != 0) {
					temp = calculate(list, i, j, '/');
					if (helper(temp)) return true;
				}
				if (list.get(i) != 0) {
					temp = calculate(list, j, i, '/');
					if (helper(temp)) return true;
				}
			}
		}
		return false;
		
	}

	private List<Double> calculate(List<Double> list, int i, int j, char c) {
		List<Double> temp = new ArrayList<>();
		for (int k = 0; k < list.size(); k++) {
			if (k != i && k != j) temp.add(list.get(k));
		}
		double b = list.get(j), a = list.get(i);
		if (c == '+') {
			temp.add(a + b);
			return temp;
		}
		if (c == '*') {
			temp.add(a * b);
			return temp;
		}
		if (c == '-') {
			temp.add(a - b);
			return temp;
		}
		if (c == '/') {
			temp.add(a / b);
			return temp;
		}
		return null;
	}
}
