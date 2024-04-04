import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int s = sc.nextInt();
		int m = sc.nextInt();
		
		if(s<1024) {
			System.out.println("No thanks");
			return;
		}
		
		if(s-1023 > m) {
			System.out.println("Impossible");
			return;
		}
		
		// 1.Integer.toBinaryString() 이용
		String needToBit = Integer.toBinaryString(s-1023);
		String mToBit = Integer.toBinaryString(m);
		
		for(int i=1; i<=needToBit.length(); i++) {
			if(needToBit.charAt(needToBit.length()-i)=='1') {
				if(mToBit.charAt(mToBit.length()-i)=='0') {
					System.out.println("Impossible");
					return;
				}
			}
		}
		System.out.println("Thanks");
		
	}
}
