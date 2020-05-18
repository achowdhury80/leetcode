package comp.prep2019;

public class Prob1184 {
	
	 public int distanceBetweenBusStops(int[] distance, int start, int destination) {
		    int sum = 0;
		    int[] arr = new int[2];
		    int idx = 0;
		    for (int i = 0; i < distance.length; i++) {
		    	if (i == start || i == destination) arr[idx++] = sum;
		    	sum += distance[i];
		    }
		    int dist = arr[1] - arr[0];
		    return Math.min(dist, sum - dist);
		 }
	 
	 public static void main(String[] args) {
		 Prob1184 prob = new Prob1184();
		 System.out.println(prob.distanceBetweenBusStops(new int[] {1, 2, 3, 4}, 0, 2));
		 System.out.println(prob.distanceBetweenBusStops(new int[] {1, 2, 3, 4}, 0, 2));
	 }
}
