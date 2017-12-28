package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ayanc on 12/20/17.
 */
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

//  private List<List<Integer>> createPseudoOffer(List<Integer> price){
//    int numDifferentKind = price.size();
//    List<List<Integer>> result = new ArrayList<>();
//    for(int i = 0; i < price.size(); i++){
//      List<Integer> offer = new ArrayList<>();
//      for(int j = 0; j < numDifferentKind + 1; j++){
//        offer.add(0);
//      }
//      offer.set(i, 1);
//      offer.set(numDifferentKind, price.get(i));
//      result.add(offer);
//    }
//    return result;
//  }

  public static void main(String[] args){
    Prob638 prob638 = new Prob638();
    List<Integer> price = new ArrayList<>();
    price.add(2);
    price.add(5);

    List<List<Integer>> specials = new ArrayList<>();
    List<Integer> offer1 = new ArrayList<>();
    offer1.add(3);
    offer1.add(0);
    offer1.add(5);
    specials.add(offer1);

    List<Integer> offer2 = new ArrayList<>();
    offer2.add(1);
    offer2.add(2);
    offer2.add(10);
    specials.add(offer2);

    List<Integer> needs = new ArrayList<>();
    needs.add(3);
    needs.add(2);
    System.out.println(prob638.shoppingOffers(price, specials, needs));
  }


}
