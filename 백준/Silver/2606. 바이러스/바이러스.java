import java.util.Scanner;

public class Main {
	static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int row = sc.nextInt();
		
		//1. init
		int[][] arr = new int[N][N];
		boolean[] visited = new boolean[N];
		
		for(int i=0; i<row; i++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		//2. call dfs
		dfs(arr, visited, 0);
		
		//3. result
		System.out.println(count-1);
		
	}

	public static void dfs(int[][] arr, boolean[] visited, int i) {
		visited[i] = true;
		count += 1;
		
		for(int k=0; k<arr.length; k++) {
			if(arr[i][k]==1 && !visited[k]) {
				dfs(arr, visited, k);
			}
		}
	}
}
