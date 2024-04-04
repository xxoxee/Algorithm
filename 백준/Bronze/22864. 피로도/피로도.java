import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(); //한 시간 일할 경우 쌓이는 피로도
		int b = sc.nextInt(); //한 시간 일할 경우 처리하는 일
		int c = sc.nextInt(); //한 시간 쉴 경우 줄어드는 피로도
		int m = sc.nextInt(); //피로도 최대치
		
		int time = 0;
		int p = 0; //피로도
		int work = 0; //한 일
		
		if(a>m) {
			System.out.println(0);
			return;
		}
		
		while(true) {
			if(time==24) break;
			if(p+a<=m) {
				p+=a;
				work+=b;
			}else {
				if(p-c<0) p=0;
				else p-=c;
			}
			time++;
		}
		System.out.println(work);
	}

}
