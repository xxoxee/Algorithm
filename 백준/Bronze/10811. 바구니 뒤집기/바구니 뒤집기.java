import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		//----
		int[] baskets = new int[n+1];
		for(int i=0; i<baskets.length; i++) {
			baskets[i] = i;
		}
		
		for(int i=0; i<m; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();

			while(from < to) {
				int tmp = baskets[from];
				baskets[from] = baskets[to];
				baskets[to] = tmp;
				from++;
				to--;
			}
		}
		
		for(int i=1; i<baskets.length; i++) {
			System.out.print(baskets[i]+ " ");
		}
	}

}
