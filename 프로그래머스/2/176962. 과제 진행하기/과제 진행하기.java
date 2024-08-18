import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[][] array = {{"science", "12:40", "50"},
                {"music", "12:20", "40"},
                {"history", "14:00", "30"},
                {"computer", "12:30", "100"}};
        String[] res = solution(array);

        for (String r : res) {
            System.out.print(r);
        }
    }

    public static String[] solution(String[][] plans) {

        ArrayList<String> answer = new ArrayList<>();

        try {
            List<Node> plan_list = new ArrayList<>();

            for (String[] p : plans) {
                String[] time = p[1].split(":");

                plan_list.add(new Node(p[0], (Integer.parseInt(time[0])*60)+Integer.parseInt(time[1]),
                        Integer.parseInt(p[2])));
            }

            plan_list.sort((h1, h2) -> h1.start - h2.start);

            Stack<Node> stack = new Stack<>();

            for (int i = 0; i < plan_list.size() - 1; i++) {
                Node node = plan_list.get(i);
                long t = node.start;
                long t2 = plan_list.get(i + 1).start;

                long diff = t2-t;

                if (diff < node.playtime) {
                    stack.push(new Node(node.name, node.playtime - diff));
                } else if (diff > node.playtime) {
                    answer.add(node.name);
                    diff = diff - node.playtime;

                    while (diff > 0 && !stack.empty()) {
                        Node tmp = stack.pop();
                        if (diff < tmp.playtime) {
                            stack.push(new Node(tmp.name, tmp.playtime - diff));
                            diff = 0;
                        } else if (diff >= tmp.playtime) {
                            answer.add(tmp.name);
                            diff = diff - tmp.playtime;
                        }
                    }
                } else {
                    answer.add(node.name);
                }
            }
            answer.add(plan_list.get(plan_list.size() - 1).name);

            while(!stack.empty()){
                Node n = stack.pop();
                answer.add(n.name);
            }


        } catch (Exception e) {
            System.out.print(e);
        }
        return answer.toArray(new String[answer.size()]);
    }
}

class Node {
    String name;
    int start;
    long playtime;

    Node(String name, int start, long playtime) {
        this.name = name;
        this.start = start;
        this.playtime = playtime;
    }

    Node(String name, long playtime) {
        this.name = name;
        this.playtime = playtime;
    }
}