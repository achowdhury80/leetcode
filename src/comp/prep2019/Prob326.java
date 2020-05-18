package comp.prep2019;

public class Prob326 {
	/**
	 * O(1)
	 * find max of 3 power which is smaller than integer max value
	 * get the max value which is power of 3
	 * check if that value is divisible by n
	 * @param n
	 * @return
	 */
	public boolean isPowerOfThree(int n) {
        int max = (int)Math.pow(3, (int)(Math.floor(Math.log(Integer.MAX_VALUE)/Math.log(3))));
        return n > 0 && max % n == 0;
    }
	
	public static void main(String[] args) {
		Prob326 prob = new Prob326();
		System.out.println(prob.isPowerOfThree(27));
	}
}
