package template;

import java.util.*;

public class Topo {
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] in = new int[100001];
    static int num;
    public static void add(int a, int b){
        graph.get(a).add(b);
        in[b]++;
    }

    public static void topoSort(){
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            if(in[i] == 0)
                queue.offer(i);
        }
        while (!queue.isEmpty()){
            int cur_node = queue.poll();
            res.add(cur_node);
            List<Integer> edges = graph.get(cur_node);
            for (int i = 0; i < edges.size(); i++) {
                int next_node = edges.get(i);
                if(--in[next_node] == 0)
                    queue.offer(next_node);
            }
        }
        if(res.size() != num)
            return;
        else{
            for (int i = 0; i < res.size(); i++) {
                System.out.print((res.get(i) + 1 )+ " ");
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            add(a, b);
        }
        num = n;
        topoSort();
    }
}
