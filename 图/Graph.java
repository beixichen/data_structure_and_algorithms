/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ͼ;

/**DFS:
 *α����
�ݹ�ʵ��

1. ���������ʼ����visited[n] = 0
2. ���ʶ��㣺visited[v] = 1
3. ȡv�ĵ�һ���ڽӵ�w��
4. ѭ���ݹ飺
    while(w����)
        if(wδ�����ʹ�)
            �Ӷ���w�����ݹ�ִ��;
        w = v����һ���ڽӵ�;
�ǵݹ�ʵ��

1. ջ��ʼ����visited[n] = 0
2. ���ʶ��㣺visited[v] = 1
3. ��ջ
4. while(ջ��Ϊ��)
    x = ջ�Ķ�Ԫ�أ����ҳ�ջ;
    if (���ڲ��ҵ�δ�����ʵ�x���ڽӵ�w)
        ����w��visited[w] = 1
        w��ջ
* BFS
* �ǵݹ�ʵ��

1. ��ʼ�����У�visited[n] = 0
2. ���ʶ��㣺visited[v] = 1
3. ����v�������
4. ѭ����
    while(�����Ƿ�Ϊ��)
        v = ����ͷԪ��
        w = v�ĵ�һ���ڽӵ�
        while(w����)
            if(���wδ����)
                visited[w] = 1;
                ����w�������
                w = ����v����һ���ڽӵ�
 * @author fx50jk
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    private int number = 9;
    int count = 0;
    private  boolean[] flag;
    private String[] vertexs = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
    private int[][] edges = {
        {0, 1, 0, 0, 0, 1, 1, 0, 0},
        {1, 0, 1, 0, 0, 0, 1, 0, 1},
        {0, 1, 0, 1, 0, 0, 0, 0, 1},
        {0, 0, 1, 0, 1, 0, 1, 1, 1},
        {0, 0, 0, 1, 0, 1, 0, 1, 0},
        {1, 0, 0, 0, 1, 0, 1, 0, 0},
        {0, 1, 0, 1, 0, 1, 0, 1, 0},
        {0, 0, 0, 1, 1, 0, 1, 0, 0},
        {0, 1, 1, 1, 0, 0, 0, 0, 0}
    };

    void DFSTraverse() {
        flag = new boolean[number];
        DFS(1);
//        for (int i = 0; i < number; i++) {
//            if (flag[i] == false) {// ��ǰ����û�б�����  
//                DFS(i);
//            }
//        }

    }

    void DFS(int i) {
        flag[i] = true;// ��i�����㱻����  
        System.out.print(vertexs[i] + " ");
        for (int j = 0; j < number; j++) {//�������ҳ��������������(�б�)�Ķ��㣬����û�б����ʹ��Ķ���
            if (flag[j] == false && edges[i][j] == 1) {
                DFS(j);
            }
        }
    }

    void dfs(int cur) {
        flag[cur] = true;
        System.out.print(vertexs[cur] + " ");
        for (int i = 0; i < number; i++) {
            if (edges[cur][i] == 1 && flag[i] == false) {
                dfs(i);
            }
        }
    }

    void DFS_Map() {
        flag = new boolean[number];
        Stack<Integer> stack = new Stack<>();
        flag[1] = true;
        stack.push(1);
        System.out.print(vertexs[1]+" ");
        while (!stack.isEmpty()) {
            int j,k = stack.peek();
            for (j = 0; j < number; j++) {
                if (edges[k][j] == 1 && flag[j] == false) {
                    flag[j] = true;
                    System.out.print(vertexs[j] + " "); 
                    stack.push(j);
                    break;       //�ҵ�һ������δ���ʵĶ��㣬����֮��������ѭ��
                }
            }
            if (j==number) { //�����i���ڵĶ��㶼�����ʹ����򽫶���i��ջ
                stack.pop();
            }
        }
//        for (int i = 0; i < number; i++) {
//            if (flag[i] == false) {
//                flag[i] = true;
//                System.out.print(vertexs[i] + " ");
//                stack.push(i);
//            }
//            while (!stack.isEmpty()) {
//                int k = stack.pop();
//                for (int j = 0; j < number; j++) {
//                    if (edges[k][j] == 1 && flag[j] == false) {
//                        flag[j] = true;
//                        System.out.print(vertexs[j] + " ");
//                        stack.push(j);
//                        break;
//                    }
//                }
//            }
//        }
    }

    void BFS_Map() {
        flag = new boolean[number];
        Queue<Integer> queue = new LinkedList<>();
        flag[0] = true;
        System.out.print(vertexs[0] + " ");
        queue.add(0);
        while (!queue.isEmpty()) {
            int k = queue.poll();
            for (int j = 0; j < number; j++) {
                if (edges[k][j] == 1 && flag[j] == false) {//����k���ڵĽڵ�
                    flag[j] = true;
                    System.out.print(vertexs[j] + " ");
                    queue.add(j);
                }
            }
        }
//        for (int i = 0; i < number; i++) {
//            System.out.println("fffksjl");
//            if (flag[i] == false) {
//                flag[i] = true;
//                System.out.print(vertexs[i] + " ");
//                queue.add(i);
//                while (!queue.isEmpty()) {
//                    int k = queue.poll();
//                    for (int j = 0; j < number; j++) {
//                        if (edges[k][j] == 1 && flag[j] == false) {
//                            flag[j] = true;
//                            System.out.print(vertexs[j] + " ");
//                            queue.add(j);
//                        }
//                    }
//                }
//            }
//        }
    }

    void bfs() {
        int queue[] = new int[10000];
        boolean mark[] = new boolean[100];
        int head = 0, tail = 0, cur;
        queue[tail] = 0;
        tail++;
        mark[head] = true;
        while (head < tail) {//���в�Ϊ��
            cur = queue[head];//���ڷ��ʵĽڵ�
            head++;//׼����һ�εķ���
            for (int i = 0; i < number; i++) {
                if (edges[cur][i] == 1 && mark[i] == false) {//�ж϶���cur��i�Ƿ��бߣ������ж�i�����Ƿ��Ѿ����ʹ�
                    queue[tail] = i;//�����ڵ�δ���ʹ��Ķ���i���
                    tail++;
                    mark[i] = true;
                }
                if (tail > number) {//���ж����Ѿ�������
                    break;
                }
            }
        }
        System.out.println("");
        for (int i = 0; i < tail; i++) {
            System.out.print(vertexs[queue[i]] + " ");
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        
        System.out.println("DFS�ݹ�:");
        graph.DFSTraverse();
        System.out.println("\n�ݹ�2��");
//         flag = new boolean[10];
//        graph.dfs(0);
        System.out.println();
        System.out.println("DFS�ǵݹ�:");
        graph.DFS_Map();
        System.out.println();
        System.out.println("BFS�ǵݹ�:");
        graph.BFS_Map();
        graph.bfs();
    }
}
