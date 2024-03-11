import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int[] arr = new int[9];
	static int[] tmpArr = new int[7];
	static int[] result = new int[7];
	static boolean[] visited = new boolean[9];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<9; i++) {
			arr[i] = sc.nextInt();
		}
		
		dfs(0);
		
		Arrays.sort(result);
		for(int i=0; i<result.length; i++) {
			System.out.println(result[i]);
		}
		sc.close();
	}
	
	public static void dfs(int depth) {
		if(depth==7) {
			int sum = 0;
			for(int i=0; i<tmpArr.length; i++) {
				sum += tmpArr[i];
			}
			if(sum==100) {
				result = Arrays.copyOf(tmpArr,tmpArr.length);
			}
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				tmpArr[depth] = arr[i];
				dfs(depth+1);
				visited[i] = false;		
			}
		}
	}
}
