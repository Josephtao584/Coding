package sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String []args){
        int []arr = {9,8,7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr){
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int i = arr.length  - 1; i > 0; i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
    }

    public static void adjustHeap(int[] arr, int i, int length){
        int t = arr[i];
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            if(j + 1 < length && arr[j] < arr[j + 1])
                j++;
            if(arr[j] > t){
                arr[i] = arr[j];
                i = j;
            }else
                break;
        }
        arr[i] = t;
    }

    public static void swap(int[] arr, int a, int b){
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
