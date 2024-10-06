import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiplyString {
    public static void solver(String num1, String num2) {
      int[] ans = new int[num1.length() + num2.length()];
      int idx = ans.length-1;
      int carry = 0;
      for(int i=num2.length()-1; i>=0; i-- ) {
        int rem = 0;
        int first = num2.charAt(i) - '0';
        int index = idx--;
        for(int j=num1.length()-1; j>=0; j--) {
            int second = num1.charAt(j) - '0';
            int multiply = (first * second) + carry + ans[index];
           
            if(multiply > 9) {
                rem = multiply % 10;
                carry = multiply / 10;
            } else {
                rem = multiply;
                carry = 0;
            }
            
            ans[index] = rem;
            index--;


        }
        if(carry != 0) {
            ans[index] = carry;
            carry = 0;
        }
        
      }
      StringBuilder result = new StringBuilder();
      for(int num : ans) {
        if(!result.isEmpty() || num != 0) {
            result.append(num);
        }
      }
      System.out.println(result.toString());
    }
    public static void compliment(int num) {
        List<Integer> list = new ArrayList<>();
        
        int ans = 0;
        while(num != 0) {
            int n = num & 1;
            
            if(n == 0) {
                list.addFirst(1);
               
            }else{
                list.addFirst(0);
                ans = ans | 0;
            }
           num =  num >> 1;
         
        }
       
        for(int i=0; i<list.size(); i++) {
            ans = ans | list.get(i);
            ans = ans << 1;
        }
        System.out.println(ans >> 1);
    } 
    public static List<List<Integer>> ans;
    public static void solver(int nums[], int idx, List<Integer> helper) {
        if(idx == nums.length) {
            ans.add(new ArrayList<>(helper));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(helper.contains(nums[i])) continue;
            helper.add(nums[i]);
            solver(nums, idx+1, helper);
            helper.removeLast();
           
        }
        
    }
    public static void permutation(int nums[]) {
        ans = new ArrayList<>();
        solver(nums, 0, new ArrayList<>());
        System.out.println(ans.toString());
    }
    public static int minJumpII(int[] nums) {
       
        
    }
    public static void main(String[] args) {
        //compliment(5);   
        //solver("123", "456");
        //permutation(new int[]{1,2,3,4});
        System.out.println(minJumpII(new int[]{1,1,1,4,1,1,1}));
    }
}
