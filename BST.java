import java.util.*;
public class BST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public static int goodleaf(TreeNode root, int distance, ArrayList<Integer> array) {
      if(root == null) {
        return 0;
      }
      if(root.right == null && root.left == null) {
        return 0;
      }
      if(root.right == null) {
        goodleaf(root.left, distance, array);
      }
      if(root.left == null) {
        goodleaf(root.right, distance, array);
      }
      int leftDist = goodleaf(root.left, distance, array);
     
      int rightDist = goodleaf(root.right, distance, array);
      array.add(leftDist + rightDist + 1);
      goodleaf(root.left, distance, array);
      goodleaf(root.right, distance, array);
      return 1;

    }
    public static void BFS(TreeNode root) {
      if(root == null) return;
      
      Queue<TreeNode> que = new LinkedList<>();
      que.add(root);
      que.add(null);
      List<Integer> helper = new ArrayList<>();
      List<List<Integer>> ans = new ArrayList<>();
      while(!que.isEmpty()) {
          TreeNode take = que.remove();
          
          if(take == null) {
            ans.add(new ArrayList<>(helper));
            if(!que.isEmpty()) que.add(null);
            helper.removeAll(helper);
          
            continue;
          }
          helper.add(take.val);
          if(take.left != null) {
            que.add(take.left);
          }
          if(take.right != null) {
            que.add(take.right);
          }
          
          
        }

        System.out.println(ans.toString());

    }
    public static boolean isBST(TreeNode root,long minval,long maxval) {
      if(root == null) return true;
      if(root.val >= maxval || root.val <= minval) return false;
      return isBST(root.left, minval, root.val) && isBST(root.right, root.val, maxval);
    }
    public static boolean validBST(TreeNode root) {
      if(root == null) return false;
      return true;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(5);
        root.right = new TreeNode(5);
        
        
        /* ArrayList<Integer> newArray = new  ArrayList<>();
        goodleaf(root, 3, newArray);
        System.out.println(newArray.toString()); */
        //BFS(root);
        System.out.println(validBST(root));

        
    }
}