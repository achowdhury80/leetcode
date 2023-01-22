package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2166 {
	int size;
    Set<Integer> set=new HashSet();
    boolean isOne=true;
    public Problem2166(int size) {
        this.size=size;
    }
    
    public void fix(int idx) {
        if(isOne){
            set.add(idx);
        }else{
            set.remove(idx);
        }
    }
    
    public void unfix(int idx) {
        if(!isOne){
            set.add(idx);
        }else{
            set.remove(idx);
        }
    }
    
    public void flip() {
        isOne=!isOne;
    }
    
    public boolean all() {
        return count()==size;
    }
    
    public boolean one() {
        return count()>=1;
    }
    
    public int count() {
        if(isOne){
            return set.size();
        }else{
            return size-set.size();
        }
    }
    
    public String toString() {
        char v[]=new char[size];        
        if(isOne){
            Arrays.fill(v,'0');
            for(int n:set){
                v[n]='1';
            }
        }else{
            Arrays.fill(v,'1');
            for(int n:set){
                v[n]='0';
            }
        }
        return new String(v);
    }
}
