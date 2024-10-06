import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class StringClass {
    public static void solver(String s1, String s2) {
       HashMap<String,Integer> helper = new HashMap<>();
       String temp = s1+" "+s2;
       String[] array = temp.split(" ");
       System.out.println(Arrays.toString(array));
       for(String word : array) {
            helper.put(word, helper.getOrDefault(word, 0) + 1);
       }
       List<String> ans = new ArrayList<>();
       for(String key : helper.keySet()) {
            if(helper.get(key) == 1) {
                ans.add(key);
            }
       }
       String[] result = new String[ans.size()];
       for(int i=0; i<ans.size(); i++) {
            result[i] = ans.get(i);
       }
       System.out.println(Arrays.toString(result));

         
    }
   
    public static void main(String[] args) {
        solver("this is class","this is room");
    }
}
