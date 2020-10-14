package comp.prep2019.less2000;

public class Prob1423 {
	public int maxScore(int[] cardPoints, int k) {
		int remaining = cardPoints.length - k;
		int sum = 0, remSum = 0;
        int minRemSum = Integer.MAX_VALUE;
        for (int i = 0; i < cardPoints.length; i++) {
        	sum += cardPoints[i];
        	remSum += cardPoints[i];;
        	if (i < remaining - 1) continue;
        	if (i >= remaining) remSum -= cardPoints[i - remaining];
        	minRemSum = Math.min(minRemSum, remSum);
        }
        return sum - (remaining == 0 ? 0 : minRemSum);
    }
	
	public static void main(String[] args) {
		Prob1423 prob = new Prob1423();
		System.out.println(prob.maxScore(new int[] {1,2,3,4,5,6,1}, 3));
	}
}
