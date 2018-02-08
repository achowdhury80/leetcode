package com.leet.algo;

/**
 * Created by ayanc on 2/4/18.
 */
public class Prob649 {
  public String predictPartyVictory(String senate) {
    if (senate.length() == 1) {
      if (senate.charAt(0) == 'R') return "Radiant";
      return "Dire";
    }
    char[] arr = senate.toCharArray();
    while (true) {
      for (int j = 0; j < senate.length(); j++) {
        if (arr[j] != 'N') {
          int index = findNextOpposite(j, arr);
          if (index == -1) {
            if (arr[j] == 'R') return "Radiant";
            return "Dire";
          } else {
            arr[index] = 'N';
          }
        }
      }
    }
  }

  private int findNextOpposite(int currentIndex, char[] arr) {
    char c = arr[currentIndex];
    for (int i = (currentIndex + 1) % arr.length; i != currentIndex; i = (i + 1) % arr.length) {
      if (arr[i] != c && arr[i] != 'N') return i;
    }
    return -1;
  }

  public static void main(String[] args) {
    Prob649 prob649 = new Prob649();
    System.out.println(prob649.predictPartyVictory("RD"));
    System.out.println(prob649.predictPartyVictory("RDD"));
    System.out.println(prob649.predictPartyVictory("DDRRR"));
  }
}
