import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{

	static int N, M;
	static int[][] board;

	static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
	static int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] init = br.readLine().split(" ");
		N = Integer.parseInt(init[0]);
		M = Integer.parseInt(init[1]);
		board = new int[N][M];
		
		
		// 1. init
		for(int i=0; i<N; i++) {
			String[] line = br.readLine().split(" ");
			for(int j=0; j<line.length; j++) {
				board[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		//2. bfs
		int max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(board[i][j] != 1) {
					max = Math.max(max, bfs(i,j));
				}
			}
		}
		
		//3. print max
		System.out.println(max);
	}
	
	public static int bfs(int row, int col) { // 현 위치에서 인접한 곳부터 탐색
		Queue<Pos> q = new LinkedList<Pos>();
		boolean[][] visited = new boolean[N][M];
		visited[row][col] = true;
		q.add(new Pos(row, col, 0));
		
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			for(int i=0; i<8; i++) {
				int nn = pos.n + dx[i];
				int nm = pos.m + dy[i];
				if(nn>=0 && nn<N && nm>=0 && nm<M && !visited[nn][nm]) {
					if(board[nn][nm]==0) {
						visited[nn][nm] = true;
						q.add(new Pos(nn, nm, pos.count+1));
					} else {
						return pos.count+1;
					}
				}
			
			}
		}
		return -1; // 상어 못만남
	}
	
	static class Pos {
		int n;
		int m;
		int count;
		
		Pos(int n, int m, int count){
			this.n = n;
			this.m = m;
			this.count = count;
		}
	}

}
