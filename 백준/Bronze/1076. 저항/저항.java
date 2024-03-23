import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("black");
		list.add("brown");
		list.add("red");
		list.add("orange");
		list.add("yellow");
		list.add("green");
		list.add("blue");
		list.add("violet");
		list.add("grey");
		list.add("white");
		
		Scanner sc = new Scanner(System.in);
		int c1 = list.indexOf(sc.nextLine());
		int c2 = list.indexOf(sc.nextLine());
		int c3 = list.indexOf(sc.nextLine());
		
		String result = String.valueOf((c1*10+c2)*(long)Math.pow(10, c3));
		System.out.println(result);
	}
}
