package template.bag;

import java.util.*;

public class Bag_all {
    public static void fun(int n, int v, int[][] bag){
        int[][] dp = new int[n + 1][v + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= v; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                if(j - bag[i - 1][0] >= 0)
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - bag[i - 1][0]] + bag[i - 1][1]);
            }
        }
        System.out.println(dp[n][v]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int v = sc.nextInt();
        int[][] bag = new int[n][2];
        for (int i = 0; i < n; i++) {
            bag[i][0] = sc.nextInt();
            bag[i][1] = sc.nextInt();
        }
        fun(n, v, bag);


    }
}