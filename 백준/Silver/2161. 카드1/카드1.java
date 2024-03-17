import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i=0; i<n; i++) {
			queue.add(i+1);
		}
		
		List<Integer> list = new ArrayList<>();
		while(queue.size()>0) {
			list.add(queue.poll());
			if(queue.size()<=0) break;
			queue.add(queue.poll());
		}
		
		for(int i : list) {
			System.out.print(i+ " ");
		}
	}

}
