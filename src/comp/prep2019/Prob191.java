package comp.prep2019;

public class Prob191 {
	public int hammingWeight(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
        	if ((n & 1) == 1) result++;
        	n >>= 1;
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob191 prob = new Prob191();
		System.out.println(prob.hammingWeight(5));
	}
}
