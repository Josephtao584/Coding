package template.bag;
import java.util.Scanner;

class Bag_deque {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] bags = new int[n][3];
        for (int i = 0; i < n; i++) {
            bags[i][0] = sc.nextInt();
            bags[i][1] = sc.nextInt();
            bags[i][2] = sc.nextInt();
        }
        int[] dp = new int[m + 1];
        int[][] deque = new int[m + 1][2];
        for (int i = 0; i < n ; i++) {
            int v = bags[i][0], w = bags[i][1], c = bags[i][2];
            for (int j = 0; j < v; j++) {
                int start = 0, end = -1;
                for (int k = j; k <= m; k += v) {
                    if(start <= end && k - c * v > deque[start][0]){
                        start++;
                    }
                    int count = (k - j) / v;
                    if(start <= end && deque[end][1] <= dp[k] - w * count)
                        end--;
                    end++;
                    deque[end][0] = k;
                    deque[end][1] = dp[k] - w * count;
                    if(start <= end)
                        dp[k] = Math.max(dp[k], deque[start][1] + w *count);
                }
            }
        }
        System.out.println(dp[m]);
    }
}