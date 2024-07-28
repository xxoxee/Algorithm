import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        /*1
        for(int i=0; i<weights.length-1; i++){
            for(int j=i+1; j<weights.length; j++){
                if(weights[i]==weights[j]) {
                    answer++;
                } else {
                    int a = weights[i]<weights[j]? weights[i] : weights[j];
                    int b = weights[i]<weights[j]? weights[j] : weights[i];
                    
                    if((b*2 == a*3) || (b*2 == a*4) || (b*3 == a*4)) {
                        answer++;
                    }
                }
            }
        }
        */
        /*2*/
        Arrays.sort(weights);
        
        Map<Double, Integer> hm = new HashMap<>(); //<weight, 해당 weight 가진 사람 수>
        for(int i=0; i<weights.length; i++){
            double a = weights[i] * 1.0; //같은 거리
            double b = weights[i] * 2.0 / 3.0;
            double c = weights[i] * 2.0 / 4.0;
            double d = weights[i] * 3.0 / 4.0;
            
            if(hm.containsKey(a)) answer += hm.get(a);
            if(hm.containsKey(b)) answer += hm.get(b);
            if(hm.containsKey(c)) answer += hm.get(c);
            if(hm.containsKey(d)) answer += hm.get(d);
            
            hm.put(a, hm.getOrDefault(a,0)+1);           
        }
        
        return answer;
    }
}