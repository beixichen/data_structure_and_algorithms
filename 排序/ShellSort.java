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
public class ShellSort {

    static void shellsort1(int a[]) {
        int i, j, gap;
        int n = a.length;
        for (gap = n / 2; gap > 0; gap /= 2) //步长  
        {
            for (i = 0; i < gap; i++) //直接插入排序  
            {
                for (j = i + gap; j < n; j += gap) {
                    if (a[j] < a[j - gap]) {
                        int temp = a[j];
                        int k = j - gap;
                        while (k >= 0 && a[k] > temp) {
                            a[k + gap] = a[k];
                            k -= gap;
                        }
                        a[k + gap] = temp;
                    }
                }
            }
        }
        for (i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
        }
    }

    static void shellsort2(int a[]) {
        int j, gap;
        int n = a.length;
        for (gap = n / 2; gap > 0; gap /= 2) {
            for (j = gap; j < n; j++)//从数组第gap个元素开始  
            {
//                if (a[j] < a[j - gap])//每个元素与自己组内的数据进行直接插入排序  
//                {
                    int temp = a[j];
                    int k = j ;
                    while (k >= gap && a[k-gap] > temp) {
                        a[k] = a[k- gap];
                        k -= gap;
                    }
                    a[k] = temp;
//                }
            }
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
        int a[] = {6, 5, 3, 2, 4, 8, 9, 1};
        shellsort2(a);
    }

}
