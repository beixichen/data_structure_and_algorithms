/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 排序;

/**
 *
 * @author fx50jk
 */
public class MergeSort {

    static void merge(int[] unsorted, int first, int mid, int last, int[] sorted) {
        int i = first, j = mid;
        int k = 0;

        while (i < mid && j < last) {
            if (unsorted[i] < unsorted[j]) {//从两个数组中取出较小的放入排序后的数组
                sorted[k++] = unsorted[i++];
            } else {
                sorted[k++] = unsorted[j++];
            }
        }
        //将剩余部分放入排序后的数组(两个循环只会执行一个)
        while (i < mid) {
            sorted[k++] = unsorted[i++];
        }
        while (j < last) {
            sorted[k++] = unsorted[j++];
        }
        for (int v = 0; v < k; v++) {
            unsorted[first + v] = sorted[v];
        }

    }

    static void merge1(int[] unsorted, int low, int mid, int high, int[] sorted) {
        int i, j, k;
        for (i = low; i < high; i++) {
            sorted[i] = unsorted[i];
        }
        for (i = low, j = mid + 1, k = i; i <= mid && j < high; k++) {
            if (sorted[i] <= sorted[j]) {
                unsorted[k] = sorted[i++];
            } else {
                unsorted[k] = sorted[j++];
            }
        }
        while (i <= mid) {
            unsorted[k++] = sorted[i++];
        }
        while (j < high) {
            unsorted[k++] = sorted[j++];
        }
    }

    static void merge_sort(int[] unsorted, int first, int last, int[] sorted) {
        if (first + 1 < last) {
            int mid = (first + last) / 2;
            
            merge_sort(unsorted, first, mid, sorted);
            merge_sort(unsorted, mid, last, sorted);
            merge(unsorted, first, mid, last, sorted);
        }
    }

    public static void main(String[] args) {
        int[] x = {6, 2, 4, 1, 5, 9, 7};
        int[] sorted = new int[x.length];
        merge_sort(x, 0, x.length, sorted);
        for (int i = 0; i < sorted.length; i++) {
            if (x[i] > 0) {
                System.out.print(x[i] + "\t");
            }
        }

    }

}
