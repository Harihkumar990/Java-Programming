import java.util.ArrayList;

public class Kadanes {
    public static void solver(int nums[] ) {
        int currSum = nums[0];
        int maxSum = nums[0];
     
        int j=1;
        while(j<nums.length) {
            if(currSum < 0 ) {
                currSum = nums[j];
                maxSum = Math.max(currSum,maxSum);
                j++;
                continue;
            }
            currSum = currSum + nums[j];
            maxSum = Math.max(currSum,maxSum);
            j++;
        }
        System.out.println(maxSum);
        
    }
    public static void main(String[] args) {
        int nums[] = {-2};
        solver(nums);
    }
     
}