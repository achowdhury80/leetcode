package com.leet.algo;

/**
 * Created by ayanc on 10/19/17.
 */
public class Prob459 {
  public boolean repeatedSubstringPattern(String s){
    if(s == null || s.length() < 2) return false;
    int[] kmpTable = populateKmpTable(s);
    return kmpTable[s.length() - 1] > 0 && (s.length() % (s.length() - kmpTable[s.length() - 1])) == 0;
  }

  private int[] populateKmpTable(String s){
    int[] kmpTable = new int[s.length()];
    int j = 0;
    int i = 1;
    while(i < s.length()){
      if(s.charAt(i) == s.charAt(j)){
        kmpTable[i] = j + 1;
        j++;
      }else{
        if(j == 0){
          kmpTable[i] = 0;
        } else {
          while(true){
            j = kmpTable[j - 1];
            if(s.charAt(i) == s.charAt(j)){
              kmpTable[i] = j + 1;
              j++;
              break;
            }
            if(j == 0){
              kmpTable[i] = 0;
              break;
            }
          }
        }
      }
      i++;
    }
    return kmpTable;
  }

  public static void main(String[] args){
    Prob459 prob459 = new Prob459();
    int[] kmpTable = prob459.populateKmpTable("abcabcabc");
    for (int i : kmpTable){
      System.out.println(i + ", ");
    }
  }
}
