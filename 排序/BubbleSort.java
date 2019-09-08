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
public class BubbleSort {

    static void BubbleSort1(int a[], int n) {
        int i, j ,temp;
        for ( i = 0; i < a.length; i++) {
            for ( j = 0; j < a.length-1-i; j++) {
                if (a[j + 1] < a[j]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            System.out.print(j+"The" + (i + 1) + "times:\t");
            for (int k = 0; k < a.length; k++) {
                System.out.print(a[k] + "\t");
            }
           System.out.println();
        }
//        for (int i = a.length - 1; i > 0; i--) {
//            for (int j = 0; j < i; j++) {
//                if (a[j + 1] < a[j]) {
//                    temp = a[j];
//                    a[j] = a[j + 1];
//                    a[j + 1] = temp;
//                }
//            }
//        }

        for (int k = 0; k < a.length; k++) {
            System.out.print(a[k] + "\t");
        }
        System.out.println("");
    }

//冒泡排序2  
    //1)增加标志位，标记最终的交换位置，去掉不必要的交换操作；  
    //2)如果当前循环没有交换数据，说明已经完成排序，去掉不必要的比较；  
    static void BubbleSort2(int a[], int n) {
        int j, k;
        boolean flag;
        int temp;
        k = n;
        flag = true;
        for (int i = 0; i < a.length; i++) {
            flag=false;
            for (j = a.length-1; j >i; j--) {
                if (a[j-1]>a[j]) {
                    temp=a[j];
                    a[j]=a[j-1];
                    a[j-1]=temp;
                    flag=true;
                }
            }
            System.out.print("The" + (i + 1) + "times:\t");
            for (k = 0; k < a.length; k++) {
                System.out.print(a[k] + "\t");
            }
           System.out.println();
            if (flag==false) {
                break;//本次遍历没有发生交换说明已经有序
            }
        }
//        while (flag) {
//            flag = false;
//            for (j = 1; j < k; j++) {
//                if (a[j - 1] > a[j]) {
//                    temp = a[j];
//                    a[j] = a[j - 1];
//                    a[j - 1] = temp;
//                    flag = true;
//                }
//            }
//            k--;
//        }
        for (k = 0; k < a.length; k++) {
            System.out.print(a[k] + "\t");
        }
        System.out.println("");
    }
/*如果有100个数的数组，仅前面10个无序，后面90个都已排好序且都大于前面10个数字，
    那么在第一趟遍历后， 最后发生交换的位置必定小于10，且这个位置之后的数据必定已经有序了，记录下这位置，
    第二次只要从数组头部遍历到这个位置就可以了。
    */
    static void BubbleSort3(int a[], int n) {
        int j, k;
        int flag;
        int temp;
        flag = n;
        while (flag > 0) {
            k = flag;
            flag = 0;
            for (j = 1; j < k; j++) {
                if (a[j - 1] > a[j]) {
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                    flag = j;
                }
            }
            System.out.print("The times:\t");
            for (k = 0; k < a.length; k++) {
                System.out.print(a[k] + "\t");
            }
            System.out.println();
        }
        for (k = 0; k < a.length; k++) {
            System.out.print(a[k] + "\t");
        }
        System.out.println("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a[] = {7,9,3,15,8,2,11};
        BubbleSort1(a, a.length);
        BubbleSort2(a, a.length);
        BubbleSort3(a, a.length);
    }

}
