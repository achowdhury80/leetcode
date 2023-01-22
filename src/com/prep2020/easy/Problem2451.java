package com.prep2020.easy;
import java.util.*;
public class Problem2451 {
	public String oddString(String[] words) {
        HashMap<String,List<String>> hm1 =new HashMap<String,List<String>>();
        for(String s1:words)
        {
            StringBuilder sb1 =new StringBuilder();
            for(int i=0;i<s1.length()-1;i++)
            {
                int res=(s1.charAt(i+1)-'a')-(s1.charAt(i)-'a');
                sb1.append(res+" ");                    
            }
            sb1.deleteCharAt(sb1.length()-1);
            if(hm1.containsKey(sb1.toString())==false)
            {
                hm1.put(sb1.toString(),new ArrayList<String>());
            }
            hm1.get(sb1.toString()).add(s1);            
        }
        for(Map.Entry<String,List<String>> x1:hm1.entrySet())
        {
            List<String> l1=x1.getValue(); 
            if(l1.size()==1)
            {
                return l1.get(0);
            }
        }
                        
        return "";
    }   
}
