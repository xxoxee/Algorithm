import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int M, N;
	static int[][] board;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
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
		boolean flag = false;
		for(int i=0; i<N; i++) {
			if(board[0][i]==0) {
				if(dfs(0, i)) {
					flag = true;
					break;
				}
			}
		}
		
		// 3. print result
		System.out.println(flag?"YES":"NO");
	}

	public static boolean dfs(int m, int n) {
		boolean result = false;
		
		visited[m][n] = true;
		if(m==M-1) return true; //안쪽까지 침투됨
		
		
		for(int i=0; i<4; i++) {
			int nx = m + dx[i];
			int ny = n + dy[i];
			
			if(nx>=0 && nx<M && ny>=0 && ny<N) {
				if(board[nx][ny]==0 && !visited[nx][ny]) { //이동 가능
					if(dfs(nx, ny)) {
						result = true;
						break;
					}
				}
			}
		}
		return result;
	}
}
