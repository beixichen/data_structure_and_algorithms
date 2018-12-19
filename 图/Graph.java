/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 图;

/**DFS:
 *伪代码
递归实现

1. 访问数组初始化：visited[n] = 0
2. 访问顶点：visited[v] = 1
3. 取v的第一个邻接点w；
4. 循环递归：
    while(w存在)
        if(w未被访问过)
            从顶点w出发递归执行;
        w = v的下一个邻接点;
非递归实现

1. 栈初始化：visited[n] = 0
2. 访问顶点：visited[v] = 1
3. 入栈
4. while(栈不为空)
    x = 栈的顶元素，并且出栈;
    if (存在并找到未被访问的x的邻接点w)
        访问w：visited[w] = 1
        w进栈
* BFS
* 非递归实现

1. 初始化队列：visited[n] = 0
2. 访问顶点：visited[v] = 1
3. 顶点v加入队列
4. 循环：
    while(队列是否为空)
        v = 队列头元素
        w = v的第一个邻接点
        while(w存在)
            if(如果w未访问)
                visited[w] = 1;
                顶点w加入队列
                w = 顶点v的下一个邻接点
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
//            if (flag[i] == false) {// 当前顶点没有被访问  
//                DFS(i);
//            }
//        }

    }

    void DFS(int i) {
        flag[i] = true;// 第i个顶点被访问  
        System.out.print(vertexs[i] + " ");
        for (int j = 0; j < number; j++) {//遍历，找出与这个顶点相邻(有边)的顶点，并且没有被访问过的顶点
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
                    break;       //找到一个相邻未访问的顶点，访问之后则跳出循环
                }
            }
            if (j==number) { //如果与i相邻的顶点都被访问过，则将顶点i出栈
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
                if (edges[k][j] == 1 && flag[j] == false) {//访问k相邻的节点
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
        while (head < tail) {//队列不为空
            cur = queue[head];//正在访问的节点
            head++;//准备下一次的访问
            for (int i = 0; i < number; i++) {
                if (edges[cur][i] == 1 && mark[i] == false) {//判断顶点cur到i是否有边，并且判断i顶点是否已经访问过
                    queue[tail] = i;//将相邻的未访问过的顶点i入队
                    tail++;
                    mark[i] = true;
                }
                if (tail > number) {//所有顶点已经被访问
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
        
        System.out.println("DFS递归:");
        graph.DFSTraverse();
        System.out.println("\n递归2：");
//         flag = new boolean[10];
//        graph.dfs(0);
        System.out.println();
        System.out.println("DFS非递归:");
        graph.DFS_Map();
        System.out.println();
        System.out.println("BFS非递归:");
        graph.BFS_Map();
        graph.bfs();
    }
}
