package sort;

public class QuickSort {
    int nums[];

    public void swap(int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;

    }
    public void quickSort(int low, int high) {
        if (low > high)
            return;
        int i = low, j = high;
        int temp = nums[low];
        while (i < j) {
            while (temp <= nums[j] && i < j)
                j--;
            while (temp >= nums[i] && i < j)
                i++;
            if(i<j){
                swap(i,j);
            }

        }
        nums[low] = nums[j];
        nums[j] = temp;
        quickSort(low, j - 1);
        quickSort(j + 1, high);
    }

    public QuickSort(int[] nums) {
        this.nums = nums;
    }

    public static void main(String args[]) {
        int num[] = new int[100];
        for (int i = 0; i < 100; i++) {
            num[i] = (int) (Math.random() * 1000);
        }
        QuickSort q = new QuickSort(num);
        q.quickSort(0, 99);
        for (Integer i : q.nums
        ) {
            System.out.print(i + " ");
        }
    }
}
