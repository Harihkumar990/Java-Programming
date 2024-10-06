import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
public class ClosetPalindrome {
    public static List<String> result;
    public static void permutation(int idx, int[] nums, List<Integer> helper) {
        
        if(idx == nums.length) {
            solver(helper);
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(helper.contains(nums[i])) continue;
            helper.add(nums[i]);
            permutation(idx+1, nums, helper);
            helper.removeLast();
        }
    }
    public static void solver(List<Integer> helper) {
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<helper.size(); i++) {
            ans.append(helper.get(i));
        }
        result.add(ans.toString());
    }
    public static int nonRepating(String s) {
       int[] repeat = new int[26];
       for(int i=0; i<s.length(); i++) {
            repeat[s.charAt(i) - 'a']++;
       }
       for(int i=0; i<s.length(); i++) {
            if(repeat[s.charAt(i)- 'a'] == 1) {
                return i;
            }
       }
       return -1;
    }

    
    public static void main(String[] args) {
        /* result = new ArrayList<>();
        permutation(0, new int[] {1,2,3,4}, new ArrayList<>());
        System.out.println(result.toString()); */
        System.out.println(nonRepating("abcdeabcd") );
    }    
}
