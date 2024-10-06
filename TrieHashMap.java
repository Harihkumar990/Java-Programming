import java.util.Arrays;
import java.util.HashMap;

public class TrieHashMap {
    static class Trie{
        HashMap<Integer,Trie> hash;
        boolean eow;
        Trie() {
            hash = new HashMap<>();
            eow = false;
        }
    }
    public static Trie root = new Trie();
    public static void buildtrie(String value) {
        Trie currTrie = root;
        int key = 0;
        
        for(int i=0; i<value.length(); i++) {
            key = value.charAt(i) - '0';
            
            if(!currTrie.hash.containsKey(key)) {
                currTrie.hash.put(key, new Trie());
            } 
            currTrie = currTrie.hash.get(key);
          
            

        }
        currTrie.eow = true;
       
    }
     public static void longestprefix(int arr1[]) {
        
        int maxcount = 0;
     
       
        for(int num : arr1) {
            int count = 0;
            String value = Integer.toString(num);
            Trie currTrie = root;
            for(int i=0; i<value.length(); i++){
               
                int key = value.charAt(i) - '0';
              
                if(!currTrie.hash.containsKey(key)) {
                    
                    break;
                }
                currTrie = currTrie.hash.get(key);
              
                count++;
                
            }   
            maxcount = Math.max(maxcount,count); 
        }
        System.out.println(maxcount);
    } 
    public static void sumPrefixScore(String[] words) {
        HashMap<String , Integer> hash = new HashMap<>();
        for(String word : words) {
            int index = 0;
            
            while(index < word.length()) {
                String substr = word.substring(0, index+1);
                hash.put(substr, hash.getOrDefault(substr, 0)+1);
                index++;
            }


        }
        int[] ans = new int[words.length];
        int idx = 0;
        for(String word : words) {
            int index = 0;
            int count = 0;    
            while(index < word.length()) {
                String sub = word.substring(0, index+1);
                int val = hash.get(sub);
                
                count = count + val;
                index++;
            }
            ans[idx] = count;
            idx++;


        }
        System.out.println(Arrays.toString(ans));
        System.out.println(hash);
    }
    public static void main(String[] args) {
       /*  int[] arr1 = {1,2,3};
        int[] arr2 = {4,4,4};
        for(int num : arr2) {
            
            buildtrie(Integer.toString(num));
        }
        longestprefix(arr1);  */
        sumPrefixScore(new String[]{"dbhiwxxr","hyqbpabh","hyqlgnnxiy","wosbckxrb","wosbckxmfq"});
    }
}
