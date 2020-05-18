package comp.prep2019;

public class Prob393 {
	public boolean validUtf8(int[] data) {
        int noOfBytesTFollow = 0;
        for (int d : data) {
        	noOfBytesTFollow = findNumberOfBytesToFollow(d, noOfBytesTFollow);
        	if (noOfBytesTFollow == - 1) return false;
        }
        return noOfBytesTFollow == 0;
    }
	
	private int findNumberOfBytesToFollow(int data, int noOfBytesTFollow) {
		if (noOfBytesTFollow > 0 && noOfBytesTFollow < 4) {
			if ((data >> 6) != 2) return -1;
			else return noOfBytesTFollow - 1;
		}
		if ((data >> 7) == 0) return 0;
		if ((data >> 3) == 30) return 3;
		if ((data >> 4) == 14) return 2;
		if ((data >> 5) == 6) return 1;
		return -1;
	}
	
	public static void main(String[] args) {
		Prob393 prob = new Prob393();
		System.out.println(prob.validUtf8(new int[] {197, 130, 1}));
		System.out.println(prob.validUtf8(new int[] {237}));
	}
}
