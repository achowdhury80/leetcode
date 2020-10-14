package comp.prep2019.less1000;

public class Prob307 {
	private int[] arr, nums;
	public Prob307(int[] nums) {
		this.nums = new int[nums.length];
        arr = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
        	update(i, nums[i]);
        }
    }
    
    public void update(int i, int val) {
    	int cur = i + 1;
        int change = val - nums[i];
        nums[i] = val;
        while(cur < arr.length) {
        	arr[cur] += change;
        	cur = next(cur);
        }
    }
    
    public int sumRange(int i, int j) {
        return sum(j) - (i == 0 ? 0 : sum(i - 1));
    }
    
    private int sum(int i) {
    	int result = 0;
    	int cur = i + 1;
    	while(cur > 0) {
    		result += arr[cur];
    		cur = parent(cur);
    	}
    	return result;
    }
    
    private int parent(int cur) {
    	return cur - ((~cur + 1) & cur);
    }
    
    private int next(int cur) {
    	return cur + ((~cur + 1) & cur);
    }
    
    public static void main(String[] args) {
    	Prob307 prob = new Prob307(new int[] {1, 3, 5});
    	System.out.println(prob.sumRange(0, 2));
    }
}
