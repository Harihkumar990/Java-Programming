
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class LinkList {
    Node head;
    public class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    public void addElement(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }
    public void displayLink(Node head){
        Node currNode = head;
        while(currNode != null){
            System.out.println(currNode.data);
            currNode = currNode.next;
        }
    }

    public void mergerLinkList(Node head){

        Node curNode = head.next;
        Node result = new Node(-1);
        
        Node rsCurrNode = result;
        int sum = 0;
        
        while(curNode!=null){
            
            if(curNode.data == 0){
                Node helperNode = new Node(sum);
                rsCurrNode.next = helperNode;
                rsCurrNode = rsCurrNode.next;
                sum = 0;
               
            }else{
                sum += curNode.data;
            }
            curNode = curNode.next;
            
        }
        
        displayLink(result.next);
    }
    public void criticalPoints(Node head){
        Node currNode  = head;
        int size = 0;
        int result[] = new int[2];
        
        for(int i=0;i<2;i++){
            result[i] = -1;
        }
        while(currNode!=null){
            size++;
            currNode = currNode.next;
        }
        
        if(size <= 2){
            return;
        }
        
        
        int index = 2;
        ArrayList<Integer> helper = new ArrayList<>();
        Node prevNode = head;
        Node curNode = head.next;
        Node nextNode = head.next.next;
        while(nextNode!=null){
            if(curNode.data < prevNode.data && curNode.data < nextNode.data){
                helper.add(index);
                
            }
            else if(curNode.data > prevNode.data && curNode.data > nextNode.data){
                helper.add(index);
                
            }
            index++;
            curNode = curNode.next;
            prevNode = prevNode.next;
            nextNode = nextNode.next;

        }
        if(helper.size() == 0){
            return;
        
        }else if(helper.size() == 1 ){
            result[0] = helper.get(0);
            result[1] = helper.get(0);
        }
        else {
            int max = helper.get(helper.size()-1) - helper.get(0);
            int min = Integer.MAX_VALUE;
            for(int i=0;i<helper.size()-1;i++){
                min = Math.min(min,helper.get(index+1) - helper.get(i));
            }
            result[0] = min;
            result[1] = max;

        }
        System.out.println(Arrays.toString(result));

    }
    public void swapAdjacentElement(Node head){
        Node currNode = head;
        Node newhead = head.next;
        while(currNode !=null && currNode.next != null){
            Node nextNode = currNode.next;
            currNode.next = currNode.next.next;
            nextNode.next = currNode;
            currNode = currNode.next;
            if(currNode != null && currNode.next != null){
                nextNode.next.next = currNode.next;
            }
            
        }
        displayLink(newhead);
    }
    public Node kthNode(Node head, int index){
        index -= 1;
        while( head !=null && index >0){
            index--;
            head = head.next;
            
        }
        return head;
    }
    public Node reverseKthGroup(Node head){
        Node currNode = head;
        Node prevNode = null;
        while(currNode !=null ){
            Node tempNode = currNode.next;
            currNode  = prevNode;
            prevNode = currNode;
            currNode = tempNode;
        }
        return prevNode;
    }
    public void riverseKNodes(Node head, int k){
        Node tempNode = head;
        Node prevNode = null;
        while(tempNode !=null){
            Node kthNode = kthNode(tempNode, k);
            if(kthNode == null){
                if(prevNode != null){
                    prevNode.next = tempNode;
                }
                break;
            }
            Node nextNode = kthNode.next;
            kthNode.next= null;
            reverseKthGroup(tempNode);
            if(tempNode == head){
                head = kthNode;
            }else{
                prevNode.next = kthNode;
            }
            prevNode = tempNode;
            tempNode = nextNode;
        }
        displayLink(head);

    }
    public void reverseList(Node head, int k) {
       Node sizeNode = head;
       int size = 0;
       while(sizeNode != null) {
        size++;
        sizeNode = sizeNode.next;
       }
       k = k % size;
       while(k != 0) {
        Node currNode = head;
        while(currNode.next.next != null) {
            currNode = currNode.next;
        } 
        Node tempNode = currNode.next;
        currNode.next = null;
        Node newNode = head;
        head = tempNode;
        head.next = newNode;
        k--;
       }
       
       displayLink(head);
    
    }
    public boolean findcycle(Node head, int pos) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        Node curNode = head;
   
        int value = 0;
        while(curNode != null) {
            if(hash.containsKey(curNode.data)) {
                if(pos == hash.get(curNode.data)) {
                    return true;
                }
            }else{
                hash.put(curNode.data, value);
            }
            value++;
            curNode = curNode.next;
            
        }
        return false;
    }
    public Node reverseList(Node head) {
        if(head == null) {
            return new Node(-1);
        }
        if(head.next == null) {
            return head;
        }
        Node prevNode = null;
        Node curNode = head;
        while(curNode != null) {
            Node newNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = newNode;
        }
        displayLink(prevNode);
        return head;
    }     
    public boolean isPalindrome(Node head) {
        if(head == null) {
            return false;
        }
        if(head.next == null) {
            return true;
        }
        Node newHead = new Node(head.data);
        Node listNode = newHead;
    
        Node curNodE = head.next;
        while(curNodE != null) {
            
            listNode.next = new Node(curNodE.data);
            curNodE = curNodE.next;
            listNode = listNode.next;
        }
        Node prevNode = null;
        Node curNode = head;
        
        while(curNode != null) {
            Node newNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = newNode;
        }       
        while(newHead != null) {
           
            if(newHead.data != prevNode.data) {
                return false;
            }
            newHead = newHead.next;
            prevNode = prevNode.next;
        }
        return true;
    }
    public void sortedinRange(Node head, int m, int n) {
        if(head == null) {
            return;
        }
        if(head.next == null) {
            return;
        }
        Node prevNode = null;
        Node currNode = head;
        for(int i=1; i<m; i++) {
            prevNode = currNode;
            currNode = currNode.next;
        }
        Node rtail = currNode;
        Node rhead = null;
        for(int i=1; i<n; i++) {
            Node newNode = currNode.next;
            currNode.next = rhead;
            rhead = currNode;
            currNode = newNode;
        }
        if(prevNode != null) {
            prevNode.next = rhead;
        }else{
            head = rhead;
        }

        rtail.next = currNode;
       displayLink(head);
    }
    public int detectCycle(Node head) {
        if(head == null) {
            return 0;

        }
        if(head.next == null) {
            return 0;
        }
        Node hive = head.next;
        Node turtle = head;
        int pos = 0;
        while(hive != null && hive.next != null ) {
            turtle = turtle.next;
            hive = hive.next.next;
        }
        Node curNode = head;
        while(curNode != turtle) {
            pos++;
            curNode = curNode.next;
        }
        return pos;
    }
    public void deleteNode(Node head, int val) {
        Node ans = new Node(-1);
        Node cuNode = ans;
        while(head != null) {
            if(head.data != val) {
                cuNode.next = head;
                cuNode = cuNode.next;
            }
            head = head.next;
        }
        cuNode.next = null;
        displayLink(ans.next);
    }
    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.addElement(1);
        list.addElement(2);
        list.addElement(3);
        list.addElement(4);
        list.addElement(3);
       
        //list.swapAdjacentElement(list.head);
        //list.riverseKNodes(list.head, 2);
        //list.reverseList(list.head, 4);
        //list.reverseList(list.head);
        //System.out.println(list.isPalindrome(list.head));
        //list.sortedinRange(list.head, 1, 1);
        list.deleteNode(list.head, 3);
    }
}
