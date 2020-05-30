import java.util.HashMap;
import java.util.Map;

class Main {
    public int findTargetSumWays(int[] nums, int S) {
        int[] arr= new int[2000];
        int low = -nums[0] + 1000;
        int up = nums[0] - 1000;
        arr[low] = 1;
        arr[up] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[j] != 0){
                    arr[j + nums[i]]++;
                    arr[j - nums[i]]++;
                }
            }
        }
        return arr[S+1000];
    }
}