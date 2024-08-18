class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0){
            int n1 = storey % 10;
            int n10 = (storey / 10) % 10;
            
            if(n1 < 5){
                answer += n1; //내림
                
            } else if(n1==5){
                answer += n1;
                if(n10 >= 5) storey += 10; //10의자리 확인해서 올림/내림  
               
            } else {
                answer += (10-n1); //올림
                storey += 10;
            }
            storey = storey / 10;
        }
        return answer;
    }
}