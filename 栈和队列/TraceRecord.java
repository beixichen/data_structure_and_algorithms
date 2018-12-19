/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 栈和队列;

/**
 *
 * @author fx50jk
 */
class Node {

    int x;
    int y;
    Node next;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        this.next = null;
    }

}

public class TraceRecord {

    public Node first;
    public Node last;

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(int x, int y) {
        Node newNode = new Node(x, y);
        if (this.isEmpty()) {
            first = newNode;
            last = newNode;

        } else {
            last.next = newNode;
            last = newNode;
        }

    }

    public void delete() {
        Node newNode;
        if (this.isEmpty()) {
            System.out.println("已经为空");
            return;
        }
        newNode = first;
        while (newNode.next != last) {
            newNode = newNode.next;
        }
        newNode.next = last.next;
        last = newNode;
    }
}
