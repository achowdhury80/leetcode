package com.prep2020.easy;
import java.util.*;
public class Problem2062 {
	Map<Character,Integer>map;
    int substrings(String word,int size){
        int count=0;
        for(int i=0,j=0;i<word.length();i++){
           char c=word.charAt(i);
            if(c!='a'&&c!='e'&&c!='i'&&c!='o'&&c!='u'){
                map.clear();
                j=i+1;
                continue;
            }
            map.put(c,map.getOrDefault(c,0)+1);
            while(map.size()>size){
                    char jc=word.charAt(j++);
                    int f=map.get(jc);
                    if(f==1)map.remove(jc);
                    else map.put(jc,f-1);
            }
            count+=(i-j+1);
        }
        map.clear();
        return count;
    }
    public int countVowelSubstrings(String word) {
        //no of substring contains at-most 5 vowel - substring contains at most 4 vowel
        map=new HashMap<>();
        return substrings(word,5)-substrings(word,4);
    }
	
	public static void main(String[] args) {
		Problem2062 problem = new Problem2062();
		System.out.println(problem.countVowelSubstrings("cuaieuouac"));
	}
}
