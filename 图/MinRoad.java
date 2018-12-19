/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 图;

import java.util.Scanner;

/**
 * 5 8
 * 1 2 2
 * 1 5 10 2 3 3 2 5 7 3 1 4 3 4 4 4 5 5 5 3 3
 *
 * @author msy
 */
public class MinRoad {

    static int n,m,min = Integer.MAX_VALUE;
    static boolean mark[] = new boolean[100];
    static int endCity;
    static int cityRoad[][] = new int[100][100];

    static void dfs(int cur, int dis) {
        if (dis > min) {
            return;
        }
        if (cur == endCity) {//是否到达目标城市
            if (dis < min) {
                min = dis;
            }
            return;
        }
        for (int i = 1; i <= n; i++) {//从1到目标城市依次进行尝试
            //判断当前城市到i城是否有路，并且判断城市i是否已经走过
            if (cityRoad[cur][i] != Integer.MAX_VALUE && mark[i] == false) {
                mark[i] = true;
                dfs(i, dis + cityRoad[cur][i]);
                mark[i] = false;//对i的所有邻接节点探索完毕，取消对i城市的标记   返回以前的城市查找是否有别的路径，使距离更短
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();//n个城市
        m = scan.nextInt();//m条道路
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
            int dis = scan.nextInt();
            cityRoad[a][b] = dis;
        }
        mark[1] = true;
        endCity = n;
        dfs(1, 0);
        System.out.println("最短路径为："+min);
    }

}
