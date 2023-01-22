package com.prep2020.hard;
import java.util.*;
public class Problem1125 {
	/**
	 * O(2^n)
	 * @param req_skills
	 * @param people
	 * @return
	 */
	public int[] smallestSufficientTeam(String[] req_skills, 
			List<List<String>> people) {
		Map<String, Integer> skillMap = new HashMap<>();
		int n = req_skills.length;
		List<Integer>[] dp = new List[1 << req_skills.length];
		dp[0] = new ArrayList<>();
        for (int i = 0; i < req_skills.length; i++) {
        	skillMap.put(req_skills[i], i);
        }
        for (int i = 0; i < people.size(); i++) {
        	List<String> skills = people.get(i);
        	int skillBit = 0;
        	for (String skill : skills) {
        		skillBit |= (1 << skillMap.get(skill));
        	}
        	for (int j = 0; j < dp.length; j++) {
        		if (dp[j] == null) continue;
        		int newBit = 0;
        		if ((newBit = (j | skillBit)) == j) continue;
        		if (dp[newBit] == null || dp[newBit].size() > dp[j].size() + 1) {
        			dp[newBit] = new ArrayList<>(dp[j]);
        			dp[newBit].add(i);
        		}
        	}
        }
        List<Integer> team = dp[(1 << n) - 1];
        int[] result = new int[team.size()];
        for (int i = 0; i < team.size(); i++) {
        	result[i] = team.get(i);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1125 problem = new Problem1125();
		List<List<String>> people = new ArrayList<>();
		people.add(Arrays.asList("java"));
		people.add(Arrays.asList("nodejs"));
		people.add(Arrays.asList("nodejs","reactjs"));
		int[] team = problem.smallestSufficientTeam(new String[] {"java","nodejs","reactjs"}, people);
		System.out.println(team);
	}
}
