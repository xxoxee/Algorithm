import java.util.Scanner;

public class Main{

	static String[][] arr;
	static boolean[][] visited; 
	
	static int N;
	static int M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //row
		M = sc.nextInt(); //col
		
		arr = new String[N][M];
		visited = new boolean[N][M];
		
		//1. init
		for(int i=0; i<N; i++) {
			String input = sc.next();
			for(int j=0; j<M; j++) {
				arr[i][j] = input.charAt(j)+"";
			}
		}
		
		//2. call dfs
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0;  j<M; j++) {
				if(!visited[i][j]) {
					dfs(i, j, arr[i][j]);
					cnt++;
				}
			}
		}
		
		//3. Result
		System.out.println(cnt);
	}
	
	public static void dfs(int i, int j, String ch) {
		visited[i][j] = true;
		
		if(ch.equals("|") && i+1<N && arr[i+1][j].equals(ch)) {
			dfs(i+1, j, ch);
		}
		if(ch.equals("-") && j+1<M && arr[i][j+1].equals(ch)) {
			dfs(i, j+1, ch);
		}
	}

}
