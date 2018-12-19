/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ÅÅÐò;

/**
 *
 * @author fx50jk
 */
public class HeapSort {

    static void buildMaxHeap(int[] a, int len) {
        for (int i = len / 2; i > 0; i--) {
            Adjust(a, i, len);
        }
    }

    static void Adjust(int a[], int k, int len) {
        a[0] = a[k];
        int i;
        for (i = 2 * k; i < len; i *= 2) {
            if (i < len && a[i] < a[i + 1]) {
                i++;
            }
            if (a[0] >= a[i]) {
                break;
            } else {
                a[k] = a[i];
                k = i;
            }

        }
        a[k] = a[0];
    }

    static void Heapsort(int[] a,int len) {
        buildMaxHeap(a, len);
        int temp;
        for (int i = len-1; i >=0; i--) {
            temp=a[1];
            a[1]=a[i];
            a[i]=temp;
            Adjust(a, 0, i);
        }
          for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
           int a[] = {9, 7, 5, 3, 4, 6};
           Heapsort(a, a.length);
    }

}
