import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] integ = new int[N];
		
		for(int i=0; i<N; i++) {
			integ[i] = sc.nextInt();
		}
		
		int find = sc.nextInt();
		
		//----
		int cnt = 0;
		for(int i=0; i<N; i++) {
			if(integ[i]==find)
				cnt++;
		}
		System.out.println(cnt);
	}

}
