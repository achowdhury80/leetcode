package com.leet.algo;
import java.util.*;
public class Prob559 {
	public int maxDepth(Node root) {
        if (root == null) return 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int result = 0;
        while(!q.isEmpty()) {
        	result++;
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		Node node = q.poll();
        		if (node.children != null) for (Node child : node.children) q.offer(child);
        	}
        	
        }
        return result;
    }
}
