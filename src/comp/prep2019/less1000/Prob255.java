package comp.prep2019.less1000;

public class Prob255 {
	public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length < 2) return true;
        return verifyPreorder(preorder, 0, preorder.length - 1, 
        		Integer.MIN_VALUE - 1l, Integer.MAX_VALUE + 1l);
    }
	
	public boolean verifyPreorder(int[] preorder, int start, int end, long min, 
			long max) {
		int root = preorder[start];
		if (root <= min || root >= max) return false;
		if (start == end)  return true;
		
		int leftEnd = -1;
		for (int i = start + 1; i <= end; i++) {
			if (preorder[i] < root) leftEnd = i;
			else break;
		}
		if (leftEnd != -1 && !verifyPreorder(preorder, start + 1, leftEnd, min, root)) return false;
		if (leftEnd == end) return true;
		return verifyPreorder(preorder, leftEnd == -1 ? start + 1 : leftEnd + 1, 
				end, root, max);
	}
}
