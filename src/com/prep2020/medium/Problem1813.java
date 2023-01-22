package com.prep2020.medium;

public class Problem1813 {
	public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.length() == sentence2.length()) return sentence1.equals(sentence2);
        if (sentence2.length() > sentence1.length()) return areSentencesSimilar(sentence2, sentence1);
        String[] arr1 = sentence1.split(" "), arr2 = sentence2.split(" ");
        int i = 0, j = 0, n1 = arr1.length, n2 = arr2.length;
        while (i < n2) {
        	if (arr1[i].equals(arr2[i])) i++;
        	else break;
        }
        if (i == n2) return true;
        i--;
        while (j < n2) {
        	if (arr1[n1 - j - 1].equals(arr2[n2 - j - 1])) j++;
        	else break;
        }
        if (j == n2) return true;
        j--;
        return i + j + 2 == n2;
    }
	
	public static void main(String[] args) {
		Problem1813 problem = new Problem1813();
		System.out.println(problem.areSentencesSimilar("My name is Haley", "My Haley"));
	}
}
