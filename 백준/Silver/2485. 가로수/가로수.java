import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] trees = new int[n];
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<n; i++) {
			trees[i] = Integer.parseInt(br.readLine());
			
		}
		
		Arrays.sort(trees);
		
		int gcd = 0;
		for(int i=1; i<n; i++) {
			int dist = trees[i] - trees[i-1];
			gcd = gcd(dist, gcd);
		}
		
		System.out.println((trees[n-1]-trees[0])/gcd+1 - (trees.length));
		
	}

	public static int gcd(int a, int b) {
		if(b==0) return a;
		return gcd(b, a%b);
	}
}

