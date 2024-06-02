import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> st = new Stack<Character>();
		int cmd = 1;
		int count = 0;
		while(true) {
			String line = br.readLine();
			//초기화
			st.clear();
			count = 0;
			
			if(line.contains("-")) 
				break;
			
			for(int i=0; i<line.length();i++) {
				if(line.charAt(i)=='{') {
					st.add('{');
				}else {
					if(!st.isEmpty()) {
						st.pop();
					}else { // '}' -> '{' 변경
						count++;
						st.add('{');
					}
				}
			}
			if(!st.isEmpty()) { // '{' 남은 경우, count 증가
				count += st.size()/2;
			}
			sb.append(cmd+". "+count+"\n");
			cmd++;
		}
		System.out.println(sb);
	}
}
