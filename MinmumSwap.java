public class MinmumSwap {
    public static int minSwaps(int[] nums) {
       int n = nums.length;
      
       int totalOne = 0;
       for(int i=0; i<nums.length; i++) {
        if(nums[i] == 1) {
            totalOne++;
        }
       }
     
       int i=0,j=0,maxCount=0,currCount=0;
       while(j<2*n) {
        if(nums[j%n] == 1) {
            currCount++;
        }
        if(j-i +1  > totalOne ) {
            currCount -= nums[i%n];
            i++;
        }
        maxCount = Math.max(maxCount,currCount);
        j++;
       }
       return totalOne - maxCount;
    }
    public static void main(String[] args) {
    int nums[] = {0,1,1,1,0,0,1,1,0};
    System.out.println(minSwaps(nums));
 }   
}
