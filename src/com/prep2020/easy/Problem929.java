package com.prep2020.easy;
import java.util.*;
public class Problem929 {
	public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
        	int atIndex = email.indexOf('@');
        	String localName = email.substring(0, atIndex);
        	int idx;
        	if ((idx = localName.indexOf('+')) > -1) 
        		localName = localName.substring(0, idx);
        	String s = "";
        	for (char c : localName.toCharArray()) {
        		if (c != '.') s += c;
        	}
        	set.add(s + email.substring(atIndex));
        }
        return set.size();
    }
	
	public static void main(String[] args) {
		Problem929 problem = new Problem929();
		System.out.println(problem.numUniqueEmails(new String[] {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
	}
}
