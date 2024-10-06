import java.util.HashMap;

public class TrieHash {
    static class Trie{
        Trie[] child;
        boolean eow;
        Trie() {
            child = new Trie[26];
            for(int i=0; i<26; i++) {
                child[i] = null;
            }
            eow = false;
        }
    }
    public static Trie root = new Trie();
    public static void buildTrie(String word) {
        Trie currTrie  = root;
        for(int i=0; i<word.length(); i++) {
            int idx = (word.charAt(i) - 'a');
            if(currTrie.child[idx] == null ) {
                currTrie.child[idx] = new Trie();
            }
            
            currTrie = currTrie.child[idx];
        }
        currTrie.eow = true;
    }
    public static void findstring(String word) {
        int count = 0;
        Trie currTrie =  root;
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if(currTrie.child[(ch -'a')] == null) {
                
                count++;
            } else {
                currTrie = currTrie.child[ch -'a'];
            }
            if(currTrie.eow == true) {
            
                currTrie = root;
            } 
        }
        System.out.println(count);
    }
    public static void longestprefix(int[] arr1, int arr2[]) {
        
    }
    public static void main(String[] args) {
        String[] words = {"leetcode","leet","code"};
        for(String word : words) {
            buildTrie(word);
        }
        findstring("leetscode");
    }    
}
