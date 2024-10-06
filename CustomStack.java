import java.util.Arrays;

class CustomStack {
    public static int[] stack;
    public static int top = -1;
    CustomStack(int maxSize) {
        stack = new int[maxSize];
    }
    
    public static void push(int x) {
        if(stack.length - 1 == top) {
            return;
        }
        top++;
        stack[top] = x;
        
    }
    
    public static int pop() {
        if(top < 0) {
            return top;
        }
        return stack[top--];
        
    }
    
    public static void increment(int k, int val) {
        int idx = 0;
        while(idx != k && idx < stack.length) {
            stack[idx] = stack[idx] + val;
            idx++;
        }

    }
    public static void main(String[] args) {
        CustomStack sta = new CustomStack(5);
        sta.pop();
        sta.push(1);
        sta.push(2);
        sta.push(3);
        sta.push(4);
        
        sta.push(5);
        sta.push(6);
        System.out.println(Arrays.toString(stack));
        sta.increment(3, 100);
        System.out.println(Arrays.toString(stack));
        System.out.println(top);
        sta.pop();
        System.out.println(top);

    }
}