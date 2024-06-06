import java.util.Scanner;

public class Main {

	static int[][] arr;
	static boolean[] visited;
	static int N;
	static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int row = sc.nextInt();
		
		//1. init
		arr = new int[N][N];
		visited = new boolean[N];
		
		for(int i=0; i<row; i++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		//2. call dfs
		dfs(0);
		
		//3. result
		System.out.println(count-1);
		
	}

	public static void dfs(int i) {
		visited[i] = true;
		count += 1;
		
		for(int k=0; k<N; k++) {
			if(arr[i][k]==1 && !visited[k]) {
				dfs(k);
			}
		}
	}
}
