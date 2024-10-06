import java.util.Arrays;

public class Deque {
    static int[] list;
    public static int first,last,size,capacity; 
    public static void  MyCircularDeque(int k) {
        list = new int[k];
        first = 0;
        last = 0;
        Arrays.fill(list, -1);
        size = 0;
        capacity = k;
    } 
    public static boolean insertFront(int value) {
        if(isFull()) {
            return false;
        }
       public first = first == 0 ? capacity-1 : first--;
        list[first] = value;
        size++;
        return true;

    }
    
    public static boolean insertLast(int value) {
        if(isFull()) {
            return false;
        }
        last = last == capacity - 1 ? 0 : last++ ;
        list[last] = value;
        size++;
        return true; 
    }
    
    public static boolean deleteFront() {
        if(isEmpty()) {
            return false;
        }
        list[first] = -1;
        size--;
        first = first == capacity - 1 ? 0 : first++;
        return true;
    }
    
    public static boolean deleteLast() {
        if(isEmpty()) {
            return false;
        }
        last = last == 0 ? capacity-1 : last--;
        list[last] = -1;
        size--;
        return true;
        
    }
    
    public static int getFront() {
        if(isEmpty()) return -1;
        return list[first];

    }
    
    public static int getRear() {
        if(isEmpty()) return -1;
        if(last == 0) return list[capacity-1];
        return list[last-1];
    }
    
    public static boolean isEmpty() {
        return size == 0;
    }
    
    public static boolean isFull() {
        return size == capacity;
    }
    public static void main(String[] args) {
        MyCircularDeque(3);
        insertFront(1);
        insertLast(2);
        System.out.println(Arrays.toString(list));
    }
}
