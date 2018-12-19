/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ��;

/**
 *
 * @author fx50jk
 */
public class HeapSort {

    private static <T extends Comparable<? super T>> void reheap(T[] heap, int rootIndex, int lastIndex) {
        boolean done = false;//��Ƕѵ����Ƿ����
        T orphan = heap[rootIndex];
        int largeChildIndex = 2 * rootIndex + 1;//Ĭ�����ӵ�ֵ�ϴ�
        //�ѵ���������largeChildIndexΪ������������
        while (!done && (largeChildIndex <= lastIndex)) {
            //largeChildIndex ���rootIndex�����Һ����нϴ�ĺ���
            int leftChildIndex = largeChildIndex;//Ĭ�����ӵ�ֵ�ϴ�
            int rightChildIndex = leftChildIndex + 1;
            //�Һ���Ҳ����,�Ƚ����Һ���
            if (rightChildIndex <= lastIndex && (heap[largeChildIndex].compareTo(heap[rightChildIndex]) < 0)) {
                largeChildIndex = rightChildIndex;
            }
            //	System.out.println(heap[largeChildIndex]);//���������⡣��ʹ�ù��캯������ʱreheap����������
            if (orphan.compareTo(heap[largeChildIndex]) < 0) {
                heap[rootIndex] = heap[largeChildIndex];
                rootIndex = largeChildIndex;
                largeChildIndex = 2 * rootIndex + 1;//����Ĭ�����ӵ�ֵ�ϴ�
            } else//��rootIndexΪ���������Ѿ����ɶ���
            {
                done = true;
            }
        }
        heap[rootIndex] = orphan;
    }

    public static <T extends Comparable<? super T>> void heapSort(T[] array, int n) {
        //ֱ����array�ϴ�����ʼ��
        for (int rootIndex = n / 2 - 1; rootIndex >= 0; rootIndex--) {
            reheap(array, rootIndex, n - 1);
        }
        swap(array, 0, n - 1);
        //������i��Ԫ��(����Ϊi-1)���n-i��Ԫ�ؽ������γɵİ��
        for (int lastIndex = n - 2; lastIndex > 0; lastIndex--) {
            reheap(array, 0, lastIndex);
            swap(array, 0, lastIndex);
        }
        
    }

    private static <T> void swap(T[] array, int from, int to) {
        T temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }
}
