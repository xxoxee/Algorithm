import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//1. init
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1];
		int[] dp = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			dp[i] = 0;
		}
		
		//2. dp
		if(N==1) {
			dp[1] = arr[1];
			System.out.println(dp[1]);
			return;
		}
		
		dp[0] = 0;
		dp[1] = arr[1];
		dp[2] = arr[1]+arr[2];
		
		/*
		 * 1. i를 마시지 않는다 -> dp[i-1]
		 * 2. i-1을 마시지 않고(i-2까지 마심) i를 마신다 -> dp[i-2] + arr[i] 
		 * 3. i-2를 마시지 않고(i-3은 마심) i-1과 i를 마신다 -> dp[i-3] + arr[i-1] + arr[i]
		 */
		for(int i=3; i<=N; i++) {
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+arr[i], dp[i-3]+arr[i-1]+arr[i]));
		}
		
		//3. print result
		System.out.println(dp[N]);
	
	}

}
