/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ����;

/**
 *
 * @author fx50jk
 */
public class SelectSort {

    static void select(int a[]) {
        int min = 0, temp;

        for (int i = 0; i < a.length - 1; i++) {
            min = a[i];
            for (int j = i + 1; j < a.length; j++) {
                if (min > a[j]) {
                    temp = min;
                    min = a[j];
                    a[j] = temp;
                }
            }
            a[i] = min;
            System.out.print("The" + (i + 1) + "times:\t");
            for (int k = 0; k < a.length; k++) {
                System.out.print(a[k] + "\t");
            }
            System.out.println();
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
        }
        System.out.println();
    }

    static void selectionsort(int a[], int m) {
        int i, j;
        int k;
        int tmp;

        for (i = 0; i < m - 1; i++)//����ѭ��������n������Ҫn-1��ѭ��
        {
            k = i;
            for (j = i + 1; j < m; j++) {
                if (a[j] < a[k]) {
                    k = j;
                }
            }
            //i������k�Ǿ�֤��a[i]������С�ģ�
            //i����kʱ֤��a[i]���Ǳ��ֱȽϹ�������С��ֵ
            if (i != k) {
                tmp = a[i];
                a[i] = a[k];
                a[k] = tmp;
            }
        }
         for (i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a[] = {3,7,2,8,9};
        select(a);
        selectionsort(a,a.length);
    }

}
