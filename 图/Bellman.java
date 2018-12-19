/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 图;

import java.util.Scanner;

/**
 *测试用例 :
5 5
2 3 2
1 2 -3
1 5 5 
4 5 2
3 4 3
 * @author msy   时间复杂度O(MN)可以处理负权情况   可以用队列进行优化
 * 如果进行n-1次松弛之后还能够松弛，则说明包括负权回路
 */
public class Bellman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        int dis[] = new int[50];
        int u[] = new int[50];
        int v[] = new int[50];
        int w[] = new int[50];
        int n = scan.nextInt();
        int m = scan.nextInt();
        for (int i = 1; i <= m; i++) {
            u[i] = scan.nextInt();
            v[i] = scan.nextInt();
            w[i] = scan.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        dis[1] = 0;
        for (int i = 1; i < n; i++) {//进行n-1次松弛，第一轮松弛时相当于只能经过一条边到达其余各顶点，第几次就是最多经过几条边
            for (int j = 1; j <= m; j++) {//对每一条边进行松弛(可以使用队列优化，每次只对最短路径变化了的顶点进行松弛)
                if (dis[u[j]]!=Integer.MAX_VALUE&&dis[v[j]] > (dis[u[j]] + w[j])) {
                    dis[v[j]] = dis[u[j]] + w[j];
                }
            }
        }
        //检测负权回路
        for (int i = 1; i <= m; i++) {
          if (dis[u[i]]!=Integer.MAX_VALUE&&dis[v[i]] > (dis[u[i]] + w[i])) {
                    dis[v[i]] = dis[u[i]] + w[i];
                    System.out.println("有负权回路。。");
                }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(dis[i] + " ");
        }
    }

}
