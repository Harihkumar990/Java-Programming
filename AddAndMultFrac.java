import java.io.CharConversionException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddAndMultFrac {
    public static int gcd(int x, int y) {
        int a = x;
        int b = y;
        int r = b;
        while(a%b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return r;
    }
    public static void solver(String expression) {
      int num = 0;
      int denum = 1;
      int i=0;
      while(i < expression.length()) {
        int currNum = 0;
        int CurrDenom = 0;
        boolean isNeg = expression.charAt(i) == '-';
        if(expression.charAt(i) == '+' || expression.charAt(i) == '-') {
            i++;
        }
        while(i<expression.length() && Character.isDigit(expression.charAt(i))) {
            int val = expression.charAt(i) - '0';
            
            currNum = (currNum * 10) + val;
            i++;
        }
        i++;
        if(isNeg == true) {
            currNum = currNum * -1;
        }
        while(i <expression.length() && Character.isDigit(expression.charAt(i))) {
            int val = expression.charAt(i) - '0';
            CurrDenom = (CurrDenom * 10) + val;
           
            i++;
        }
       

        num = num * CurrDenom + currNum * denum;
        denum = denum * CurrDenom;

      }
      int rem = Math.abs(gcd(num,denum));
      num = num / rem;
      denum = denum / rem;
      System.out.println(num + " " + denum + " " + rem);
    }
    public static void mergeIntegrval(int intervals[][]) {
        
        List<int[]> list = new ArrayList<>();
        
        list.add(new int[]{intervals[0][0],intervals[0][1]});
        int index = 0;
        for(int i=1; i<intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            if(list.get(index)[1] >= currStart && currEnd != 0) {
                list.get(index)[0] = Math.min(currStart,list.get(index)[0]);
                list.get(index)[1] = Math.max(currEnd,list.get(index)[1]);
            } else {
                list.add(new int[]{currStart,currEnd});
                index++;
            }
            
        }
        int[][] ans = new int[list.size()][2];
        for(int i=0; i<list.size(); i++) {
            ans[i] = list.get(i);
            System.out.println(Arrays.toString(list.get(i)));
        }
    }
    public static void main(String[] args) {
        //solver("-5/2+10/3+7/9");
        mergeIntegrval(new int[][] {{1,6},{0,4}});
    }   
}
