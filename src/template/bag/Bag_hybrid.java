package template.bag;

import java.util.*;

class Bag_hybrid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<int[][]> bags = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            int[][] bag_group = new int[k][2];
            for (int j = 0; j < k; j++) {
                int v = sc.nextInt();
                int w = sc.nextInt();
                bag_group[j][0]= v;
                bag_group[j][1] = w;
            }
            bags.add(bag_group);
        }
        int[] dp = new int[m + 1];
        for (int i = 0; i < n; i++) {
            int[][] cur_group = bags.get(i);
            for (int j = m; j >= 0; j--) {
                for (int k = 0; k < cur_group.length; k++) {
                    int v = cur_group[j][0], w = cur_group[j][1];
                    if(j - v >= 0){
                        dp[j] = Math.max(dp[j], dp[j - v] + w);
                    }
                }
            }
        }
        System.out.println(dp[m]);
    }
}
