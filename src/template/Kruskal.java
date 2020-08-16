package template;

import java.util.Arrays;
import java.util.Scanner;

public class Kruskal {
    static int N = 100010;
    static int[] p = new int[N];
    public static void kruskal(int[][] edges, int n, int m){
        Arrays.sort(edges, ((o1, o2) -> (o2[2] - o1[2])));
        int cnt = 0, res = 0;
        for (int i = 0; i < m; i++) {
            int[] cur_edge = edges[i];
            int u = cur_edge[0];
            int v = cur_edge[1];
            int c = cur_edge[2];
            u = find(u);
            v = find(v);
            if(u != v){
                p[u] = v;
                res += c;
                cnt++;
            }
        }
        if(cnt == n - 1)
            System.out.println(res);
        else
            System.out.println("impossible");
    }

    static int find(int x){
        if(x != p[x]){
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        int[][] edges = new int[m][3];
        for (int i = 0; i < edges.length; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }
        kruskal(edges, n, m);
    }
}
