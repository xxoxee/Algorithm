class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] arr = new int[rows][columns];
        int cnt = 1;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                arr[i][j] = cnt++;
            }
        }
        
        for(int k=0; k<queries.length; k++){
            int x1 = queries[k][0]-1;
            int y1 = queries[k][1]-1;
            int x2 = queries[k][2]-1;
            int y2 = queries[k][3]-1;
            
            int min = Integer.MAX_VALUE;
            int bef = arr[x1][y1];
            min = Math.min(min, bef);
            
            int cur = y1;
            while(cur+1<=y2){
                int aft = arr[x1][cur+1];
                arr[x1][cur+1] = bef;
                bef = aft;
                min = Math.min(min, bef);
                cur++;
            }
            
            cur = x1;
            while(cur+1<=x2){
                int aft = arr[cur+1][y2];
                arr[cur+1][y2] = bef;
                bef = aft;
                min = Math.min(min, bef);
                cur++;
            }
            
            cur = y2;
            while(cur-1>=y1){
                int aft = arr[x2][cur-1];
                arr[x2][cur-1] = bef;
                bef = aft;
                min = Math.min(min, bef);
                cur--;
            }
            
            cur = x2;
            while(cur-1>=x1){
                int aft = arr[cur-1][y1];
                arr[cur-1][y1] = bef;
                bef = aft;
                min = Math.min(min, bef);
                cur--;
            }  
            answer[k] = min;
        }
        
        return answer;
    }
    
}