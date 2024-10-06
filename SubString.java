import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class SubString {
    @SuppressWarnings("unchecked")
    public static void solver(String s) {
        boolean[][] ispalindrome = new boolean[s.length()][s.length()];
        @SuppressWarnings("rawtypes")
        List<List<String>> result = new ArrayList();
        for(int index = 0; index < s.length(); index++) {
            List<String> temp = new ArrayList<>(); 
            for(int i=0 , j=index; j<s.length(); j++) {
                if(index == 0) {
                    temp.add(s.charAt(j)+"");
                    ispalindrome[i][j] = true;
                } else if(index == 1) {
                    if(s.charAt(i) == s.charAt(j)) {
                        temp.add(s.substring(i, j+1));
                        ispalindrome[i][j] = true;
                    } 
                } else {
                    if(s.charAt(i) == s.charAt(j)) {
                        ispalindrome[i][j] = true;
                        temp.add(s.substring(i,j+1));
                        
                        if(ispalindrome[i+1][j-1] == false) {
                            ispalindrome[i][j] = false;
                            temp.remove(s.substring(i, j+1));
                        } 
                    } else if(ispalindrome[j][j]) {
                        temp.add(s.charAt(j)+"");
                    }
                }
            }
            result.add(temp);
        }
        System.out.println(result.toString());
    }
    public static boolean ispalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
    public static List<List<String>> ans;
    public static void palidromePArtitioning(String s, List<String> helper,int idx) {
        if(s.length() == 0) {
            ans.add(new ArrayList<>(helper));
            return;
        }
        for(int i=0; i<s.length(); i++) {
            String palindrome = s.substring(0, i+1);
            String left = s.substring(i+1,s.length());
            if(ispalindrome(palindrome)) {
                helper.add(palindrome);
                palidromePArtitioning(left, helper, idx);
                helper.removeLast();
            }
        }
    }
    public static void longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> hash = new HashMap<>();
        for(int num : nums) {
            hash.put(num, true);
        }
        for(int key : hash.keySet()) {
            int value = key - 1;
            if(hash.containsKey(value)) {
                hash.replace(key, false);
            }
        }
        int totalMax = 0;
        for(int key : hash.keySet()) {
            int currMax = 1;
            int num = 1;
            while(hash.get(key)) {
                if(hash.containsKey(key+num)) {
                    currMax++;
                } else {
                    break;
                }
                num++;
            }
            totalMax = Math.max(currMax, totalMax);
        }
        System.out.println(totalMax);

       
    }
    public static boolean ispaalindrome(String s) {
        
        int l = 0;
        int r = s.length() - 1;
        while(l < r) {
            char lowChar = s.charAt(l);
            char highChar = s.charAt(r);
            if(!Character.isDigit(lowChar) && !Character.isLetter(lowChar) ) {
                
                l++;
                continue;
            }
            if(!Character.isDigit(highChar) && !Character.isLetter(highChar) ) {
                r--;
               
                continue;
            }
            if((Character.isDigit(lowChar) && Character.isLetter(highChar)) || (Character.isDigit(highChar) && Character.isLetter(lowChar))){
               
                return false;
            }
            if( Character.isLetter(highChar) &&  Character.isLetter(lowChar) && (Character.toLowerCase(lowChar) != Character.toLowerCase(highChar)) ) {
               
                return false;
            }
             else if(Character.isDigit(highChar) &&  Character.isDigit(lowChar) && ((int)(lowChar - '0') != (int)(highChar - '0'))) {
         
                return false;
            }
            l++;
            r--;
            
        }
        return true;
    }
    public static int maxProfit(int[] prices) {
        if(prices.length == 1 || prices.length == 0) {
            return 0;
        }
        int tempNum = prices[0];
        int maxPrice = 0;
        for(int i=1; i<prices.length; i++) {
            if(prices[i] - tempNum <= 0) {
                tempNum = prices[i];
                continue;
            } else {
                maxPrice = Math.max(maxPrice,prices[i]-tempNum);
            }
        }
        return maxPrice;
    }
    public static void main(String[] args) {
        //solver("aab");
       /*  ans = new ArrayList<>();
        palidromePArtitioning("aab", new ArrayList<>(),0);
        System.out.println(ans.toString()); 
        longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1});*/
        //System.out.println(ispaalindrome( "  "));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
}
