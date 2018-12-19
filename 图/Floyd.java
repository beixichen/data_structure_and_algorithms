/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 图;

import java.util.Scanner;

/**
4 8
1 2 2
1 3 6
1 4 4
2 3 3
3 1 7
3 4 1
4 1 5
4 3 12
 * @author msy
 * 多源最短路径(稠密图效果好)时间复杂度O(N^3)  空间复杂度(N^2)
 */
public class Floyd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        int cityRoad[][] = new int[50][50];
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
        for (int k = 1; k <= n; k++) {//新增的中转节点
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    //判断经过中转节点k之后路径是否更小
                    if (cityRoad[i][k]<Integer.MAX_VALUE&&cityRoad[k][j]<Integer.MAX_VALUE&&cityRoad[i][j] > cityRoad[i][k] + cityRoad[k][j]) {
                        cityRoad[i][j] = cityRoad[i][k] + cityRoad[k][j];
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(cityRoad[i][j]+"\t");
            }
            System.out.println("");
        }
    }

}
