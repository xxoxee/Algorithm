import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int M, N;
	static int[][] board;
	static boolean[][] visited;
	
	static int[] dr = {0,0,-1,1};
	static int[] dc = {1,-1,0,0};
	
	static boolean check = false;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] init = br.readLine().split(" ");
		M = Integer.parseInt(init[0]);
		N = Integer.parseInt(init[1]);
		board = new int[M][N];
		visited = new boolean[M][N];
		
		// 1. init
		for(int i=0; i<M; i++) {
			String[] line = br.readLine().split("");
			for(int j=0; j<line.length; j++) {
				board[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		// 2. dfs
		for(int i=0; i<N; i++) {
			if(board[0][i]==0) {
				dfs(0, i); 
			}
			if(check) break;
		}
		
		// 3. print result
		System.out.println(check ? "YES":"NO");
	}

	public static void dfs(int m, int n) {
		visited[m][n] = true;
		
		if(m==M-1) { //안쪽까지 침투됨 -> 종료
			check = true;
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nr = m + dr[i];
			int nc = n + dc[i];
			
			if(nr>=0 && nr<M && nc>=0 && nc<N) {
				if(board[nr][nc]==0 && !visited[nr][nc]) { //이동가능 여부 확인
					dfs(nr, nc);
				}
			}
		}
	}
}
