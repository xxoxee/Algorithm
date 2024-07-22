import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int N;
	static int[][] arr;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visited = new boolean[N][N];
			
			// start
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());

			Node start = new Node(row, col, 0);
			
			//end
			st = new StringTokenizer(br.readLine());
			int row2 = Integer.parseInt(st.nextToken());
			int col2 = Integer.parseInt(st.nextToken());

			Node end = new Node(row2, col2, 0);
			
			System.out.println(bfs(start, end));
		}
		
	}
	
	public static int bfs(Node start, Node end) {
		 Queue<Node> queue = new LinkedList<>();
		 queue.add(start);
		 visited[start.row][start.col] = true;

		 while (!queue.isEmpty()) {
			 Node cur = queue.poll();
    	
			 if(cur.row==end.row && cur.col==end.col) // 목적지 도착 시 return
				 return cur.cnt;

			 for (int i = 0; i < 8; i++) {
				 int nRow = cur.row + dx[i];
				 int nCol = cur.col + dy[i];
			
				 if (nRow>=0 && nRow<N && nCol>=0 && nCol<N) {
					 if (!visited[nRow][nCol]) {
						queue.add(new Node(nRow, nCol, cur.cnt+1));
						visited[nRow][nCol] = true;
			          }
			     }
			 }
		 }
		 return -1;
	}
		
	
	static class Node {
		int row;
		int col;
		int cnt;

		Node(int row, int col, int cnt) {
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}
	}
	
}
