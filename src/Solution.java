import java.util.HashMap;

class Solution {
    public int subarraysDivByK(int[] A, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for(int i : A){
            sum += (A[i] + K) % K;
            int n = map.getOrDefault(sum, 0);
            count += n;
            map.put(sum, n + 1);
        }
        return count;
    }
}