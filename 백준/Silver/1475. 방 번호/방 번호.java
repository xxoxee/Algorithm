import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		int[] n = new int[10];
		for(int i=0; i<s.length(); i++) {
			n[Integer.parseInt(s.charAt(i)+"")]++;
		}

		int max = -1;
		for(int i=0; i<n.length; i++) {
			int tmp = n[i];
			if(i==6 || i==9) {
				tmp = (int)Math.ceil((double)(n[6]+n[9])/2);
			}
			max = Math.max(max, tmp);
		}
		System.out.println(max);
		sc.close();
	}
}
