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
public class ArrayMaxHeap<T extends Comparable<? super T>> implements MaxHeapInterface<T>, java.io.Serializable {

    private T[] heap;//�����洢��Ԫ�ص�����
    private int lastIndex;//���һ��Ԫ�ص�����
    private static final int DEFAULT_INITIAL_CAPACITY = 25;

    public ArrayMaxHeap() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public ArrayMaxHeap(int initalCapacity) {
        heap = (T[]) new Comparable[initalCapacity];//???
        lastIndex = 0;
    }

    /*
     * @Task ���ݸ���������Ԫ������������
     * @param entries ��entries�����е�Ԫ�ش����ɶ�
     */
    public ArrayMaxHeap(T[] entries) {
        heap = (T[]) new Comparable[entries.length + 1];
        lastIndex = entries.length;
        for (int index = 0; index < entries.length; index++) {
            heap[index + 1] = entries[index];//��0��λ�ò����Ԫ��
            System.out.println(heap[index + 1]);
        }
//		System.out.println("lastIndex = " + lastIndex);
        for (int index = lastIndex / 2; index >= 1; index--) {
            reheap(index);//�����һ����Ҷ��㵽��������reheap���жѵ�������
        }//		for(int index = 1; index <= lastIndex; index++)
//			System.out.println(heap[index]);
    }

    @Override
    public void add(T newEntry) {
        lastIndex++;
        if (lastIndex >= heap.length) {
            doubleArray();//���ѿռ䲻�㣬��Ѵ�С�ӱ�
        }
        int newIndex = lastIndex;//�����һ��Ԫ�ؿ�ʼ�������븸���Ƚ�
        int parentIndex = newIndex / 2;
        heap[0] = newEntry;//�ڱ�
        while (newEntry.compareTo(heap[parentIndex]) > 0) {
            heap[newIndex] = heap[parentIndex];
            newIndex = parentIndex;
            parentIndex = newIndex / 2;
        }
//		while(newIndex > 1 && (newEntry.compareTo(heap[parentIndex]) > 0)){
//			heap[newIndex] = heap[parentIndex];
//			newIndex = parentIndex;
//			parentIndex = newIndex / 2;
//		}
        heap[newIndex] = newEntry;
    }

    private void doubleArray() {
        T[] oldHeap = heap;
        heap = (T[]) new Comparable[lastIndex * 2];
        for (int i = 1; i < lastIndex; i++)//lastIndex ��δ����Ԫ��ǰ�������� 1
        {
            heap[i] = oldHeap[i];
        }
        oldHeap = null;//��������
    }

    @Override
    public T removeMax() {
        T root = null;
        if (!isEmpty()) {
            root = heap[1];
            heap[1] = heap[lastIndex];//�����һ��Ԫ�ش����һ��Ԫ��
            lastIndex--;//ת��Ϊɾ�����һ��Ԫ��
            reheap(1);//�����������жѵ���
        }
        return root;
    }

    /*
     * @Task:������ΪrootIndex�İ�ѵ���Ϊ�µĶѣ���ѣ����������������Ƕ�
     * @param rootIndex ��rootIndexΪ��������
     */
    private void reheap(int rootIndex) {
        boolean done = false;//��Ƕѵ����Ƿ����
        T orphan = heap[rootIndex];
        int largeChildIndex = 2 * rootIndex;//Ĭ�����ӵ�ֵ�ϴ�
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
                largeChildIndex = 2 * rootIndex;//����Ĭ�����ӵ�ֵ�ϴ�
            } else//��rootIndexΪ���������Ѿ����ɶ���
            {
                done = true;
            }
        }
        heap[rootIndex] = orphan;
    }

    @Override
    public T getMax() {
        T root = null;
        if (!isEmpty()) {
            root = heap[1];
        }
        return root;
    }

    @Override
    public int getSize() {
        return lastIndex;
    }

    @Override
    public void clear() {
        for (; lastIndex > -1; lastIndex--) {
            heap[lastIndex] = null;
        }
        lastIndex = 0;
    }

    public boolean isEmpty() {
        return lastIndex < 1;//��Ԫ�ش������±�Ϊ1����ʼ���
    }
}
