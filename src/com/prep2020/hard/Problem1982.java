package com.prep2020.hard;
import java.util.*;
public class Problem1982 {
	public int[] recoverArray(int n, int[] sums) {
        List<Integer> sumList = new ArrayList<>();
        for (Integer sum : sums) sumList.add(sum);
        Collections.sort(sumList, (a,b)->Integer.compare(b,a));
        int[] res = new int[n];
        int i=0;
        
        while(sumList.size() > 2){
            List<Integer> array1 = new ArrayList<>(), array2 = new ArrayList<>();
            int num = sumList.get(0) - sumList.get(1);
            Map<Integer, Integer> map = getCountMap(sumList);
            
            for (int elem : sumList) {
                if(map.containsKey(elem)) {
                    array2.add(elem);
                    array1.add(elem - num);
                    remove(map, elem);
                    remove(map, elem - num);
                }
            }
            
            int index = array2.indexOf(num);
            if (index != -1){
                 if (array1.get(index) == 0){
                     res[i++] = num;
                     sumList = array1;
                     continue;
                 }
            }
            res[i++] = -num;
            sumList = array2;    
        }
        
        if (sumList.get(0) == 0) {
            res[i++] = sumList.get(1);
        }
        else {
            res[i++] = sumList.get(0);
        }
        
        return res;
    }
        // This function simply descrement the freq of element in map
    private void remove(Map<Integer, Integer> map, int element){
         if (map.containsKey(element)){
             if (map.get(element) > 1){
                map.put(element, map.get(element)-1);
             } else {
             map.remove(element);
           }
         }
     }
    
    // This function get the freq of sum in map and return it 
     private Map<Integer, Integer> getCountMap(List<Integer> list){
            Map<Integer, Integer> map = new HashMap<>();
            for (Integer num: list){
                map.put(num, map.getOrDefault(num, 0)+1);
            }
            return map;
        }
}
