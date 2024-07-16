import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        //1. init
        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            //2. bfs
            System.out.println(BFS(new Comp(S, T, 0)));

        }
    }
	
    public static int BFS(Comp comp) {
        Queue<Comp> q = new LinkedList<>();
        q.add(comp);

        while(!q.isEmpty()) {
            Comp c = q.poll();
            int cnt = c.cnt;
            
            if (c.S == c.T) { //같으면 횟수 출력
                return cnt;
            }
            if (c.S > c.T) { //S가 커지면 해당 경우는 더 이상 확인하지 않음
                continue;
            }
            
            q.add(new Comp(c.S +1, c.T, cnt+1));
            q.add(new Comp(c.S *2, c.T +3, cnt+1));
        }
        return -1;
    }
    
    static class Comp {
        int S;
        int T;
        int cnt;
        
        Comp (int S, int T, int cnt) {
            this.S = S;
            this.T = T;
            this.cnt = cnt;
        }
    }
}
