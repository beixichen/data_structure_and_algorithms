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
public interface MaxHeapInterface<T extends Comparable<? super T>> {
	public void add(T newEntry);//��������Ԫ��
	public T removeMax();//ɾ���Ѷ�Ԫ��
	public T getMax();//ȡ�öѶ�Ԫ��
	public int getSize();//��ö���Ԫ�ظ���
	public void clear();//��ն���Ԫ��
}
