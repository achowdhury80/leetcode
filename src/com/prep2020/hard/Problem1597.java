package com.prep2020.hard;
import java.util.*;
public class Problem1597 {
	/**
	 * O(N) time and space
	 * @param s
	 * @return
	 */
	public Node expTree(String s) {
        Deque<Character> opStack = new ArrayDeque<>();
        Deque<Node> operandStack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
        	if (c >= '0' && c <= '9') {
        		Node node = new Node(c);
        		operandStack.push(node);
        	} else {
        		if (c == ')') {
        			char op = opStack.pop();
        			while(op != '(') {
        				Node node = new Node(op);
        				node.right = operandStack.pop();
        				node.left = operandStack.pop();
        				operandStack.push(node);
        				op = opStack.pop();
        			}
        		} else if (opStack.isEmpty() || c == '(' || opStack.peek() == '(') {
        			opStack.push(c);
        		}else { // +, -, /, *
        			char prev = opStack.peek();
        			while (!opStack.isEmpty() && (c == '+' || c == '-' || prev == '/' || prev == '*')) {
        				Node node = new Node(opStack.pop());
        				node.right = operandStack.pop();
        				node.left = operandStack.pop();
        				operandStack.push(node);
        				if (opStack.isEmpty() || opStack.peek() == '(') break;
        				prev = opStack.peek();
        			}
        			opStack.push(c);
        		}
        	}
        }
        while(!opStack.isEmpty()) {
        	Node node = new Node(opStack.pop());
			node.right = operandStack.pop();
			node.left = operandStack.pop();
			operandStack.push(node);
        }
        return operandStack.pop();
    }
	
	public static void main(String[] args) {
		Problem1597 problem = new Problem1597();
		//System.out.println(problem.expTree("2-3/(5*2)+1"));
		System.out.println(problem.expTree("(9*9-(9-7)*3)/(3*1)"));
	}
	
	class Node {
		      char val;
		      Node left;
		      Node right;
		      Node() {this.val = ' ';}
		      Node(char val) { this.val = val; }
		      Node(char val, Node left, Node right) {
		          this.val = val;
		          this.left = left;
		          this.right = right;
		      }
		  }
}
