package com.prep2020.medium;
import java.util.*;
public class Problem281 {
	private List<Iterator<Integer>> itrList;
	public Problem281(List<Integer> v1, List<Integer> v2) {
		itrList = new ArrayList<>();
		if (v1.size() > 0) itrList.add(v1.iterator());
		if (v2.size() > 0) itrList.add(v2.iterator());
    }

    public int next() {
        Iterator<Integer> itr = itrList.remove(0);
        int result = itr.next();
        if (itr.hasNext()) itrList.add(itr);
        return result;
    }

    public boolean hasNext() {
        return !itrList.isEmpty();
    }
}
