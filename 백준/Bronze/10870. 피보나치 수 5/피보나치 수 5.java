import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//----
		int result = 0;
		
		List<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(1);
		
		for(int i=0; i<=n; i++) {
			if(i==0) {
				result = 0;
			} else if(i==1) {
				result = 1;
			} else {
				result = list.get(i-1) + list.get(i-2);
				list.add(result);
			}
		}
			
		System.out.println(result);
	}
}
