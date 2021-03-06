package sort;

public class MergeSort {
    public void merge(int[] arr, int start, int end){
        if(start >= end)
            return;
        int mid = start + (end - start) / 2;
        merge(arr, start, mid);
        merge(arr, mid + 1, end);

        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end)
            temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        while (i <= mid)
            temp[k++] = arr[i++];
        while (j <= mid)
            temp[k++] = arr[j++];
        System.arraycopy(temp, 0, arr, start, end);
    }
}
