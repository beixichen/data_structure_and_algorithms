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
public class myStack<T> {

    private class Node {

        T val;
        Node next;
    }
    private Node first;
    private int N;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(T val) {
        Node oldfirst = first;
        first = new Node();
        first.val = val;
        first.next = oldfirst;
        N++;
    }

    public T pop() {
        T val = first.val;
        first = first.next;
        N--;
        return val;
    }

}
