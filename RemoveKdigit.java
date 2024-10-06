import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import javax.management.AttributeList;

public class RemoveKdigit {
    public static String solver(String num, int k) {
       Stack<Character> stack  = new Stack<>();
       for(char ch : num.toCharArray()) {
            while(!stack.isEmpty() && k > 0 && stack.peek() > ch) {
                stack.pop();
                k--;
            }
            stack.push(ch);
       }
        while(k != 0 && !stack.isEmpty()) {
                stack.pop();
                k--;
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()) {
            ans.append(stack.pop()+"");
        }
        ans.reverse();
        while(ans.length() > 0 && ans.charAt(0) == '0') {
            ans.deleteCharAt(0);
        }
        return ans.toString().length() == 0 ? "0" : ans.toString();
            
    }
    public static int findunique(int[] nums) {
        int num = 0;
        for(int i=0; i<nums.length; i++) {
            num = num ^ nums[i];
        }

        return num;
    }
    public static int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            int tempNum = n&1;
         
            if(tempNum == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
    public static char findTheDifference(String s, String t) {
        char c = 0;
        for(char ch : s.toCharArray()) c^=ch;
        for(char ch : t.toCharArray()) c^=ch;
        return c;
    }
    public static String binaryTOHEXA(int num) {
        if(num == 0) {
            return "0";
        }
        String[] findAns = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g"};
        StringBuilder ans = new StringBuilder();
        while(num != 0) {
            ans.append(findAns[num & 15]);
            num = num >>> 4;

        }
        return ans.reverse().toString();
    }
    public static void solver(int num[],List<List<Integer>> ans, List<Integer> helper, int idx) {
        if(idx == num.length) {
            ans.add(new ArrayList<>(helper));
            return;
        }
        helper.add(num[idx]);
        solver(num, ans, helper, idx+1);
        helper.removeLast();
        solver(num, ans, helper, idx + 1);
    }
    public static void subSet(int nums[]) {
        List<List<Integer>> ans   = new ArrayList<>();
        solver(nums, ans, new ArrayList<>(), 0);
        for(int i=0 ;i<ans.size(); i++) {
            System.out.print(ans.get(i).toString());
        }
        
    }
    public static void main(String[] args) {
        /* String num = "11";
        System.out.println(solver(num, 2)); 
        int[] nums = {1,2,2,1,3,3,4,4,4,4,5,5,7};
        System.out.println(findunique(nums));*/
        /* System.out.println(hammingWeight(Integer.MAX_VALUE-1));
        System.out.println(findTheDifference("ymbgaraibkfmvocpizdydugvalagaivdbfsfbepeyccqfepzvtpyxtbadkhmwmoswrcxnargtlswqemafandgkmydtimuzvjwxvlfwlhvkrgcsithaqlcvrihrwqkpjdhgfgreqoxzfvhjzojhghfwbvpfzectwwhexthbsndovxejsntmjihchaotbgcysfdaojkjldprwyrnischrgmtvjcorypvopfmegizfkvudubnejzfqffvgdoxohuinkyygbdzmshvyqyhsozwvlhevfepdvafgkqpkmcsikfyxczcovrmwqxxbnhfzcjjcpgzjjfateajnnvlbwhyppdleahgaypxidkpwmfqwqyofwdqgxhjaxvyrzupfwesmxbjszolgwqvfiozofncbohduqgiswuiyddmwlwubetyaummenkdfptjczxemryuotrrymrfdxtrebpbjtpnuhsbnovhectpjhfhahbqrfbyxggobsweefcwxpqsspyssrmdhuelkkvyjxswjwofngpwfxvknkjviiavorwyfzlnktmfwxkvwkrwdcxjfzikdyswsuxegmhtnxjraqrdchaauazfhtklxsksbhwgjphgbasfnlwqwukprgvihntsyymdrfovaszjywuqygpvjtvlsvvqbvzsmgweiayhlubnbsitvfxawhfmfiatxvqrcwjshvovxknnxnyyfexqycrlyksderlqarqhkxyaqwlwoqcribumrqjtelhwdvaiysgjlvksrfvjlcaiwrirtkkxbwgicyhvakxgdjwnwmubkiazdjkfmotglclqndqjxethoutvjchjbkoasnnfbgrnycucfpeovruguzumgmgddqwjgdvaujhyqsqtoexmnfuluaqbxoofvotvfoiexbnprrxptchmlctzgqtkivsilwgwgvpidpvasurraqfkcmxhdapjrlrnkbklwkrvoaziznlpor", "qhxepbshlrhoecdaodgpousbzfcqjxulatciapuftffahhlmxbufgjuxstfjvljybfxnenlacmjqoymvamphpxnolwijwcecgwbcjhgdybfffwoygikvoecdggplfohemfypxfsvdrseyhmvkoovxhdvoavsqqbrsqrkqhbtmgwaurgisloqjixfwfvwtszcxwktkwesaxsmhsvlitegrlzkvfqoiiwxbzskzoewbkxtphapavbyvhzvgrrfriddnsrftfowhdanvhjvurhljmpxvpddxmzfgwwpkjrfgqptrmumoemhfpojnxzwlrxkcafvbhlwrapubhveattfifsmiounhqusvhywnxhwrgamgnesxmzliyzisqrwvkiyderyotxhwspqrrkeczjysfujvovsfcfouykcqyjoobfdgnlswfzjmyucaxuaslzwfnetekymrwbvponiaojdqnbmboldvvitamntwnyaeppjaohwkrisrlrgwcjqqgxeqerjrbapfzurcwxhcwzugcgnirkkrxdthtbmdqgvqxilllrsbwjhwqszrjtzyetwubdrlyakzxcveufvhqugyawvkivwonvmrgnchkzdysngqdibhkyboyftxcvvjoggecjsajbuqkjjxfvynrjsnvtfvgpgveycxidhhfauvjovmnbqgoxsafknluyimkczykwdgvqwlvvgdmufxdypwnajkncoynqticfetcdafvtqszuwfmrdggifokwmkgzuxnhncmnsstffqpqbplypapctctfhqpihavligbrutxmmygiyaklqtakdidvnvrjfteazeqmbgklrgrorudayokxptswwkcircwuhcavhdparjfkjypkyxhbgwxbkvpvrtzjaetahmxevmkhdfyidhrdeejapfbafwmdqjqszwnwzgclitdhlnkaiyldwkwwzvhyorgbysyjbxsspnjdewjxbhpsvj"));
     
        System.out.println( binaryTOHEXA(26));*/
        int nums[] = {1};
        subSet(nums);
    }
}
