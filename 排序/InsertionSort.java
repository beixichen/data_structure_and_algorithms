/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ����;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 *�������е�Ԫ����һ������������ݽ��бȽ� �ٽ���������
 * �󲿷������Ѿ�����
 * @author fx50jk
 */
public class InsertionSort {

 public static void insertion_sort(Integer[] unsorted)
        {
            for (int i = 1; i < unsorted.length; i++)
            {
                if (unsorted[i - 1] > unsorted[i])
                {
                    int temp = unsorted[i];
                    int j = i;
                    while (j > 0 && unsorted[j - 1] > temp)
                    {
                        unsorted[j] = unsorted[j - 1];
                        j--;
                    }
                    unsorted[j] = temp;
                }
            }
        }
 
 static void insertSort(Integer arr[]){
     int j,temp;
     for (int i = 1; i < arr.length; i++) {
//         if(arr[i]<arr[i-1]){
            temp=arr[i];
            for (j = i; j >0&&temp<arr[j-1]; j--) {
                arr[j]=arr[j-1];
            }
            arr[j] = temp;
        
//         }
     }
 }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Random rnd=new Random();
        Integer[] arr=new Integer[15];
        for(int i=0;i<arr.length;i++)
            arr[i]=rnd.nextInt(100);
        System.out.println("����ǰ��"+Arrays.toString(arr));
       //insertion_sort(arr);
        insertSort(arr);
         System.out.println("�����"+Arrays.toString(arr));
               
    }
    
}
