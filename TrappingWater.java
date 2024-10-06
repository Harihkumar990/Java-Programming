import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TrappingWater {
    public static int solver(int[] heights) {
        int sum = 0;
        int[] leftMax = new int[heights.length];
        int[] righttMax = new int[heights.length];
        leftMax[0] = heights[0];
        righttMax[heights.length-1] = heights[heights.length-1];
        for(int i=1,j=heights.length-2 ;i<heights.length && j>=0; i++,j--) {
            int Rightmax = Math.max(righttMax[j+1],heights[j]);
            int Lefttmax = Math.max(leftMax[i-1],heights[i]);
            leftMax[i] = Lefttmax;
            righttMax[j] = Rightmax;
        }
        for(int i=0 ;i<heights.length; i++) {
            int min = Math.min(leftMax[i],righttMax[i]);
            sum = sum + (min - heights[i]);
        }
        
        return sum;
    } 
    public static int countSeniors(String[] details) {
        int count = 0;
        for(String str : details) {
            String temp = str.substring(11,str.length()-2);
            int age = Integer.parseInt(temp);
            System.out.println(temp);
            if(age>60) {
                count++;
            }
           
        }   

        return count;
    }
    public static List<List<String>>  groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hash = new HashMap<>();
        for(int i=0; i<strs.length; i++) {
            int[] tempArr = new int[26];
            for(int j=0; j<strs[i].length(); j++) {
                tempArr[strs[i].charAt(j) - 'a']++;
            }
            StringBuilder tempString = new StringBuilder();
            for(int k=0; k<26; k++) {
                while(tempArr[k] !=0 ) {
                    tempString.append(""+(char)k+'a');
                    tempArr[k]--;
                }
                
            }
            if(hash.containsKey(tempString.toString())) {
                List<String> tempList = hash.get(tempString.toString());
                tempList.add(strs[i]);
                
                hash.replace(tempString.toString(),tempList);

            }else{
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                hash.put(tempString.toString(),list);
            }

        } 
        List<List<String>> result = new ArrayList<>();

        for(String t : hash.keySet()) {
            result.add(hash.get(t));
        }
        return result;

    }
    public static void main(String[] args) {
       /*  int[] heights = {4,2,0,3,2,5};
        System.out.println(solver(heights));
        System.out.println("abc" == "cba"); 
        String details[] = {"7868190130M7522","5303914400F9211","9273338290F4010"};
        countSeniors(details);*/
        String[] newString = {"dgggggggggggd","dddddddddddddg"};
        System.out.println(groupAnagrams(newString).toString());
    }
}
