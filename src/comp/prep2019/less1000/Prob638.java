package comp.prep2019.less1000;
import java.util.*;
public class Prob638 {
	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
	    if(price == null || price.size() == 0 || needs == null || needs.size() == 0) return 0;

	    int dpSize = 0;
	    dpSize += Math.pow(7, needs.size());
	    int[] dp = new int[dpSize];
	    dp[0] = 0;
	    for(int i = 1; i < dp.length; i++){
	      dp[i] = -1;
	    }
	    return findPrice(dp, price, special, needs);
	  }

	  private int findPrice(int[] dp, List<Integer> price, List<List<Integer>> specials, List<Integer> needs){
	    int elementIndex = retrievelementIndex(needs);
	    if(elementIndex == 0) return 0;
	    if(dp[elementIndex] != -1) return dp[elementIndex];
	    int result = Integer.MAX_VALUE;
	    for(List<Integer> offer : specials){
	      result = Math.min(result, findPriceWithOffer(dp, price, specials, needs, offer));
	    }

	    // no special
	    int val = 0;
	    for(int i = 0; i < needs.size(); i++){
	      val += needs.get(i) * price.get(i);
	    }
	    dp[elementIndex] = Math.min(result, val);
	    return dp[elementIndex];
	  }

	  private int findPriceWithOffer(int[] dp, List<Integer> price, List<List<Integer>> specials, List<Integer> needs, List<Integer> offer){
	    int elementIndex = retrievelementIndex(needs);
	    if(elementIndex == 0) return 0;
	    if(dp[elementIndex] != -1) return dp[elementIndex];
	    List<Integer> lastOptimalNeeds = new ArrayList<>();
	    for(int i = 0; i < offer.size() - 1; i++){
	      if(needs.get(i) < offer.get(i)) return Integer.MAX_VALUE;
	      lastOptimalNeeds.add(needs.get(i) - offer.get(i));
	    }
	    return findPrice(dp, price, specials, lastOptimalNeeds) + offer.get(offer.size() - 1);
	  }

	  private int retrievelementIndex(List<Integer> needs){
	    int result = 0;
	    for(int i = 0; i < needs.size(); i++){
	      result += needs.get(i) * Math.pow(7, i);
	    }
	    return result;
	  }
	
	public static void main(String[] args) {
		Prob638 prob = new Prob638();
		List<List<Integer>> specials = new ArrayList<>();
		specials.add(Arrays.asList(3,0,5));
		specials.add(Arrays.asList(1,2,10));
		System.out.println(prob.shoppingOffers(Arrays.asList(2, 5),
				specials, Arrays.asList(3, 2)));
	}
}
