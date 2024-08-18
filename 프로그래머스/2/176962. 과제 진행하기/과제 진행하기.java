import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int cnt = 0;
         
        /*1.init*/
        List<Plan> list = new ArrayList<>();
        for(int i=0; i<plans.length; i++){
           list.add(new Plan(plans[i][0],plans[i][1],plans[i][2]));
        }
        
        Collections.sort(list, (p1, p2) -> p1.start - p2.start);
       
        //2.과제 시작
        Stack<Plan> wait = new Stack<>(); //멈춰둔 과제
        
        for(int i=0; i<list.size()-1; i++){
            Plan curP = list.get(i);
            Plan nextP = list.get(i+1);
        
            int timeDiff = nextP.start - curP.start;
            
            if(timeDiff < curP.remain) { //현 과제 종료불가 - 대기열 추가
                curP.remain -= timeDiff;
                wait.push(curP);
                continue;
            }
            //현 과제 종료가능
            answer[cnt++] = curP.name;
            timeDiff -= curP.remain;
            
            // 과제 종료 후 남은 시간만큼 대기과제 진행
            while(timeDiff > 0 && !wait.isEmpty()){
                Plan tmp = wait.pop();
                if(tmp.remain > timeDiff){
                    tmp.remain -= timeDiff;
                    wait.push(tmp);
                    break;
                }
                answer[cnt++] = tmp.name;
                timeDiff -= tmp.remain;
            }
        }
		answer[cnt++] = list.get(list.size()-1).name;
        
        //3.남은 과제들 최근에 멈춘 순으로 진행
        while(!wait.isEmpty()){
            answer[cnt++] = wait.pop().name;
        }    
        
        //4.result
        return answer;
    }
    
    public class Plan {
        String name;
        int start;
        int remain;
        
        Plan(String name, String start, String remain){
            this.name = name;
            String[] time = start.split(":");
            this.start = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
            this.remain = Integer.parseInt(remain);
        }
        
    }
}