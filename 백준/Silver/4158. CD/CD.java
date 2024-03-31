import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0){
                break;
            }
            
            Set<Integer> set = new HashSet<>();
            int cnt = 0;
            
            for(int i = 0 ; i < n ; i++){
                set.add(Integer.parseInt(br.readLine()));
            }
            
            for(int i = 0 ; i < m ; i++){
                if(set.contains(Integer.parseInt(br.readLine()))){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    
    }

}
