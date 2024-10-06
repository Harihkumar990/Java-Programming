import java.util.List;
import java.util.ArrayList;
public class StrangePrinter {
    public static int n;
    public static int[][] list; 
    public static int solve(int l, int r, String s) {
        if(l == r) {
            return 1;
        }
        if(l > r) return 0;
        
        if(list[l][r] != -1) return list[l][r];
        int i = l + 1;
        while(i <= r && s.charAt(i) == s.charAt(l)) i++;
        if(i == r+1) return 1;
        int simple = 1 + solve(i, r, s);
        int lalach = Integer.MAX_VALUE;
        for(int j = i; j<=r; j++) {
            if(s.charAt(j) == s.charAt(l)) {
                int ans = solve(i, j-1, s) + solve(j, r, s);
                lalach = Math.min(lalach,ans);
            }
        }
        return list[l][r] =  Math.min(simple,lalach);
    }
    public static void main(String[] args) {
        String s = "aba";
        n = s.length();
        list = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                list[i][j] = -1;
            }
        }
       
        System.out.println(solve(0, n-1, s));
        

    }
}

