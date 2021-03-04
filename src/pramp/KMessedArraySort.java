package pramp;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KMessedArraySort {
    static int[] sortKMessedArray(int[] arr, int k) {
        for(int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            int m = 0;
            for(int j = i; j <= i + k; j++) {
                if (j < arr.length) {
                    if(arr[j] < min) {
                        min = arr[j];
                        m = j;
                    }
                } else {
                    break;
                }
            }
            if(m != i) {
                int temp = arr[i];
                arr[i] = arr[m];
                arr[m] = temp;
            }
        }
        return arr;
    }

    static int[] sortKMessedArrayHeap(int[] arr, int k) {
        int n = arr.length;
        //create an empty min-heap
        Queue<Integer> heap = new PriorityQueue<>();
        //build the min-heap from the first k+1 elements of arr
        for (int i = 0; i <= k; i++) {
            heap.add(arr[i]);
        }
        for (int i = k + 1; i < n; i++) {
            //extract the top element from the min-heap and assign it to the next available array index
            arr[i - (k + 1)] = heap.remove();
            //push the next array element into the min-heap
            heap.add(arr[i]);
        }
        //extract all remaining elements from the min-heap and assign them to the next available array index
        for (int i = 0; i <= k; i++) {
            arr[n - k - 1 + i] = heap.remove();
        }
        return arr;
    }

    public static void main (String[] args) {
        System.out.println("Sort");
        System.out.println(Arrays.toString(sortKMessedArray(new int[] { 1, 4, 5, 2, 3, 7, 8, 6, 10, 9 }, 2)));
        System.out.println(Arrays.toString(sortKMessedArray(new int[] { 1 }, 0)));
        System.out.println(Arrays.toString(sortKMessedArray(new int[] { 1, 0 }, 1)));
        System.out.println(Arrays.toString(sortKMessedArray(new int[] { 1, 0, 3, 2 }, 1)));
        System.out.println(Arrays.toString(sortKMessedArray(new int[] { 1, 0, 3, 2, 4, 5, 7, 6, 8 }, 1)));
        System.out.println(Arrays.toString(sortKMessedArray(new int[] { 6, 1, 4, 11, 2, 0, 3, 7, 10, 5, 8, 9 }, 6)));

        System.out.println("MinHeap");
        System.out.println(Arrays.toString(sortKMessedArrayHeap(new int[] { 1, 4, 5, 2, 3, 7, 8, 6, 10, 9 }, 2)));
        System.out.println(Arrays.toString(sortKMessedArrayHeap(new int[] { 1 }, 0)));
        System.out.println(Arrays.toString(sortKMessedArrayHeap(new int[] { 1, 0 }, 1)));
        System.out.println(Arrays.toString(sortKMessedArrayHeap(new int[] { 1, 0, 3, 2 }, 1)));
        System.out.println(Arrays.toString(sortKMessedArrayHeap(new int[] { 1, 0, 3, 2, 4, 5, 7, 6, 8 }, 1)));
        System.out.println(Arrays.toString(sortKMessedArrayHeap(new int[] { 6, 1, 4, 11, 2, 0, 3, 7, 10, 5, 8, 9 }, 6)));
    }
}
