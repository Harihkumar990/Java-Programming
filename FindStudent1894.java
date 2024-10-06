import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindStudent1894 {

    public static int chalkReplacer(int[] chalk, int k) {
        long needChalk = 0;
        for(int i=0; i<chalk.length; i++) {
            needChalk = needChalk + chalk[i];
        }
        long remaingChalk = (int) k % needChalk;
        for(int i=0; i<chalk.length; i++) {
            if(remaingChalk < chalk[i]) return i;
            remaingChalk -= chalk[i];
        }
        return 0;



    }


    public static void nextPermutation(int[] nums) {
        int index = -1;
        for(int i=nums.length-1; i>=0; i--) {
            if(i !=0 && nums[i] > nums[i-1] ) {
                index = i-1;
                break;
            }
        }

        if(index == -1) quickSort(nums, 0, nums.length-1);
        int maxElemntIndex = -1;
        int currMax = 0;
        int i = index + 1;
        while(i < nums.length) {
            if(nums[i] > nums[index]) {
                currMax = nums[i];
                maxElemntIndex = maxElemntIndex == -1 ? i : maxElemntIndex;
            }            
            if(nums[maxElemntIndex] > currMax) {
                maxElemntIndex = i;
            }
            
            i++;
        }
        swap(nums,maxElemntIndex,index);

        quickSort(nums, index+1, nums.length-1);
    }
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static int sort(int[] nums, int low, int high) {
        int i = (low - 1);
        int elemnt = nums[high];
        for(int j=low; j<=high-1; j++) {
            if(nums[j] < elemnt) {
                i++;
                swap(nums,i,j);
            }
        }
        swap(nums,i+1,high);
        return i+1;
        
    }
    public static void quickSort(int[] nums, int low, int high) {
        if(low < high) {
            int mid = sort(nums,low,high);
            quickSort(nums, low, mid-1);
            quickSort(nums, mid+1, high);
        }
    }
    public static  int getLucky(String s, int k) {
        int i=0;
        StringBuilder str = new StringBuilder();

        while(i < s.length()) {
            int num =( s.charAt(i) - 'a') + 1;
            str.append(num);
            i++;
        }
        
        while(k != 0 && str.length() > 1) {
            
            StringBuilder temp = new StringBuilder(str);
            str.delete(0,str.length());
            int idx = 0;
            int nums = 0;
            while(idx < temp.length()) {
                int num =( temp.charAt(idx) - '0')  ;
                
                nums += num;
                idx++;
            }
            str.append(nums);
            k--;
        }  
        return Integer.valueOf(str.toString());   
    }
    public static void walkingRobot(int[] commands, int[][] obstacles) {
        List<String> list = new ArrayList<>();
        for(int num[] : obstacles) {
            list.add(num[0] + "," + num[1]);
        }
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        int d = 0;
        int x = 0, y = 0;
        int maxDist = 0;
        for(int command : commands) {
            if(command == -1) {
                d = (d + 1) % 4;
            } else if(command == -2) {
                d = (d + 3) % 4;
            } else {
                for(int i=0; i<command; i++) {
                    int nx = x + dir[d][0];
                    int ny = y + dir[d][1];
                    if(list.contains(nx + "," + ny)) {
                        break;
                    }
                    x = nx;
                    y = ny;
                    maxDist = Math.max(maxDist,x*x+y*y);

                }
            }

        }
        System.out.println(maxDist);
    }
    
    public static void main(String[] args) {
     //System.out.println(chalkReplacer(new int[]{100000, 1, 100000, 1, 100000, 1, 100000, 1, 100000, 1}, 500000));   
      /* int[] nums = {2,4,6,8,1,0};
      quickSort(nums, 0, nums.length-1);
      System.out.println(Arrays.toString(nums)); */  
     /*  int[] nums = {1,3,2};
      nextPermutation(nums);
      System.out.println(Arrays.toString(nums)); 
      System.out.println(getLucky("zbax",2));*/
      walkingRobot(new int[]{4,-1,4,-2,4}, new int[][]{{2,4}});
    }
}