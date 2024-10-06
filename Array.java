import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
public class Array {
    public static void solver(int nums[]) {
        int count = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            max = Math.max(max,nums[i]);
        }
        int[] temp = new int[max+1];
        for(int i=0; i<nums.length; i++) {
            temp[nums[i]]++;
        }
        
        int index = 0; 
        for(int i=0; i<temp.length; i++) {
            
            int sameCount = 1;
            while(temp[i] != 0 && sameCount <= 2 ) {
                nums[index] = i;
                temp[i]--;
                index++;
                sameCount++;
                count++;
            }
        }
        System.out.println(Arrays.toString(nums) + " " + count);
        
    }
    public static List<List<Integer>> ans;
    public static void solver(List<Integer> helper, int nums[], int idx, List<Integer> index) {
        if(idx == nums.length ) {
            if(!ans.contains(helper)) {
                ans.add(new ArrayList<>(helper));
            }
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(index.contains(i)) continue;
            helper.add(nums[i]);
            index.add(i);
            solver(helper, nums, idx+1, index);
            helper.removeLast();
            index.removeLast();
        }
    }
    public static void permutation(int[] nums) {
        ans = new ArrayList<>();
        solver(new ArrayList<>(), nums, 0, new ArrayList<>());

        System.out.println(ans.toString());

    }
    public static int minimumTime(List<String> timePoints) {
        int time[] = new int[timePoints.size()];
        for(int i=0; i<timePoints.size(); i++) {
            String hr = timePoints.get(i).substring(0,2);
            String min = timePoints.get(i).substring(3);
            int hour = Integer.valueOf(hr);
            int minutes = Integer.valueOf(min);
            time[i] = (60 * hour + minutes);
        }
        Arrays.sort(time);
        int minTime = Integer.MAX_VALUE;
        for(int i=1; i<time.length; i++) {
            minTime = Math.min(minTime,time[i] - time[i-1]);
        }
        return Math.min(minTime,(24*60 - time[time.length-1])+time[0]);
    }
    public static void greatesNumber(int[] nums) {
        int helper = 1;
        int i=0;
       
        StringBuilder ans = new StringBuilder();
        Arrays.sort(nums);
        while(nums[0] != 0 ) {
            nums[0] = nums[0] / 10;
            helper = helper * 10;
        }
        for(int j=0; j<nums.length; j++) {
            if(nums[j] / helper != 0) {
                
                reverse(nums,i,j-1);
                helper = helper*10;
                i = j;
            } 
        }

        reverse(nums, i, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void reverse(int nums[],int start, int end) {
        Stack<Integer> helper = new Stack<>();
      
        for(int i=start; i<=end; i++) {
            helper.push(nums[i]);
        }
        for(int i=start; i<=end; i++) {
            nums[i] = helper.pop();
        }


    }
    public static void practice(int m, int n) {
        List<Integer> temp = new ArrayList<>(Arrays.asList(1,4,9));
        int count = 0;
        for(int i=m; i<=n; i++) {
            int p = i;
            boolean isvalid = true;
            while(p != 0) {
                if(!temp.contains(p%10)) {
                    isvalid = false;
                    break;
                }
                p = p/10;
            }
            if(isvalid) count++;
        }
        System.out.println(count);
    }
    public static void mangoes(int a, int m, int rs) {
        if(a > m) {
            rs -= (a-m); 
        } else if(a < m) {
            rs += (m-a);
        } else {
            System.out.println(rs);
            return;
        }
        System.out.println(rs);
    }
    public static void pairdivisiblebyK(int[] arr, int k) {
        int temp[] = new int[k];
        for(int i=0; i<arr.length; i++) {
            int rem = (arr[i]%k + k )%k;
            temp[rem]++;
        }
        if(temp[0] % 2 != 0) return;
        for(int i=1; i<k/2 ; i++) {
            int halfvalue = k - i;
            if(temp[halfvalue] != temp[i]) return;
        }
    }
    public static int minSubarray(int[] nums, int p) {
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum = (sum + nums[i])%p;
        }
        int target = sum % p;
        if (target == 0) {
            return 0;
        }
        int index = nums.length;
        sum = 0;
        HashMap<Integer,Integer> hash = new HashMap<>();
        hash.put(0,-1);
        for(int i=0; i<nums.length; i++) {
            sum = (sum + nums[i])%p;
            int prev = (sum - target + p) % p;
            if(hash.containsKey(prev)) {
                index = Math.min(index,i - hash.get(prev));
            }
            hash.put(sum, i);
        }
        return index == nums.length ? -1 : index;
    }
    public static long dividePlayers(int[] skill) {
        int n = skill.length;
        long chemistry = 0;
        int[] temp = new int[1000];
        int sum = 0;
        for(int i=0; i<n; i++) {
            temp[skill[i]]++;
            sum = sum + skill[i];
        }
        if(sum % (n/2) != 0 ) return -1;
        sum = sum / (n/2);
        System.out.println(sum);
        for(int i=0; i<n; i++) {
            int val = sum - skill[i];
            if(temp[val] <= 0) return -1;
            temp[val]--;
            chemistry += val * skill[i]; 
        }
        return chemistry/2;

    }
    public static int findpermutation(String str, int[] array) {
        int left = 0;
        while(left < str.length()) {
            int val = str.charAt(left) - 'a';
            if(array[val] == 0 ) {
                break;
            }
            array[val]--;
            left++;
        }
        return left;
    }
    public static boolean checkInclusion(String s1, String s2) {
        int[] s1Array = new int[26];
        for(int i=0; i<s1.length(); i++) {
            s1Array[s1.charAt(i)-'a']++;
        }
        int j = 0;
        int i = 0;
      /*   while(j < s2.length()) {
            int[] temp = s1Array.clone();
            if((j-i)+1 == s1.length()) {
                
                int val = s2.charAt(i) - 'a';
                int increm = 0;
                if(s1Array[val] != 0) {
                    increm = findpermutation(s2.substring(i,j+1), temp);
                    
                }
                if(increm == s1.length()) return true;
                i++;
            }
            j++;
        } */
        int temp[] = new int[26];
        while(j < s2.length()) {
            
            int idx = s2.charAt(j) - 'a';
            temp[idx]++;
            if((j-i)+1 == s1.length()) {
                if(Arrays.equals(temp, s1Array)) return true;
                
                int val = s2.charAt(i) - 'a';
                temp[val]--;
                i++;
            }
            
        
            
            j++;
        }
        return false;
    }

    public static void main(String[] args) {
        //solver(new int[]{0,0,1,1,1,1,2,3,3});
        //permutation(new int[]{1,2, 2,3});
        /* List<String> time = new ArrayList<>(Arrays.asList("23:00","00:00"));
       /* System.out.println( minimumTime(time)); 
       greatesNumber(new int[]{99,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999});
     */
       /*  practice(1, 20000); 
       mangoes(8, 4, 6);*/
        //System.out.println( dividePlayers(new int[]{1,2,3,4,5,6}));
        System.out.println(checkInclusion("adc",  "dcda"));
       
    }
}
