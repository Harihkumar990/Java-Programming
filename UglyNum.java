import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UglyNum {
    public static boolean isUgly(int num) {
        if(num == 1) {
            return true;
        }
        if(num % 2 !=0 && num  % 3 != 0 && num % 5 != 0) {
            return false;
        }
        if(num % 2 == 0) num = num / 2;
        if(num % 3 == 0) num = num / 3;
        if(num % 5 == 0) num = num / 5;
        return isUgly(num);
    }
   
    public static int solver(int n) {
        int[] arr = new int[n];
        int i2 = 1, i3 = 1, i5 = 1;
        arr[0] = 1;
        for(int i=2; i<=n; i++) {
            int i2Ugly = arr[i2 - 1] * 2;
            int i3Ugly = arr[i3 - 1] * 3;
            int i5Ugly = arr[i5 - 1] * 5;
            int minUgly = Math.min(i2Ugly,Math.min(i3Ugly,i5Ugly));
            arr[i-1] = minUgly;
            if(minUgly == i2Ugly){ i2 = i2 + 1;}
            if(minUgly == i3Ugly) {i3 = i3 + 1;}
            if(minUgly == i5Ugly) {i5 = i5 + 1;}
            
        }
        System.out.println(Arrays.toString(arr));
        return arr[n-1];
    }
    public static int superUgly(int n, int primes[]) {
        int[] primesLen = new int[primes.length];
        for(int i=0; i<primes.length; i++) {
            primesLen[i] = 1;
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        for(int i=2; i<=n; i++) {
            int minUgly = Integer.MAX_VALUE;
            int index = 0;
            for(int j = 0; j<primes.length; j++) {
                int tempUgly = ans.get(primesLen[j] - 1) * primes[j];
                if(tempUgly < minUgly) {
                    minUgly = tempUgly;
                    index = j;
                }
            }
            if(!ans.contains(minUgly)) {
                ans.add(minUgly);
                primesLen[index]++;
            }else{
                primesLen[index]++;
                i--;
            }

        }
        
        return ans.get(n-1);
    } 
    public static void main(String[] args) {
     //System.out.println(solver(11));   
       
     //   System.out.println(1 % 2 == 0);
        //System.out.println(isUgly(14));
        System.out.println(superUgly(100000, new int[] {7,19,29,37,41,47,53,59,61,79,83,89,101,103,109,127,131,137,139,157,167,179,181,199,211,229,233,239,241,251})
        );
    }
}
