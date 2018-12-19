/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ����;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author fx50jk
 */
public class QuickSort {

    //��������
    static void quick_sort(Integer s[], int l, int r) {
        if (l < r) {
            //Swap(s[l], s[(l + r) / 2]); //���м��������͵�һ�������� �μ�ע1
            int low = l, high = r, x = s[l];
            while (low < high) {
                while (low < high && s[high] >= x) // ���������ҵ�һ��С��x����
                {
                    high--;
                }
//                if (low < high) {
                s[low] = s[high];
//                }

                while (low < high && s[low] < x) // ���������ҵ�һ�����ڵ���x����
                {
                    low++;
                }
//                if (low < high) {
                s[high] = s[low];
//                }
            }
            s[low] = x;
            quick_sort(s, l, low - 1); // �ݹ���� 
            quick_sort(s, low + 1, r);
        }
    }

    public static void sort(Integer[] s, int low, int high) {

        int left = low;
        int right = high;
        int temp;
        temp = s[low];//��׼��
        if (low < high) {
            while (left < right) {
                while (right > low && s[right] >= s[low]) {
                    right--;
                }
                while (left < high && s[left] <= s[low]) {
                    left++;
                }

                //�����ڱ���û������ʱ������
                if (left < right) {
                    temp = s[left];
                    s[left] = s[right];
                    s[right] = temp;
                }
            }
            //����׼���ŵ���ȷ��λ����
            s[low] = s[right];
            s[right] = temp;//��׼��

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
        System.out.println("����ǰ��" + Arrays.toString(arr));

//        System.out.println("��6���Ԫ�أ�"+selectK(arr, 5));
        sort(arr, 0, arr.length - 1);
//        quick_sort(arr, 0, arr.length - 1);
//        QuickSort(arr, 0, arr.length - 1);
        System.out.println("���鳤�ȣ�" + arr.length);
        System.out.println("�����" + Arrays.toString(arr));

    }
}
