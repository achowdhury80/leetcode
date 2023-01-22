package com.prep2020.medium;

public class Problem1554 {
	public boolean differByOne(String[] dict) {
        TrieNode root = new TrieNode();
        
        for(String word : dict){
            insert(root, word);
        }
        
        int i, n = dict[0].length();
        char ch, original;
        
        for(String word : dict){    // for each string
            char[] letters = word.toCharArray();
            for(i = 0; i < n; i++){
                original = letters[i];
				
				// try to replace the ith character with all possible 25 options 
				// (all characters other than existing one)
                for(ch = 'a'; ch <= 'z'; ch++){   
                    if(original != ch){
                        letters[i] = ch;
                        if(search(root, letters, n)){
                            return true;
                        }
                    }
                }
                
                letters[i] = original;   // reset back to original character and try next character of this word
            }
        }
        
        return false;
    }
    
    private boolean search(TrieNode root, char[] letters, int n){
        TrieNode current = root;
        for(int i = 0; i < n; i++){
            current = current.get(letters[i] - 'a');
            if(current == null){
                return false;
            }
        }
        
        return true;
    }
    
    private void insert(TrieNode root, String s){
        int i, n = s.length();
        TrieNode current = root;
        
        for(i = 0; i < n; i++){
            current = current.createAndGet(s.charAt(i) - 'a');
        }
    }
    
    class TrieNode{
        private TrieNode[] children;
        
        public TrieNode(){
            this.children = new TrieNode[26];
        }
        
        public TrieNode get(int index){
            return this.children[index];
        }
        
        public TrieNode createAndGet(int index){
            if(this.children[index] == null){
                this.children[index] = new TrieNode();
            }
            
            return this.children[index];
        }
    }
}
