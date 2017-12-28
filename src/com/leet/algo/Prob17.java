package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ayanc on 11/3/17.
 */
public class Prob17 {
  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    if(digits == null || digits.length() == 0) return result;
    List<String> lettersFrom1stNo = findLetters(digits.charAt(0) - '0');
    if(digits.length() == 1) return lettersFrom1stNo;
    List<String> lettersFromLaterPart = letterCombinations(digits.substring(1));
    for(String s1 : lettersFrom1stNo){
      for(String s2 : lettersFromLaterPart){
        result.add(s1 + s2);
      }
    }
    return result;
  }

  private List<String> findLetters(int digit){
    switch (digit){
      case 2: return Arrays.asList(new String[]{"a","b","c"});
      case 3: return Arrays.asList(new String[]{"d","e","f"});
      case 4: return Arrays.asList(new String[]{"g","h","i"});
      case 5: return Arrays.asList(new String[]{"j","k","l"});
      case 6: return Arrays.asList(new String[]{"m","n","0"});
      case 7: return Arrays.asList(new String[]{"p","q","r","s"});
      case 8: return Arrays.asList(new String[]{"t","u","v"});
      case 9: return Arrays.asList(new String[]{"w","x","y","z"});
      default: return null;
    }
  }

  public static void main(String[] args){
    Prob17 prob17 = new Prob17();
    System.out.println(prob17.letterCombinations("23"));
  }
}
