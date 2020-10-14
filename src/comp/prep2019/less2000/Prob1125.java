package comp.prep2019.less2000;
import java.util.*;
public class Prob1125 {
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
}
