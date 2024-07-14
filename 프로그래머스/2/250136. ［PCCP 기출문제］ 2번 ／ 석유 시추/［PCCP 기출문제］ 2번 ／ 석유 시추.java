import java.util.*;

class Solution {
    boolean[][] visited;
    int[] mRow = {0, 0, 1, -1};
    int[] mCol = {-1, 1, 0, 0};
    Map<Integer,Integer> map = new HashMap<>();
    
    public int solution(int[][] land) {
        int max = 0;
        visited = new boolean[land.length][land[0].length];
        
        for(int row=0; row<land.length; row++) {
            for(int col=0; col<land[0].length; col++) {
                if(land[row][col]==1 && !visited[row][col]){
                    bfs(land, row, col);
                }
            }
        }
        
        for(Integer key : map.keySet()){
            max = max>map.get(key)? max : map.get(key);
        }
        
        return max;
    }
    
    
    public int bfs(int[][] land, int row, int col){
        int cnt = 1;
        
        Queue<Pos> q = new LinkedList<Pos>();
        Set<Integer> set = new HashSet<>();
        visited[row][col] = true;
        q.add(new Pos(row, col));
        set.add(col);
        
        while(!q.isEmpty()){
            Pos p = q.poll();
            for(int i=0; i<4; i++){
                int nRow = p.row + mRow[i];
                int nCol = p.col + mCol[i];
                
                if(nRow>=0 && nRow<land.length && nCol>=0 && nCol<land[0].length){
                    if(land[nRow][nCol]==1 && !visited[nRow][nCol]){
                        visited[nRow][nCol] = true;
                        set.add(nCol);
                        q.add(new Pos(nRow, nCol));
                        cnt++;
                    }
                }
            }
        }
          
        for(int i: set){
           map.put(i, map.getOrDefault(i, 0)+cnt);  
        }
        return cnt;
    }
    
    
    class Pos{
        int row;
        int col;
        
        Pos(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}

