/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 图;

import java.util.Scanner;

/**用邻接表来存储 时间复杂度为O(M+N)
 * 用邻接矩阵存储 时间复杂度为O(N^2)
 * 割边只需要将low[v]>=num[u] 的大于等于改为大于   大于等于代表点v不可能不经过父亲节点u返回到祖先  
 * 等于表示还能够回到父亲节点    大于代表连父亲节点都回不去
 *6 7
1 4
1 3
4 2
3 2
2 5
2 6
5 6
 * @author msy
 */
public class CutPoint {

    static int n, m, root;
    static int[][] e = new int[10][10];
    static int num[] = new int[10];
    static int low[] = new int[10];//不经过父顶点能够回到的最小时间戳
    static boolean flag[] = new boolean[10];
    static int index;

    static void dfs(int cur, int father) {
        int child = 0;
        index++;//时间戳加1
        num[cur] = index;//当前顶点的时间戳
        low[cur] = index;//当前顶点能够访问最早顶点的时间戳
        for (int i = 1; i <= n; i++) {
            if (e[cur][i] == 1) {
                if (num[i] == 0) {//如果当前顶点的时间戳不为0，说明顶点i还没有被访问过
                    child++;
                    dfs(i, cur);//继续往下深度遍历
                    low[cur] = Math.min(low[cur], low[i]);//更新当前顶点cur能否访问的傲最早的顶点的时间戳
                    //如果当前顶点不是根节点，并且满足low[i]>=num[cur](不可能在不经过父亲节点就回到祖先)，则当前顶点为割点
                    if (cur != root && low[i] >= num[cur]) {
                        flag[cur] = true;
                    }
                    //如果当前顶点是根节点，必须有两个儿子，该根节点才是割点
                    if (cur == root && child >= 2) {
                        flag[cur] = true;
                    }
                } else if (i != father) {//如果顶点i被访问过，并且这个顶点不是当前顶点cur的父亲，则需要更新当前节点那个狗访问到最早顶点的时间戳
                    low[cur] = Math.min(low[cur], num[i]);
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                e[i][j] = 0;
            }
        }
        int a, b;
        for (int i = 1; i <= m; i++) {
            a = scan.nextInt();
            b = scan.nextInt();

            e[a][b] = 1;
            e[b][a] = 1;
        }
        root = 1;
        dfs(1, root);
        for (int i = 1; i <= n; i++) {
            if (flag[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
