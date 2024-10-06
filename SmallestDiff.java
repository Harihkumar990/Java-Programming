import java.util.Arrays;

public class SmallestDiff {
    public static int solver(int[] nums, int k) {
        int max  = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            max = Math.max(max,nums[i]);
        }
        int[] temp = new int[max + 1];
        int i=0;
        int j=1;
        int index = 1;
        boolean check = true;
        while(check){
            if(j == nums.length) {
                i=0;
                j = index + 1;
                index++;
            }
            
            if(i == 0 && j == nums.length) {
                break;
            }
            temp[Math.abs(nums[j] - nums[i])]++;
            i++;
            j++;
        }
        System.out.println(Arrays.toString(temp));
        for(int idx=0; idx<temp.length; idx++) {
            k = k - temp[idx];
            if(k <= 0 ) {
                return idx;
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        int[] nums = {1,6,1};
        int k = 2;
        System.out.println(solver(nums, k));
    }
}
