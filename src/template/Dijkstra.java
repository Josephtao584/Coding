package template;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * 优先队列实现Dijkstra
 * 输入：点数量、边集、对应权重、开始点、结束点
 * 输出：start到end的最短路径
 * O(nlogn)
 */
class Dijkstra {
    class Node{
        int index;
        int val;
        Node(int index, int val){
            this.index = index;
            this.val = val;
        }
    }
    public double minRood(int n, int[][] edges, int[] val, int start, int end) {
        if(n == 0)
            return 0;
        List<List<int []>> g = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        //构图
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            g.get(edge[0]).add(new int[]{i, edge[1]});
            g.get(edge[1]).add(new int[]{i, edge[0]});
        }


        boolean[] visited = new boolean[n];
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> (o1.val - o2.val));
        queue.offer(new Node(start, 0));
        while (!queue.isEmpty()){           //每趟取一个权值最小的节点，然后把所有未遍历的子节点加进来
            Node cur = queue.poll();
            int cur_index = cur.index;
            int cur_val = cur.val;
            visited[cur_index] = true;
            if(cur_index == end)
                return cur_val;
            for (int[] next : g.get(cur_index)) {
                int next_val = val[next[0]];
                int next_index = next[1];
                if(visited[next[1]])
                    continue;
                queue.offer(new Node(next_index, next_val + cur_val));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        int[] succProb = {0,2,3};
        new Dijkstra().minRood(3, edges, succProb, 2, 0);
    }
}