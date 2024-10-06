import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Recursion {
    public static List<Integer> result;
    public static void solver(int num, int limit, int k) {
        if(num > limit) return;
        k--;
        if(k == 0) {
            result.add(num);
            return;
        }
        
        for(int i=0; i<10; i++) {
            if(result.size() != 0) return;
            
            solver(10*num+i,limit,k);
        }
    }
    public static int factorial(int fact) {
        if(fact == 1) return 1;
        return fact * factorial(fact-1);
    }
    public static void kthpermutation(List<Integer> temp, int num[], int idx, int k) {
        if(temp.size() == 1) {
            num[idx] = temp.getFirst();
            return;
        }
        int factvalue = factorial(temp.size()-1);
        
        
        int divis = k / factvalue;
        System.out.println(divis);
        num[idx] = temp.get(divis);
        temp.remove(divis);
        if(divis == 0) divis = 1;
        kthpermutation(temp, num, idx++, k % divis);

    }
    public static void main(String[] args) {
     /*    result = new ArrayList<>();
        for(int i=1; i<=9; i++) {
            solver(i, 1000000000,10000);
        }
        System.out.println(result.toString()); */
        int k = 16;
        int n = 4;
        List<Integer> temp  = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            temp.add(i);
        }
        int ans[] = new int[n];
        kthpermutation(temp, ans , 0, k);
        System.out.println(Arrays.toString(ans));

    }
}
