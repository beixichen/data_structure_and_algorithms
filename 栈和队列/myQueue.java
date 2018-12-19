/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ’ª∫Õ∂”¡–;

/**
 *
 * @author fx50jk
 */
public class myQueue<T> {

    private class Node {
        T val;
        Node next;
    }
    private Node first;
    private Node last;
    private int N;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enQueue(T val) {
        Node oldfirst = last;
        last = new Node();
        last.val = val;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldfirst.next = last;
        }
        N++;
    }

    public T deQueue() {
        T val = first.val;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        N--;
        return val;
    }
}
