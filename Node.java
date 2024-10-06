import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
public class Node {
   
    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
            next = null;
        }    
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }
    public static ListNode deleteUsingArray(ListNode head, int[] nums) {
        if(head == null) {
            return head;
        }
        if(nums.length == 0) {
            return head;
        }
     
        Set<Integer> hash = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            hash.add(nums[i]);
        }
       
        ListNode ansNode = new ListNode(-1);
        ListNode ansCurrNode = ansNode;
        while(head != null) {
            if(!hash.contains(head.val)) {
                ansCurrNode.next = head;
                ansCurrNode = ansCurrNode.next;
                
            }
            head = head.next;
        } 
        
        return ansNode.next;
    }
    public static void printList(ListNode head) {
        if(head == null) {
            System.out.print("empty ");
        }
        System.out.println();
        while(head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }

    }
    public static boolean[] ans; 
    public static void linkListInBinary(TreeNode root, ListNode head) {
        if(head == null  || ans[0] == true) {
            ans[0] = true;
            return;
        }
        if(root == null ) {
            return;
        }
        if(root.val == head.val) {
            head = head.next;
        }
        linkListInBinary(root.left, head);
        
        linkListInBinary(root.right, head);

    }
    public static void splitLinkList(ListNode head, int k) {
        if(head == null) {
            return;
        }   
        int size = 0;
        ListNode currNode = head;
        while(currNode != null) {
            size++;
            currNode = currNode.next;
        }
        int rem = size % k;
        int part = size / k;
        int idx = 0;
        ListNode[] ans = new ListNode[k];
        while( head != null) {
            ListNode prev = null;
            ListNode step = head;
            int num = part;
            while( step != null &&  num != 0) {
                prev = step;
                step = step.next;
                num--;
            }
            if(step != null && rem != 0) {
                prev = step;
                step = step.next;
                rem--;
            }
           
            prev.next = null;
            ans[idx] = head;
            head = step;
            idx++;

        }
        for(int i=0; i<ans.length; i++) {
            printList(ans[i]);
        }
    }
    public static void matrixWithListNode(ListNode head, int m, int n) {
        ListNode currNode = head;
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = m-1;
        int colEnd = n-1;
        int[][] matrix = new int[m][n];
        while(rowStart <= rowEnd && colStart <= colEnd ) {
            for(int j=colStart; j<=colEnd; j++) {
                if(currNode != null) {
                    matrix[rowStart][j] = currNode.val;
                    currNode = currNode.next;
                }else {
                    matrix[rowStart][j] = -1;
                }
               
            }
            rowStart++;
            for(int i=rowStart; i<=rowEnd; i++) {
                if(currNode != null) {
                    matrix[i][colEnd] = currNode.val;
                    currNode = currNode.next;
                }else {
                    matrix[i][colEnd] = -1;
                }
                
               
            }
            colEnd--;
            if(rowStart <= rowEnd) {
                for(int j=colEnd; j>=colStart; j--) {
                    if(currNode != null) {
                        matrix[rowEnd][j] = currNode.val;
                        currNode = currNode.next;
                    }else {
                        matrix[rowEnd][j] = -1;
                    }
                  
                }
                
                
            }
            rowEnd--;
            if(colStart <= colEnd) {
                for(int i=rowEnd; i>=rowStart; i--) {
                    if(currNode != null) {
                        matrix[i][colStart] = currNode.val; 
                        currNode = currNode.next;
                    }else {
                        matrix[i][colStart] = -1;
                    }
                    
                }
                
              
            }
            colStart++;
        }
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int gcd(int num1, int num2) {
        if(num1 == num2) return num1;
        int x = num1 > num2 ? num1 : num2;
        int y = num1 > num2 ? num2  : num1;
        int gcd = 1;
        while(y != 0 ) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        gcd = x;
        return gcd;
    }
    public static void gcdWithLinkList(ListNode head) {
        if(head == null) {
            return;
        }
        if(head.next == null) {
            return;
        }
        ListNode prNode = head;
        ListNode currNode = head.next;
        ListNode ans = new ListNode(-1);
        ListNode currAns = ans;
        while(currNode != null) {
            int num = gcd(prNode.val, currNode.val);
            currAns.next = new ListNode(prNode.val);
            currAns = currAns.next;
            currAns.next = new ListNode(num);
            currAns = currAns.next;
          
            
            prNode = prNode.next;
            currNode = currNode.next;
        }
        if(prNode != null) {
            currAns.next = prNode;
        }
        printList(ans.next);
    }
 public static void main(String[] args) { 
    ListNode head = new ListNode(18);
    head.next = new ListNode(6);
    head.next.next = new ListNode(10);
    head.next.next.next = new ListNode(3);
  // ListNode node = deleteUsingArray(head, new int[] {9,2,5});
    TreeNode root = new TreeNode(2);
    
    root.right = new TreeNode(2);
    root.right.right = new TreeNode(2);
    root.right.right.right = new TreeNode(1);
    //printList(node);
    /* ans = new boolean[]{false};
    linkListInBinary(root, head);
    System.out.println(ans[0]);
     */
    //splitLinkList(head, 2);
    //matrixWithListNode(head, 3, 5);
    gcdWithLinkList(head);
}
}
