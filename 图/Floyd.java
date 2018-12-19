/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ͼ;

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
 * ��Դ���·��(����ͼЧ����)ʱ�临�Ӷ�O(N^3)  �ռ临�Ӷ�(N^2)
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
        for (int k = 1; k <= n; k++) {//��������ת�ڵ�
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    //�жϾ�����ת�ڵ�k֮��·���Ƿ��С
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
