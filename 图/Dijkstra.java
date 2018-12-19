/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ͼ;

import java.util.Scanner;

/**
 *6 9 1 2 1 1 3 12 2 3 9 2 4 3 3 5 5 4 3 4 4 5 13 4 6 15 5 6 4 �����0 1 8 4 13 17
 *1����δ֪���·���Ķ�����ѡ��һ����Դ������ģ�2�����ζ�ÿһ���߽����ɳ�dis[k] > cityRoad[temp][k] + dis[temp]
 * @author msy ��Դ���·��   ���ܽ����Ȩ�ߵ�����  ʱ�临�Ӷ�O((M+N)logN)
 * ����ʹ�öѽ����Ż� ʱ�临�ӶȿɴﵽO(MlogN)
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
            //��δ֪���·���ļ����в�������ĵ�
            for (int j = 1; j <= n; j++) {/*����ʣ��δȷ�����·���Ķ���*/
                if (mark[j] == false && dis[j] < min) {//mark==false ˵����û���ҵ����ö�������·��
                    min = dis[j];
                    temp = j;
                }
            }
            mark[temp] = true;//��ǲ��ҵ�������ĵ�
            for (int k = 1; k <= n; k++) {
                //�ж��Ƿ񾭹�����ĵ�֮���ʹԴ�㵽k�ľ������(�Զ�������ɳ�)
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
