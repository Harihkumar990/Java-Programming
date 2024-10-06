import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SubArraySum {
    public static void solver(int nums[], int k) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        hash.put(0, 1);
        int prefix = 0;
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            prefix = prefix + nums[i];
            int value = prefix - k;
           
            if(hash.containsKey(value)) {
              
                sum += hash.get(value);
            }
            hash.put(prefix, hash.getOrDefault(prefix, 0)+1);
        }
        System.out.println(sum);
        
        
 /*       int i = 0;
       int j = 0;
       int currSum = 0;
       int MaxSum = 0;
       while(j < nums.length) {
        if(currSum == k) {
            MaxSum = Math.max(MaxSum,(j-i));
            
            currSum = nums[i] < 0 ? currSum + nums[i] : currSum - nums[i];
            i++;
        
        }
        if(currSum > k) {
            currSum = nums[i] < 0 ? currSum + nums[i] : currSum - nums[i];
            i++;
         
        }
        currSum += nums[j];
        j++;
       }
       System.out.println(MaxSum);
  */   }
    public static List<Integer> ans;
    public static void recursion(int length, int sum, int k, List<Integer> helper) {
        if(sum == k && length == helper.size()) {
            ans.addAll(helper);
            return;
        }
        if(sum > k || helper.size() > length) {
            return;
        }
        for(int i=1; i<=6; i++) {
            if(ans.size() == length) break;
            sum = sum + i;
            helper.add(i);
            recursion(length, sum, k, helper);
            sum = sum - i;
            helper.removeLast();
        }

    }
    public static void findMissingObservation(int[] rolls, int mean, int n) {
        ans = new ArrayList<>();
        int sum = 0;
        for(int num : rolls ) {
            sum = sum + num;
        }
        int k = (mean * (n+rolls.length)) - sum;
        int[] result = new int[n];
        int i = 0;
        while(n != 1) {
            int num = k / n;
            
            if(num > 6) break;
            result[i] = num;
            i++;
            
            k = k - num;
            n--;
        }
        if(n != 1 || n <= 6) return;
        result[result.length-1] = k;
        System.out.println(Arrays.toString(result));

        
        
    }
    public static void main(String[] args) {
        /* solver(new int[]{1,1,1},2); */
        findMissingObservation(new int[]{1,5,6}, 3, 4);
    }
}
