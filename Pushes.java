import java.util.*;
import java.util.Collections;

public class Pushes {
    public static int minimumPushes(String word) {
        int[] frequency = new int[26];
        for(char character : word.toCharArray()) {
            frequency[character - 'a']++;
        }    
        Integer[] sorted = new Integer[26];
        for(int i=0; i<frequency.length; i++) {
            sorted[i] = frequency[i];
        }
        Arrays.sort(sorted,Collections.reverseOrder());
        int totalpress = 0;
        for(int i=0; i<26; i++) {
            if(sorted[i] ==0 ) break;
            totalpress += (i/8 + 1 ) * sorted[i];
        }
        
        return totalpress;
    }
    public static void main(String[] args) {
        String word = "abcd";
       System.out.println( minimumPushes(word));
    }
}
