package comp.prep2019;

public class Prob426 {
	public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        return convert(root)[0];
    }
	
	/**
	 * returns head and tail of the converted list
	 * head.left = tail and tail.right = head
	 * @param root
	 * @return
	 */
	private Node[] convert(Node root) {
		if (root == null) return new Node[] {null, null};
		Node[] left = convert(root.left);
		Node[] right = convert(root.right);
		//left tail's right is root
		if (left[1] != null) {
			left[1].right = root;
		}
		root.left = left[1];
		root.right = right[0];
		// right's head prev is root
		if (right[0] != null) {
			right[0].left = root;
		}
		
		
		//adjust head tail, considering left or right list can be null
		Node[] headNTail = new Node[] {
				left[0] != null ? left[0] : root,
				right[1] != null ? right[1] : root		
		};
		headNTail[0].left = headNTail[1];
		headNTail[1].right = headNTail[0];
		return headNTail;
	}
	
	class Node {
	    public int val;
	    public Node left;
	    public Node right;

	    public Node() {}

	    public Node(int _val,Node _left,Node _right) {
	        val = _val;
	        left = _left;
	        right = _right;
	    }
	};
}
