import java.util.ArrayList;
import java.util.List;

public class Combination {
    public static List<List<Integer>> ans;
    public static void solver(int n, int k, List<Integer> helper,int idx) {
        if(helper.size() == k) {
            ans.add(new ArrayList<>(helper));
        }
        if(helper.size() > k) return;

        for(int i=idx; i<=n; i++) {
            
            if(helper.contains(i)) continue;
            helper.add(i);
            solver(n, k, helper,i);
            helper.removeLast();
        }

    }

    
    public static void main(String[] args) {
        ans = new ArrayList<>();
        solver(1, 1, new ArrayList<>(), 1);
        System.out.println(ans.toString());
    }
}
