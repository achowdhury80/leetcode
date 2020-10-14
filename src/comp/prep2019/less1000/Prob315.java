package comp.prep2019.less1000;
import java.util.*;
public class Prob315 {
	/*public List<Integer> countSmaller(int[] nums) {
        int[][] arr = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) arr[i] = new int[] {i, nums[i]};
        Arrays.sort(arr, (x, y) -> x[1] == y[1] ? x[0] - y[0] : x[1] - y[1]);
        TreeSet<Integer> usedIndex = new TreeSet<>();
        Integer[] result = new Integer[nums.length];
        for (int i = arr.length - 1; i > -1; i--) {
        	int notSmallerValueAfter = usedIndex.tailSet(arr[i][0]).size();
        	result[arr[i][0]] = nums.length - 1 - arr[i][0] - notSmallerValueAfter;
        	usedIndex.add(arr[i][0]);
        }
        return Arrays.asList(result);
    }*/
	
	public List<Integer> countSmaller1(int[] nums) {
		List<Integer> res = new ArrayList<>();
	    int count = 0;
	    for(int i=0;i<nums.length;i++){
	        for(int j=i+1;j<nums.length;j++){
	            if(nums[i] > nums[j]){
	                count += 1;
	            }
	        }
	        res.add(count);
	        count = 0 ;
	    }
	    return res;
	}
	
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> res = new ArrayList<>();
		List<Integer> sortedData = new ArrayList<>();
	    for (int i = nums.length - 1; i > -1; i--) {
	    	int index = Collections.binarySearch(sortedData, nums[i]);
	    	if (index > -1) {
	    		int j = index - 1;
	    		while(j > -1 && sortedData.get(j) == nums[i]) j--;
	    		sortedData.add(index, nums[i]);
	    		res.add(0, j + 1);
	    	} else {
	    		index = -(index + 1);
	    		res.add(0, index);
	    		sortedData.add(index, nums[i]);
	    	}
	    }
	    return res;
	}
	
	public static void main(String[] args) {
		Prob315 prob = new Prob315();
		System.out.println(prob.countSmaller(new int[] {5, 2, 6, 1}));
	}
}
