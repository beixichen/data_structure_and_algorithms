/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 排序;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author fx50jk
 */
public class QuickSort {

    //快速排序
    static void quick_sort(Integer s[], int l, int r) {
        if (l < r) {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换
            int low = l, high = r, x = s[l];
            while (low < high) {
                while (low < high && s[high] >= x) // 从右向左找第一个小于x的数
                {
                    high--;
                }
//                if (low < high) {
                s[low] = s[high];
//                }

                while (low < high && s[low] < x) // 从左向右找第一个大于等于x的数
                {
                    low++;
                }
//                if (low < high) {
                s[high] = s[low];
//                }
            }
            s[low] = x;
            quick_sort(s, l, low - 1); // 递归调用 
            quick_sort(s, low + 1, r);
        }
    }

    public static void sort(Integer[] s, int low, int high) {

        int left = low;
        int right = high;
        int temp;
        temp = s[low];//基准数
        if (low < high) {
            while (left < right) {
                while (right > low && s[right] >= s[low]) {
                    right--;
                }
                while (left < high && s[left] <= s[low]) {
                    left++;
                }

                //两个哨兵还没有相遇时，交换
                if (left < right) {
                    temp = s[left];
                    s[left] = s[right];
                    s[right] = temp;
                }
            }
            //将基准数放到正确的位置上
            s[low] = s[right];
            s[right] = temp;//基准数

            sort(s, low, right - 1);
            sort(s, right + 1, high);
        }
    }

    static void QuickSort(Integer a[], int low, int high) {
        if (low < high) {
            int temp = Partition(a, low, high);
            QuickSort(a, low, temp - 1);
            QuickSort(a, temp + 1, high);
        }

    }

    static int Partition(Integer[] a, int low, int high) {

        int temp = a[low];
        while (low < high) {
            while (low < high && a[high] >= temp) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= temp) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = temp;
        return low;
    }

    static int selectK(Integer[] a, int k) {
        int low = 0, high = a.length - 1;
        while (high > low) {
            int j = Partition(a, low, high);
            if (j == k) {
                return a[k];
            } else if (j > k) {
                high = j - 1;
            } else {
                low = j + 1;
            }
        }
        return a[k];
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Random random = new Random();
//        Integer[] arr = new Integer[15];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = random.nextInt(100);
//        }

        Integer arr[] = {6, 1, 2, 7, 9};
        System.out.println("排序前：" + Arrays.toString(arr));

//        System.out.println("第6大的元素："+selectK(arr, 5));
        sort(arr, 0, arr.length - 1);
//        quick_sort(arr, 0, arr.length - 1);
//        QuickSort(arr, 0, arr.length - 1);
        System.out.println("数组长度：" + arr.length);
        System.out.println("排序后：" + Arrays.toString(arr));

    }
}
