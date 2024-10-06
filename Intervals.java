import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class Intervals {
    public static void solver(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));
        int end = intervals[0][1];
        int count = 0;
       

        for(int i=1; i<intervals.length; i++) {
            int currEnd = intervals[i][1];
            int currStart = intervals[i][0];
            if(end > currStart) {
                count++;
            } else {
                end = currEnd;
            }

            
        }
        System.out.println(count);
    }
    public static List<List<Integer>> ans;
    public static void answerLoop(int nums[], int idx, List<Integer> helper) {
        if(helper.size() >=2) {
            ans.add(new ArrayList<>(helper));
          
        }
        Set<Integer> temp = new HashSet<>();
        for(int i=idx; i<nums.length;i++) {
           if((helper.isEmpty() || nums[i] >= helper.getLast()) && !temp.contains(nums[i])) {
                helper.add(nums[i]);
                answerLoop(nums, i+1, helper);
                helper.removeLast();
                temp.add(nums[i]);
            }


               
        }
       

        
    }
    public static void nonDecreasing(int nums[]) {
        ans = new ArrayList<>();
        answerLoop(nums, 0, new ArrayList<>());
        System.out.println(ans.toString());
    }
    public static void main(String[] args) {/* 
        solver(new int[][] {{1,9},{1,8},{1,7},{1,6},{1,5},{2,4},{1,10},{1,2}}); */
        nonDecreasing(new int[]{4,6,7,7});
    }
}
