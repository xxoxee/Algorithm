import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        int score = 0;
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<name.length; i++){
            map.put(name[i], yearning[i]);
        }
        
        for(int i=0; i<photo.length; i++){
            for(int j=0; j<photo[i].length; j++){
                answer[i] += map.getOrDefault(photo[i][j], 0);
            }
        }
        return answer;
    }
}
/* 시간 복잡도 탈? 
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        int score = 0;
        
        for(int i=0; i<photo.length; i++){
            score = 0;
            for(int j=0; j<photo[i].length; j++){
                int idx = findIndex(name, photo[i][j]);
                if(idx>-1 && i<yearning.length){
                    score += yearning[idx];
                }
            }
            answer[i] = score;
        }
        return answer;
    }
    
    public int findIndex(String[] names, String name){
        for(int i=0; i<names.length; i++){
            if(names[i].equals(name)) return i;
        }
        return -1;
    }
}
*/