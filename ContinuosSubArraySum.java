import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Stack;

public class ContinuosSubArraySum {
    public static boolean solver(int nums[], int k) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        hash.put(0,  0);
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            int tempNum = nums[i];
            sum += tempNum;
            if(hash.containsKey(sum%k)) {
                if((i - hash.get(sum%k)) >=2) {
                    return true;
                }
            }
            if(tempNum == 0) {
                if(i+1 != nums.length && nums[i+1] == 0) {
                    return true;
                }
            }
            hash.put(sum%k,i);
            
        }
        
        return false;
    }
    public static int longestValidParentheses(String s) {
        int max = 0;
        int left = 0;
        int right = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                left++;
            }else{
                right++;
            }
            if(left == right) {
                max = Math.max(left*2,max);
            }else if(right > left) {
                left = 0;
                right = 0;
            }
        }    
        left = 0;
        right = 0;
        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i) == '(') {
                left++;
            }else{
                right++;
            }
            if(left == right) {
                max = Math.max(right*2,max); 
            }else if(right < left) {
                left = 0;
                right = 0;
            }
        }
        return max;
    }
    public static int[] plusOne(int[] digits) {
        int length = digits.length -1;
        ArrayList<Integer> ans = new ArrayList<>();
        digits[length] = digits[length] + 1;
        for(int i=length ; i>=0; i--) {
            if(digits[i] > 9) {
                ans.addFirst(0);
                if(i == 0) {
                    ans.addFirst(1);
                }else{
                    digits[i-1] = digits[i-1] + 1;
                }
            }else{
                ans.addFirst(digits[i]);
            }
        }
        int[] result = new int[ans.size()];
        for(int i=0; i<ans.size(); i++) {
            result[i]  = ans.get(i);
        }
        
        return result;
    }
    public static String addBinary(String a, String b) {
        if(a.equals(b)) {
            return a+"0";
        }
        char remiander = '.';
        String ans = "";
        String smaller = a.length() > b.length() ? b : a;
        String bigger = a.length() > b.length() ? a : b;
        int j= bigger.length()-1;
        for(int i=smaller.length() -1 ; i>=0; i--) {
            char chrA = bigger.charAt(j);
            char chrB = smaller.charAt(i);
            if( remiander != '1' && chrA == '1' && chrB == '1') {
                ans = "0" + ans;
                remiander = '1';
            }else if(remiander == '1' && chrA == '1' && chrB == '1') {
                ans = "1" + ans;
                remiander = '1';
            }else if(remiander == '1' && chrA == '1' || chrB == '1') {
                ans = "0" + ans;
                remiander = '1';
            }else if(remiander == '1' && chrA == '0' && chrB == '0'){
                ans = "1" + ans;
                remiander = '.';
            }else if(remiander != '1' && chrA == '1' || chrB == '1') {
                ans = "1" + ans;
                remiander = '.';
            }else{
                ans = "0" + ans;
                remiander = '.';
            }
            j--;
        }
        for(int k=j; k>=0; k--) {
            char chA = bigger.charAt(k);
            if(remiander == '1' && chA == '1') {
                ans = "0" + ans;
                remiander = '1';
            }
        }
        ans = remiander + "" + ans;
        return ans.toString();
    }
    public static void jumpGame2(int[] nums ) {
        int jumps = nums[0] - 1;
        while(jumps < nums.length) {
            jumps += nums[jumps];
        }
        
    } 
    public static String kthDistinct(String[] arr, int k) {
        LinkedHashMap<String,Integer> hash = new LinkedHashMap<>();
        for(String str : arr) {
            if(hash.containsKey(str)) {
                hash.replace(str, hash.get(str) + 1);
            }else{
                hash.put(str, 1);
            }
        }
        for(String keys : hash.keySet()) {
            int value = hash.get(keys);
            if(value == 1) {
                k--;
            }
            if(k == 0) {
                return keys;
            }
        }
        return "";
    }
    public static void main(String[] args) {
          /*   int nums[] = {23,0};
            System.out.println(solver(nums, 13)); 
            String s = "()(()";
            System.out.println(longestValidParentheses(s));
            int[] nums = {9,9,9,9,9,9,9,9,9,9,9,6,9,9,9,9,9,9,9,9,9,9,9};
            System.out.println(Arrays.toString(plusOne(nums)));
            String a = "1010";
            String b = "1011";
            System.out.println(addBinary(a, b));*/
            String arr[] = {"d","b","c","b","c","a"};
            System.out.println(kthDistinct(arr, 0));
        }       
}
