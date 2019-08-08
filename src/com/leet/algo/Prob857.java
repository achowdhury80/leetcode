package com.leet.algo;
import java.util.*;
public class Prob857 {
	public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        Worker[] workers = new Worker[wage.length];
        for (int i = 0; i < wage.length; i++) workers[i] = new Worker(wage[i], quality[i]);
        Arrays.sort(workers);
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        double result = 1e9;
        int sumQ = 0;
        for (int i = 0; i < workers.length; i++) {
        	sumQ += workers[i].quality;
        	if (pq.size() == K) sumQ -= pq.poll();
        	pq.offer(workers[i].quality);
        	if (pq.size() == K) result = Math.min(result, sumQ * workers[i].findRatio());
        }
        return result;
    }
	class Worker implements Comparable<Worker>{
		private int wage, quality;
		Worker(int wage, int quality) {
			this.wage = wage;
			this.quality = quality;
		}
		@Override
		public int compareTo(Worker w) {
			return findRatio().compareTo(w.findRatio());
		}
		
		public Double findRatio() {
			return (wage + 0.0) / quality;
		}
		
	}
	
	public static void main(String[] args) {
		Prob857 prob = new Prob857();
		System.out.println(prob.mincostToHireWorkers(new int[] {10, 20, 5}, new int[] {70, 50, 30}, 2));
	}
}
