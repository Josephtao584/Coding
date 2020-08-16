package template;

/*
 * 最长不下降子序列 贪心+二分
 */
public class LIS {
    public static int LIS(int[] arr) {
        int[] dp = new int[arr.length];
        int res = 0;
        for (int num : arr) {
            int l = 0, r = res;
            while (l < r) {
                int m = (l + r) / 2;
                if (dp[m] < num) l = m + 1;
                else r = m;
            }
            dp[l] = num;
            if (l == res) res++;
        }
        return res;
    }
}
