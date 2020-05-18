package comp.prep2019;

public class Prob1157 {
	private SegmentTreeNode root;
	public Prob1157(int[] arr) {
		root = buildTree(0, arr.length - 1, arr);
    }
    
    public int query(int left, int right, int threshold) {
        Pair cand = queryTree(left, right, root);
        if (cand.freq >= threshold) return cand.val;
        return -1;
    }
    
    private SegmentTreeNode buildTree(int start, int end, int[] nums) {
    	if (start == end) return new SegmentTreeNode(start, end, new Pair(nums[start], 1));
    	int mid = start + (end - start) / 2;
    	SegmentTreeNode root = new SegmentTreeNode(start, end, null);
    	root.left = buildTree(start, mid, nums);
    	root.right = buildTree(mid + 1, end, nums);
    	root.pair = mergePair(root.left.pair, root.right.pair);
    	return root;
    }
    
    private Pair mergePair(Pair pair1, Pair pair2) {
    	if (pair1.val == pair2.val) return new Pair(pair1.val, pair1.freq + pair2.freq);
    	if (pair1.freq > pair2.freq) return new Pair(pair1.val, pair1.freq - pair2.freq);
    	return new Pair(pair2.val, pair2.freq - pair1.freq); 
    }
    
    private Pair queryTree(int start, int end, SegmentTreeNode root) {
        if (start <= root.start && root.end <= end) {
            return root.pair;
        }

        Pair res = new Pair(0, 0);
        int mid = root.start + (root.end - root.start) / 2;
        if (start <= mid) {
            res = mergePair(res, queryTree(start, end, root.left));
        }
        if (mid < end) {
            res = mergePair(res, queryTree(start, end, root.right));
        }

        return res;
    }
    
    class Pair {
    	int val, freq;
    	Pair(int val, int freq) {
    		this.val = val;
    		this.freq = freq;
    	}
    }
    
    class SegmentTreeNode {
    	Pair pair;
    	SegmentTreeNode left, right;
    	int start, end;
    	
    	SegmentTreeNode(int start, int end, Pair pair) {
    		this.pair = pair;
    		this.start = start;
    		this.end = end;
    	}
    }
}
