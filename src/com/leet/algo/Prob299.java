package com.leet.algo;

/**
 * Created by ayanc on 1/21/18.
 */
public class Prob299 {
  public String getHint(String secret, String guess) {
    String result = "";
    if(secret == null || secret.length() < 1 || guess == null || guess.length() < 1) return result;
    int[] secretMap = new int[10];
    int[] guessMap = new int[10];
    for(int i = 0; i < secret.length(); i++) secretMap[secret.charAt(i) - '0']++;
    int bulls = 0;
    for(int i = 0; i < guess.length(); i++) {
      char c = guess.charAt(i);
      if(c == secret.charAt(i)) {
        bulls++;
        secretMap[c - '0']--;
      }
      else guessMap[c - '0']++;
    }
    int cows = 0;
    for(int i = 0; i < 10; i++){
      cows += Math.min(secretMap[i], guessMap[i]);
    }
    return bulls + "A" + cows + "B";

  }

  public static void main(String[] args){
    Prob299 prob299 = new Prob299();
    System.out.println(prob299.getHint("1807", "7810"));
    System.out.println(prob299.getHint("1123", "0111"));

  }
}
