import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.lang.Math;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

	    int a, b, c;
	    a = Integer.parseInt(st.nextToken());
	    b = Integer.parseInt(st.nextToken());
	    c = Integer.parseInt(st.nextToken());
		
		//----
		int result = 0;
		
		if(a==b && b==c) {
			//1. 3개의 눈 일치
			result = 10000 + a * 1000;
		} else if(a==b || b==c || a==c) {
			//2. 2개의 눈 일치
			if(a==b || a==c) {
				result = 1000 + a * 100;
			} else {
				result = 1000 + b * 100;
			}
		} else {
			//3. 모두 다른 눈
			result = Math.max(a, Math.max(b, c)) * 100;
		}
		
		System.out.println(result);
	}
}
