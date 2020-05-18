package comp.prep2019;
import java.util.*;
public class Prob508 {
	public int[] findFrequentTreeSum(TreeNode root) {
		if(root == null) return new int[0];
		Map<Integer, Integer> sumFreq = new HashMap<>();
		Set<Integer> mostFreq = new HashSet<>();
		helper(root, sumFreq, mostFreq, new int[] {0});
		int[] result = new int[mostFreq.size()];
		int i = 0;
		for (int val : mostFreq) {
			result[i++] = val; 
		}
		return result;
    }
	
	/**
	 * return sum of subtree
	 * @param root
	 * @param sumFreq
	 * @param mostFreq
	 * @return
	 */
	private int helper(TreeNode root, Map<Integer, Integer> sumFreq, Set<Integer> mostFreq, int[] maxFreq) {
        if (root == null) return 0;
        int leftSum = helper(root.left, sumFreq, mostFreq, maxFreq);
        int rightSum = helper(root.right, sumFreq, mostFreq, maxFreq);
        int sum = leftSum + rightSum + root.val;
        int curFreq = 0;
        sumFreq.put(sum, (curFreq = sumFreq.getOrDefault(sum, 0) + 1));
        if (maxFreq[0] == curFreq) {
        	mostFreq.add(sum);
        }
        else if (maxFreq[0] < curFreq) {
        	mostFreq.clear();
        	mostFreq.add(sum);
        	maxFreq[0] = curFreq;
        }
        return sum;
    }
	
	public static void main(String[] args) {
		Prob508 prob = new Prob508();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(-5);
		int[] result = prob.findFrequentTreeSum(root);
		for(int i : result) System.out.print(i + ", ");
	}
}
