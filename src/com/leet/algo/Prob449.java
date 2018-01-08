package com.leet.algo;

/**
 * Created by ayanc on 1/7/18.
 */
public class Prob449 {
  public String serialize(TreeNode root) {
    String result = "";
    if(root == null) return "null";
    result += root.val;
    result += "," + serialize(root.left);
    result += "," + serialize(root.right);
    return result;
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if(data.equals("null")) return null;
    String[] arr = data.split(",");
    Info info = deserialize(arr, 0);
    return info.node;
  }

  private Info deserialize(String[] arr, int start){
    Info info = new Info();
    if(arr[start].equals("null")) {
      info.index = start + 1;
      return info;
    }
    TreeNode root = new TreeNode(Integer.parseInt(arr[start]));
    Info leftInfo = deserialize(arr, start + 1);
    root.left = leftInfo.node;
    Info rightInfo = deserialize(arr, leftInfo.index);
    root.right = rightInfo.node;
    info.node = root;
    info.index = rightInfo.index;
    return info;
  }

  class Info {
    TreeNode node;
    int index;
  }
}
