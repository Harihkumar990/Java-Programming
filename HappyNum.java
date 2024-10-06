import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HappyNum {
    public static boolean solver(int n) {
        while(n > 9 ) {
            int sum = 0;
            int tempNum = n;
            while(tempNum != 0) {
                int rem = tempNum % 10;
                sum += rem * rem;
                tempNum = tempNum / 10; 
            }
            n = sum;
        }
       
        return n == 1 || n == 7;
    }
    public static boolean isomorPhic(String s, String t) {
        HashMap<Character,Character> hash = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char chr1 = s.charAt(i);
            char chr2 = t.charAt(i);
            if(hash.containsKey(chr1)) {
                char value = hash.get(chr1);
                if(value != chr2) return false; 
            }else{
                if(hash.containsValue(chr2)) {
                    return false;
                }else{
                    hash.put(chr1,chr2);
                }
            }

        }
        
        return true;
    } 
    public static boolean duplicates(int[] nums, int k) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(hash.containsKey(nums[i])) {
                int value = hash.get(nums[i]);
                if(Math.abs(value - i) <= k) {
                    return true;
                }
                hash.replace(nums[i], i);
            }else{
                hash.put(nums[i], i);
            }
        }
        return false;
    }
    public static int twoKeyBoard(int n) {
        int count = 0;
        if(n == 1) return 0;
        int tempNum = 2;
        while(n != 1 && tempNum <= n ) {
            if(n%tempNum == 0) {
                count += tempNum;
                n = n / tempNum;
                tempNum = 1; 
            }
            tempNum++;
        }
        return count;
    }
    public static int sqrt(int n) {
        long low = 1;
        long high = n;
        long mid = 0;
        while(low <= high) {
            mid = low + (high - low)/2;
            if(mid * mid == n ) return (int)mid;
            else if(mid * mid > n) high = mid - 1;
            else low = mid + 1;
        }
        return (int)high;


    }
    public static int stepsSolver(int n, int ways, int steps) {
        if(steps == n) {
            return ways + 1;
        }
        if(steps > n) {
            return ways;
        }
        int totalWays = 0;
        for(int i=1; i<=2; i++) {
            totalWays += stepsSolver(n, ways, steps + i);
        }
        return totalWays;
    }
    public static int steps(int n) {
        if(n == 1 ) return 1;
        if(n == 2 ) return 2;
        return stepsSolver(n, 0, 0);
    }
    public static void merge(int nums1[], int m, int nums2[], int n) {
        int[] tempNum = new int[nums1.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(j < nums2.length && i < m) {
            if(nums1[i] < nums2[j]) {
                tempNum[k] = nums1[i];
                i++;   
            } else{
                tempNum[k] = nums2[j];
                j++;
            }  
            k++;
        }
        while(i < m) {
            tempNum[k] = nums1[i];
            i++;
            k++;
        }
        while(j < nums2.length) {
            tempNum[k] = nums2[j];
            j++;
            k++;
        }
        for(int id=0; id<tempNum.length; id++) {
            nums1[id] = tempNum[id];
        }
        System.out.println(Arrays.toString(nums1));
    }
    public static void main(String[] args) {
        //System.out.println(solver(Integer.MAX_VALUE-1));
        //System.out.println(isomorPhic("foo", "bar"));
        //System.out.println(duplicates(new int[]{1,2,3,1,2,3}, 2));
        //System.out.println(twoKeyBoard(12));
        //System.out.println(sqrt(2147395599));
        //System.out.println(steps(4));
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, 3, nums2, 3);
    }   
}
