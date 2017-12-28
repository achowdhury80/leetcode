package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by ayanc on 12/8/17.
 */
public class Prob734 {
  public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
    if(words1 == null || words2 == null || words1.length != words2.length) return false;
    if(words1.length == 0 && words1.length == words2.length) return true;
    Map<String, List<String>> wordMap = new HashMap<>();
    if(pairs != null) Arrays.stream(pairs).forEach(x -> {
      if (!wordMap.containsKey(x[0])) {
        wordMap.put(x[0], new ArrayList<>());
      }
      if (!wordMap.containsKey(x[1])) {
        wordMap.put(x[1], new ArrayList<>());
      }
      wordMap.get(x[0]).add(x[1]);
      wordMap.get(x[1]).add(x[0]);
    });
    for(int i = 0; i < words1.length; i++){

      if(!words1[i].equals(words2[i]) && !mapContainsSimilarity(wordMap, words1[i], words2[i])) return false;

    }
    return true;
  }

  private boolean mapContainsSimilarity(Map<String, List<String>> wordMap, String word1, String word2){
    if(wordMap.get(word1) != null && wordMap.get(word1).contains(word2)) return true;
    if(wordMap.get(word2) != null && wordMap.get(word2).contains(word1)) return true;
    return false;
  }

  public static void main(String[] args){
    Prob734 prob734 = new Prob734();
    System.out.println(prob734.areSentencesSimilar(new String[]{"this","summer","thomas","get","actually","actually","rich","and","possess","the","actually","great","and","fine","vehicle","every","morning","he","drives","one","nice","car","around","one","great","city","to","have","single","super","excellent","super","as","his","brunch","but","he","only","eat","single","few","fine","food","as","some","fruits","he","wants","to","eat","an","unique","and","actually","healthy","life"},
        new String[]{"this","summer","thomas","get","very","very","rich","and","possess","the","very","fine","and","well","car","every","morning","he","drives","a","fine","car","around","unique","great","city","to","take","any","really","wonderful","fruits","as","his","breakfast","but","he","only","drink","an","few","excellent","breakfast","as","a","super","he","wants","to","drink","the","some","and","extremely","healthy","life"},
        new String[][]{{"good","nice"},{"good","excellent"},{"good","well"},{"good","great"},{"fine","nice"},{"fine","excellent"},{"fine","well"},{"fine","great"},{"wonderful","nice"},{"wonderful","excellent"},{"wonderful","well"},{"wonderful","great"},{"extraordinary","nice"},{"extraordinary","excellent"},{"extraordinary","well"},{"extraordinary","great"},{"one","a"},{"one","an"},{"one","unique"},{"one","any"},{"single","a"},{"single","an"},{"single","unique"},{"single","any"},{"the","a"},{"the","an"},{"the","unique"},{"the","any"},{"some","a"},{"some","an"},{"some","unique"},{"some","any"},{"car","vehicle"},{"car","automobile"},{"car","truck"},{"auto","vehicle"},{"auto","automobile"},{"auto","truck"},{"wagon","vehicle"},{"wagon","automobile"},{"wagon","truck"},{"have","take"},{"have","drink"},{"eat","take"},{"eat","drink"},{"entertain","take"},{"entertain","drink"},{"meal","lunch"},{"meal","dinner"},{"meal","breakfast"},{"meal","fruits"},{"super","lunch"},{"super","dinner"},{"super","breakfast"},{"super","fruits"},{"food","lunch"},{"food","dinner"},{"food","breakfast"},{"food","fruits"},{"brunch","lunch"},{"brunch","dinner"},{"brunch","breakfast"},{"brunch","fruits"},{"own","have"},{"own","possess"},{"keep","have"},{"keep","possess"},{"very","super"},{"very","actually"},{"really","super"},{"really","actually"},{"extremely","super"},{"extremely","actually"}}));
  }

}
