package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 3/17/18.
 */
public class Prob792 {
  public int numMatchingSubseq(String S, String[] words) {
    Tree tree = new Tree();
    for (int i = S.length() - 1; i > -1; i--) {
      char c = S.charAt(i);
      Tree newTree = new Tree();
      newTree.c = c;
      newTree.trees = tree.trees == null ? tree.trees : new ArrayList<>(tree.trees);
      if (tree.trees == null) tree.trees = new ArrayList<>();
      tree.trees.add(newTree);
    }
    int result = 0;
    for (int i = 0; i < words.length; i++) {
      String w = words[i];
      Tree node = tree;
      for (int j = 0; j < w.length(); j++) {
        char c = w.charAt(j);
        if (node.trees == null) break;
        boolean found = false;
        for (Tree sub : node.trees) {
          if (sub.c == c) {
            node = sub;
            found = true;
            break;
          }
        }
        if (!found) break;
        if (j == w.length() - 1) result++;
      }
    }
    return result;
  }
  class Tree {
    List<Tree> trees;
    char c;
  }

  public static void main(String[] args) {
    Prob792 prob792 = new Prob792();
    System.out.println(prob792.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
  }
}
