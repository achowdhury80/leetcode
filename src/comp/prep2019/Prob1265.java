package comp.prep2019;

public class Prob1265 {
	/*
	 * O(n) time and space
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
