import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MostStones {
    public static void dfs(int[][] stones, int index, boolean[] visited) {
        if(index == stones.length) return;
        visited[index] = true;
        for(int i=0; i<stones.length; i++) {
            if(visited[i] == false && stones[i][0] == stones[index][0] || stones[i][1] == stones[index][1]) {
                dfs(stones, i, visited);
            }
        }
    }
    
    public static void solver(int stones[][]) {
        boolean[] visited = new boolean[stones.length];
        for(int i=0; i<stones.length; i++) {
            visited[i] = false;
        }
        int group = 0;
        for(int i=0; i<stones.length; i++) {
            if(visited[i] == true) continue;
            dfs(stones,i,visited);
            group++;
        }
        System.out.println(stones.length - group);
    }
    public static void main(String[] args) {
        solver(new int[][] {{0,1},{1,0},{1,1}});
    }
}
