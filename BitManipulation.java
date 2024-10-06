public class BitManipulation {
    public static int countBitFlip(int start, int goal) {
        int count = 0;
        while(start !=0 || goal !=0) {
            int n1 = start & 1;
            int n2 = goal & 1;
            if(n1 != n2) {
                count++;
            }
            start = start >> 1;
            goal = goal >> 1;
        }
        return count;
    }
    public static void longestSubArray(int nums[]) {
        int result = 0;
        int maxlength = 0;
        int maxValue = 0;
        for(int num : nums) {
            if(num > maxValue) {
                maxValue = num;
                result = 0;
                maxlength = 0;
            }
            if(num == maxValue) {
                maxlength++;
            } else {
                maxlength = 0;
            }
            result = Math.max(result,maxlength);



        }
        System.out.println(maxlength);
    }
    public static void main(String[] args) {
       // System.out.println(countBitFlip(10, 7));
        longestSubArray(new int[]{1,2,3,4});
    }
}
