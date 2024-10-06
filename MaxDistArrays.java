import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class MaxDistArrays {
    public static void solver(List<List<Integer>> arrays) {
        int maxDist = Integer.MIN_VALUE;
        int smallest = arrays.get(0).get(0);
        int biggest = arrays.get(0).get(arrays.size() - 1);
        for(int i=1; i<arrays.size(); i++) {
            int BiggestDist = Math.max(Math.abs(smallest - arrays.get(i).get(arrays.get(i).size() - 1)) , Math.abs(biggest - arrays.get(i).get(0)));
            maxDist = Math.max(maxDist, BiggestDist);
            smallest = Math.min(smallest,arrays.get(i).get(0));
            biggest = Math.max(biggest,arrays.get(i).get(arrays.get(i).size() - 1));

        }
        System.out.println(maxDist);
        
    }
    public static List<Integer> greyCode(int n) {
        if(n == 1) {
            List<Integer> baseRes = new ArrayList<>();
            baseRes.add(0);
            baseRes.add(1);
            return baseRes;
        }
        List<Integer> RecursionRes = greyCode(n-1);
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<RecursionRes.size(); i++) {
            result.add(RecursionRes.get(i));
        }
        for(int i=RecursionRes.size()-1; i>=-0; i--) {
           
            result.add( 1 << n-1 | RecursionRes.get(i));
        }
        return result;
    }
    public static void solver(int[] nums, List<Integer> helper, List<List<Integer>> result, int idx) {
        if(idx == nums.length ) {
            List<Integer> temp = new ArrayList<>(helper);
            Collections.sort(temp);
            if(!result.contains(temp)) {
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        helper.add(nums[idx]);
        solver(nums, helper, result, idx + 1);
        helper.removeLast();
        solver(nums, helper, result, idx + 1);
    }
    public static List<List<Integer>> duplicateSubSet(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        solver(nums, new ArrayList<>(), result, 0);
        System.out.println(result.toString());
        return (result);
    }
    public static void main(String[] args) {
        /* List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(Arrays.asList(1,2,3));
        arrays.add(Arrays.asList(4,5));
        arrays.add(Arrays.asList(1,2,3));
        solver(arrays); *//* 
        List<Integer> result = greyCode(3);
        System.out.println(result.toString()); */
        int[] nums = {4,4,4,1,4};
        duplicateSubSet(nums);
    }
}