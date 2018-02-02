package com.leet.algo;

/**
 * Created by ayanc on 1/30/18.
 */
public class Prob765 {
  public int minSwapsCouples(int[] row) {
    int n = row.length;
    int[] position = new int[n];
    for (int i = 0; i < n; i++) position[row[i]] = i;
    int count = 0;
    for(int i = 0; i < n; i += 2){
      int spouse = row[i] % 2 == 0 ? row[i] + 1 : row[i] - 1;
      if(row[i + 1] != spouse){
        swap(row, position, i + 1, position[spouse]);
        count++;
      }
    }
    return count;
  }

  private void swap(int[] row, int[] position, int i, int j){
    int temp = row[i];
    row[i] = row[j];
    row[j] = temp;
    position[row[i]] = i;
    position[row[j]] = j;
  }

  public static void main(String[] args){
    Prob765 prob765 = new Prob765();
    System.out.println(prob765.minSwapsCouples(new int[]{0, 2, 1, 3}));
    System.out.println(prob765.minSwapsCouples(new int[]{3, 2, 0, 1}));
  }
}
