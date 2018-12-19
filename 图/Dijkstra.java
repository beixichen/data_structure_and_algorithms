/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 图;

import java.util.Scanner;

/**
 *6 9 1 2 1 1 3 12 2 3 9 2 4 3 3 5 5 4 3 4 4 5 13 4 6 15 5 6 4 结果：0 1 8 4 13 17
 *1、在未知最短路径的顶点中选择一个离源点最近的，2、依次对每一条边进行松弛dis[k] > cityRoad[temp][k] + dis[temp]
 * @author msy 单源最短路径   不能解决负权边的问题  时间复杂度O((M+N)logN)
 * 可以使用堆进行优化 时间复杂度可达到O(MlogN)
 */
public class Dijkstra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        int cityRoad[][] = new int[50][50];
        boolean mark[] = new boolean[50];
        int dis[] = new int[50];
        int min;
        int n = scan.nextInt();
        int m = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    cityRoad[i][j] = 0;
                } else {
                    cityRoad[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 1; i <= m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int len = scan.nextInt();
            cityRoad[a][b] = len;
        }
        for (int i = 1; i <= n; i++) {
            dis[i] = cityRoad[1][i];
        }
        mark[1] = true;
        int temp = 0;
        for (int i = 1; i < n; i++) {
            min = Integer.MAX_VALUE;
            //在未知最短路径的集合中查找最近的点
            for (int j = 1; j <= n; j++) {/*查找剩余未确定最短路径的顶点*/
                if (mark[j] == false && dis[j] < min) {//mark==false 说明还没有找到到该顶点的最短路径
                    min = dis[j];
                    temp = j;
                }
            }
            mark[temp] = true;//标记查找到的最近的点
            for (int k = 1; k <= n; k++) {
                //判断是否经过最近的点之后会使源点到k的距离更短(对顶点进行松弛)
                if (cityRoad[temp][k] != Integer.MAX_VALUE && dis[k] > cityRoad[temp][k] + dis[temp]) {
                    dis[k] = cityRoad[temp][k] + dis[temp];
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(dis[i] + " ");
        }
    }

}
