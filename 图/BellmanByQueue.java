/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 图;

import java.util.Scanner;

/**
 *5 7
1 2 2
1 5 10
2 3 3 
2 5 7
3 4 4
4 5 5
5 3 6
 * @author msy
 * 每次仅对前一遍松弛操作最短路径估计值发生变化了的顶点的边进行松弛
 */
public class BellmanByQueue {

    static int n, m;
    static int[] u = new int[10];
    static int[] v = new int[10];
    static int[] w = new int[10];
    static int first[] = new int[10];
    static int next[] = new int[10];//first数组容量要比n的最大值大1，next数组容量大1
    static int dis[] = new int[10];
    static boolean mark[] = new boolean[10];
    static int queue[] = new int[10];
    static int head = 1, tail = 1;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        dis[1] = 0;
        for (int i = 1; i <= n; i++) {
            first[i] = -1;
        }
        //建立邻接表
        for (int i = 1; i <= m; i++) {
            u[i] = scan.nextInt();
            v[i] = scan.nextInt();
            w[i] = scan.nextInt();
            next[i] = first[u[i]];
            first[u[i]] = i;
        }

        queue[tail] = 1;
        tail++;
        mark[1] = true;
        int cur;
        while (head < tail) {//队列不为空
            cur = first[queue[head]];//当前需要处理的队首顶点
            while (cur != -1) {//对与cur相邻的所有顶点进行松弛尝试
                if (dis[v[cur]] > dis[u[cur]] + w[cur]) {//判断通过松弛边后是否使源点到顶点V的路径变短
                    dis[v[cur]] = dis[u[cur]] + w[cur];
                    if (!mark[v[cur]]) {//如果当前顶点不在队列中，入队
                        queue[tail] = v[cur];
                        tail++;
                        mark[v[cur]] = true;
                    }
                }
                cur = next[cur];
            }
            //对当前顶点的所有边松弛完毕，出队
            mark[queue[head]] = false;
            head++;
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(dis[i] + " ");
        }
    }

}
