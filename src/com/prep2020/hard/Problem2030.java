package com.prep2020.hard;

public class Problem2030 {
	public String smallestSubsequence(String s, int k, char letter, int repetition) {
        int sl= s.length();
        int letter_left=0;
        int letter_taken=0;
        for(int idx=0;idx<sl;idx++){
            if(s.charAt(idx)==letter) letter_left++;
        }
        //Stack<Character> st = new Stack<>();
        StringBuilder sb=new StringBuilder("z".repeat(k));
        int sbidx=-1;
        for(int idx=0;idx<sl;idx++){
            char c=s.charAt(idx);
            while(sbidx>=0 && sb.charAt(sbidx)>c && (sl-idx+sbidx+1>k)){
                if(sb.charAt(sbidx)==letter){
                    if(letter_left+letter_taken<=repetition) break;
                    letter_taken--;
                }
                sbidx--;
            }
            if(sbidx+1<k){
                if(c==letter){
                    sb.setCharAt(++sbidx,c);
                    letter_taken++;
                }
                else if(k-(sbidx+1)>repetition-letter_taken) {
                    //System.out.println(k);
                    sb.setCharAt(++sbidx,c);
                }
            }
            if(c==letter) letter_left--;
            //System.out.println("IDX = "+idx+" char = "+c+" letter_left = "+letter_left+" Taken = "+letter_taken );
            //System.out.println(sb.toString().substring(0,sbidx+1));
            //System.out.println(sbidx);
            
            //System.out.println("------------");
            
        }
    
        return sb.toString();
    }
}
