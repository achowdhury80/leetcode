package comp.prep2019.less2000;

public class Prob1052 {
	public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int statisfiedWithoutMagic = 0;
        for (int i = 0; i < grumpy.length; i++) {
        	if (grumpy[i] == 0) statisfiedWithoutMagic += customers[i];
        }
        int canSave = 0;
        for (int i = 0; i < X; i++) {
        	if (grumpy[i] == 1) canSave += customers[i];
        }
        int maxSave = canSave;
        for (int i = X; i < grumpy.length; i++) {
        	if (grumpy[i - X] == 1) canSave -= customers[i - X];
        	if (grumpy[i] == 1) {
        		canSave += customers[i];
        		maxSave = Math.max(maxSave, canSave);
        	}
        }
        return statisfiedWithoutMagic + maxSave;
    }
	
	public static void main(String[] args) {
		Prob1052 prob = new Prob1052();
		System.out.println(prob.maxSatisfied(new int[] {1,0,1,2,1,1,7,5}, 
				new int[] {0,1,0,1,0,1,0,1}, 3));
	}
}
