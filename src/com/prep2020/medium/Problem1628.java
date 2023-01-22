package com.prep2020.medium;
import java.util.*;
public class Problem1628 {
	
	
	abstract class Node {
	    public abstract int evaluate();
	    // define your fields here
	};
	
	Node buildTree(String[] postfix) {
        Deque<MyNode> stack = new ArrayDeque<>();
        for (String st : postfix) {
        	if ("+-/*".indexOf(st) < 0) stack.push(new MyNode(st));
        	else {
        		MyNode myNode = new MyNode(st);
        		myNode.rightNode = stack.pop();
        		myNode.leftNode = stack.pop();
        		stack.push(myNode);
        	}
        }
        return stack.pop();
    }
	
	class MyNode extends Node {
		MyNode leftNode, rightNode;
		String st;
		@Override
		public int evaluate() {
			if ("+-/*".indexOf(st) < 0) return Integer.parseInt(st);
			int left = leftNode.evaluate(), right = rightNode.evaluate();
			if ("+".equals(st)) return left + right;
			if ("-".equals(st)) return left - right;
			if ("*".equals(st)) return left * right;
			return left / right;
		}
		
		MyNode(String st) {
			this.st = st;
		}
		
	}
}
