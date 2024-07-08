import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//1. init
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = Integer.MAX_VALUE;
		}
		
		//2. dp
		dp[0] = 0;
		for(int i=0; i<N; i++) {
			if(dp[i] == Integer.MAX_VALUE) //한 번도 방문한 적 없는 위치
				continue; 
			int jump = arr[i];
			for(int j=1; j<=jump; j++) {
				if(i+j<N) {
					dp[i+j] = Math.min(dp[i]+1, dp[i+j]);
				}
			}
		}
		
		//3. print result
		System.out.println(dp[N-1]==Integer.MAX_VALUE?-1:dp[N-1]);
	}

}
