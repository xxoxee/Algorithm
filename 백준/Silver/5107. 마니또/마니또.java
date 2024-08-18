import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int idx = 1;
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N==0) return;
			
			//1. init
			HashMap<String, String> hm = new HashMap<>();
			List<String> list = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				String from = st.nextToken();
				String to = st.nextToken();
				hm.put(from, to);
				list.add(from);
			}
			
			//2. 연결고리 확인
			int cnt = 0; //연결 고리 수
			for(String start : list) {
				String node = hm.get(start);
				
				while(true) {
					node = hm.get(node);
					if(node == null) break;
					if(node.equals(start)) {
						cnt++;
						hm.keySet().remove(node);
						break;
					}
				}
			}
			
			//3.print result
			System.out.println(idx + " "+ cnt);
			idx++;
		}
	}
}
