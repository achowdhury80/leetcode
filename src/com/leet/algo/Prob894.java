package com.leet.algo;
import java.util.*;
public class Prob894 {
	public List<TreeNode> allPossibleFBT(int N) {
		List<TreeNode> list = new ArrayList<>();
		if (N % 2 == 0) return list;
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        map.put(1,  Arrays.asList(new TreeNode[] {new TreeNode(0)}));
        for (int i = 3; i <= N; i += 2) {
        	List<TreeNode> l = new ArrayList<>();
        	for (int j = 1; j <= i - 2; j += 2) {
        		List<TreeNode> left = map.get(j);
        		List<TreeNode> right = map.get(i - j - 1);
        		for (int m = 0; m < left.size(); m++) {
        			for (int n = 0; n < right.size(); n++) {
        				TreeNode  node = new TreeNode(0);
        				node.left = left.get(m);
        				node.right = right.get(n);
        				l.add(node);
        			}
        		}
        	}
        	map.put(i, l);
        }
        return map.get(N);
    }
	
	
}
