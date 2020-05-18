package comp.prep2019;
import java.util.*;
public class Prob1257 {
	public String findSmallestRegion(List<List<String>> regions, String region1, 
			String region2) {
		Map<String, String> map = new HashMap<>();
        for (List<String> region : regions) {
        	for (int i = 1; i < region.size(); i++) {
        		map.put(region.get(i), region.get(0));
        	}
        }
      //get set of region1 parents back to the root
        Set<String> reg1Parents = new HashSet<>();
        while (region1 != null) {
            reg1Parents.add(region1);
            region1 = map.get(region1);
        }

        String res = null;
        //now start collection region2 parents, checking every new parent with the region1 parents set
        while (region2 != null) {
            if (reg1Parents.contains(region2)) {
                res = region2;
                break;
            }
            region2 = map.get(region2);
        }
        return res;
	}
	
	public static void main(String[] args) {
		Prob1257 prob  = new Prob1257();
		System.out.println(
				prob.findSmallestRegion(
					Arrays.asList(
							Arrays.asList("Earth", "North America", "South America"),
							Arrays.asList("North America", "United States", "Canada"),
							Arrays.asList("United States", "New York", "Boston"),
							Arrays.asList("Canada", "Ontario", "Quebec"),
							Arrays.asList("South America", "Brazil")
					),
					"Canada",
					"Quebec"
				)
		);
	}
}
