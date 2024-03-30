class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];       
        int sx=0, sy=0;
        int y_len = park.length;
        int x_len = park[0].length();
        
        // 시작점 찾기
        for(int i=0; i<park.length; i++){
            int idx = park[i].indexOf('S');
            if(idx > -1){
                sx = idx;
                sy = i;
                break;
            }
        }
        
        //명령 수행
        for(String route : routes){
            String[] cmd = route.split(" ");
            String op = cmd[0];
            int n = Integer.parseInt(cmd[1]);
            
            int nx = sx; 
            int ny = sy;
            
            boolean isOk = true;
            for(int i=0; i<n; i++){
                if(op.equals("N"))
                    ny--;
                else if(op.equals("S"))
                    ny++;
                else if(op.equals("W"))
                    nx--;
                else if(op.equals("E"))
                    nx++;

                if(nx >= 0 && nx <x_len && ny >= 0 && ny < y_len){ // 범위체크
                    if(park[ny].charAt(nx) == 'X') { // 장애물체크 
                        isOk = false;
                        break;
                    }
                } else {
                    isOk = false;
                    break;
                } 
            }

            if(isOk){
                sx = nx;
                sy = ny;
            }  
        }
        
        answer[0] = sy;
        answer[1] = sx;
                
        return answer;
    }
}