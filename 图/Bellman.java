/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ͼ;

import java.util.Scanner;

/**
 *�������� :
5 5
2 3 2
1 2 -3
1 5 5 
4 5 2
3 4 3
 * @author msy   ʱ�临�Ӷ�O(MN)���Դ���Ȩ���   �����ö��н����Ż�
 * �������n-1���ɳ�֮���ܹ��ɳڣ���˵��������Ȩ��·
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
        for (int i = 1; i < n; i++) {//����n-1���ɳڣ���һ���ɳ�ʱ�൱��ֻ�ܾ���һ���ߵ�����������㣬�ڼ��ξ�����ྭ��������
            for (int j = 1; j <= m; j++) {//��ÿһ���߽����ɳ�(����ʹ�ö����Ż���ÿ��ֻ�����·���仯�˵Ķ�������ɳ�)
                if (dis[u[j]]!=Integer.MAX_VALUE&&dis[v[j]] > (dis[u[j]] + w[j])) {
                    dis[v[j]] = dis[u[j]] + w[j];
                }
            }
        }
        //��⸺Ȩ��·
        for (int i = 1; i <= m; i++) {
          if (dis[u[i]]!=Integer.MAX_VALUE&&dis[v[i]] > (dis[u[i]] + w[i])) {
                    dis[v[i]] = dis[u[i]] + w[i];
                    System.out.println("�и�Ȩ��·����");
                }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(dis[i] + " ");
        }
    }

}
