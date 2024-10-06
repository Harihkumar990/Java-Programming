import java.util.HashMap;
import java.util.HashSet;

public class TreeNode {
 static class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val  =val;
        left = null;
        right = null;
    }
 }   
    public static Node contructTree(int[][] descriptions){
        HashSet<Integer> childrenSet = new HashSet<>();
        HashMap<Integer,int[]> childrenmap = new HashMap<>();
        for(int[] des : descriptions){
            int parent = des[0];
            int children = des[1];
            boolean isleft = des[2] == 1;
            childrenmap.putIfAbsent(parent, new int[]{-1,-1});
            childrenSet.add(children);
            if(isleft){
                childrenmap.get(parent)[0] = children;
            }else{
                childrenmap.get(parent)[1] = children;
            }

        }
        int headvalue = 0;
        for(int n : childrenmap.keySet() ){
            if(!childrenSet.contains(n)){
                headvalue = n;
            }
        }
        return buildtree(headvalue,childrenmap);
    }
    private static Node buildtree(int headvalue, HashMap<Integer,int[]> childrens){
        Node headNode = new Node(headvalue);
        if(childrens.containsKey(headvalue)){
            int[] childrenvalue = childrens.get(headvalue);
            if(childrenvalue[0] != -1){
                headNode.left = buildtree(childrenvalue[0], childrens);
            }else if(childrenvalue[1] != -1){
                headNode.right = buildtree(childrenvalue[1], childrens);
            }
        }
        return headNode;
    }
    public static Node findStartRoot(int value, Node root) {
        if(value > root.val){
            root.right =  findStartRoot(value, root.right);
        }else if(value < root.val){
            root.right = findStartRoot(value, root.left);
        }
        return root;
    }
    public static void findRoute(Node root, int startValue, int destValue) {
        root = findStartRoot(startValue,root);

    }
    public static Node lowestcommonAncestor(Node root, int p, int q){
        if(root == null){
            return null;
        }
        if(root.val == p || root.val == q) return root;
        Node leftN = lowestcommonAncestor(root.left, p, q);
        Node rightN = lowestcommonAncestor(root.right, p, q);

        if(leftN != null && rightN != null ) return root;
        else if(leftN != null) return leftN;
        return rightN;
    }
   
    public static Node builtTree(int preorder[], int inorder[], int left, int right, int[] idx) {
            if(left > right) return null;

            int i = 0;
            for(i=left; i<=right; i++ ) {
                if(inorder[i] == preorder[idx[0]]) {
                    break;
                }
            }
            
            Node root = new Node(preorder[idx[0]]);
            idx[0]++;
            root.left = builtTree(preorder, inorder, left, i-1, idx);
            root.right = builtTree(preorder, inorder, i+1, right, idx);
            return root;



    }
 public static void main(String[] args) {
    int[] preorder = {3,9,20,15,7};
    int[] inorder = {9,3,15,20,7};
    int[] idx = {0};
    Node root = builtTree(preorder, inorder, 0, inorder.length-1, idx);
    System.out.println(root.right.val);
    

 }
}
