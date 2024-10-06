import java.util.Stack;

public class MinimumDeletion {
    public static int minimumDeletion(String s) {
        int count = 0;
        Stack<String> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char chr = s.charAt(i);
            if(!stack.isEmpty() && chr == 'a' && stack.peek().equals('b')) {
                stack.pop();
                count++;
            }else{
                stack.push(chr+"");
            }
        }
        
        return count;
    }
    public static void main(String[] args) {
    System.out.println(minimumDeletion("aababbab"));
 }   
}
