import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int n = N;
		int newNum = -1;
		int count = 0;

		while(newNum!=N) {
			count++;
			if(count>1) n = newNum;
			
			int temp = 0;
			if(String.valueOf(n).length()==2) 
				temp = n/10 + n%10; // 각 자리 수 합
			else 
				temp = n;

			newNum = Integer.parseInt(n%10 +""+ temp%10);
		}
		
		System.out.println(count);
		sc.close();
	}

}
