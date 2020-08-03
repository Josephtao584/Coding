package template.bag;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bag_mul {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<int[]> bags = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int c = sc.nextInt();
            int j;
            for (j = 1; c - j * 2 + 1 > 0; j *= 2) {
                bags.add(new int[]{u * j,v * j});
            }

            bags.add(new int[]{u * (c - j + 1), v * (c - j + 1)});
        }
        int[] dp = new int[k + 1];
        for (int i = 0; i < bags.size(); i++) {
            int[] cur_bag = bags.get(i);
            for (int j = k; j >= cur_bag[0]; j--) {
                dp[j] = Math.max(dp[j - cur_bag[0]] + cur_bag[1], dp[j]);
            }
        }
        System.out.println(dp[k]);
    }
}