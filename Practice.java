import java.util.*;


public class Practice {
    ListNode head;
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            next = null;    
        }
    }
    public void addElemnt(int data){
        ListNode newNode = new ListNode(data);
        if(head == null){
            head = newNode;
            return;
        }
        ListNode currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }
    public static void recursionArrayList(ListNode currNode, ArrayList<Integer> array){
        if(array.isEmpty() || currNode.val >= array.getLast() ){
            array.add(currNode.val);
            return;
        }
        int temp = array.removeLast();
        recursionArrayList(currNode, array);
        array.add(temp);

    }
    public static void sortMatrix(ListNode[] lists){
        ArrayList<Integer> array = new ArrayList<>();
        ListNode result = new ListNode(-1);
        
        for(int i=0;i<lists.length;i++){
            ListNode currNode = lists[i];
            
            while(currNode != null){
                recursionArrayList(currNode, array);
                currNode = currNode.next;
            }
            
        }
        
        ListNode curr = result;
        while(!array.isEmpty()){
            ListNode create = new ListNode(array.removeFirst());
            curr.next = create;
            curr  = curr.next;
        }
        printLisnkList(result.next);
        
    }
    public static void printLisnkList(ListNode l1){
        ListNode curr = l1;
        while(curr != null){
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
 public static void main(String[] args) {
    Practice l1 = new Practice();
    l1.addElemnt(1);
    l1.addElemnt(4);
    l1.addElemnt(5);
    Practice l2 = new Practice();
    l2.addElemnt(1);
    l2.addElemnt(3);
    l2.addElemnt(4);
    Practice l3 = new Practice();
    l3.addElemnt(2);
    l3.addElemnt(6);
    ListNode[] lists = new ListNode[3];
    lists[0] = l1.head;
    lists[1] = l2.head;
    lists[2] = l3.head;
    ListNode[] lists2 = new ListNode[2];
    Practice l4 = new Practice();
    l4.addElemnt(1);
    Practice l5 = new Practice();
    lists2[1] = l5.head;
    lists2[0] = l4.head; 
    sortMatrix(lists2);
 }   
}
