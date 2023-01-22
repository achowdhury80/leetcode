package com.prep2020.medium;

public class Problem1265 {
	/**
	 * O(N) time and space
	 * @param head
	 */
	public void printLinkedListInReverse(ImmutableListNode head) {
		if (head == null) return;
        printLinkedListInReverse(head.getNext());
        head.printValue();
    }
	
	interface ImmutableListNode {
		      public void printValue(); // print the value of this node.
		      public ImmutableListNode getNext(); // return the next node.
		  }
}
