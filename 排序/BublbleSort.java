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
public class BublbleSort {

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

//ð������2  
    //1)���ӱ�־λ��������յĽ���λ�ã�ȥ������Ҫ�Ľ���������  
    //2)�����ǰѭ��û�н������ݣ�˵���Ѿ��������ȥ������Ҫ�ıȽϣ�  
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
                break;//���α���û�з�������˵���Ѿ�����
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
/*�����100���������飬��ǰ��10�����򣬺���90�������ź����Ҷ�����ǰ��10�����֣�
    ��ô�ڵ�һ�˱����� �����������λ�ñض�С��10�������λ��֮������ݱض��Ѿ������ˣ���¼����λ�ã�
    �ڶ���ֻҪ������ͷ�����������λ�þͿ����ˡ�
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
