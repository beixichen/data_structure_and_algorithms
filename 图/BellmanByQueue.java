/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ͼ;

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
 * ÿ�ν���ǰһ���ɳڲ������·������ֵ�����仯�˵Ķ���ı߽����ɳ�
 */
public class BellmanByQueue {

    static int n, m;
    static int[] u = new int[10];
    static int[] v = new int[10];
    static int[] w = new int[10];
    static int first[] = new int[10];
    static int next[] = new int[10];//first��������Ҫ��n�����ֵ��1��next����������1
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
        //�����ڽӱ�
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
        while (head < tail) {//���в�Ϊ��
            cur = first[queue[head]];//��ǰ��Ҫ����Ķ��׶���
            while (cur != -1) {//����cur���ڵ����ж�������ɳڳ���
                if (dis[v[cur]] > dis[u[cur]] + w[cur]) {//�ж�ͨ���ɳڱߺ��Ƿ�ʹԴ�㵽����V��·�����
                    dis[v[cur]] = dis[u[cur]] + w[cur];
                    if (!mark[v[cur]]) {//�����ǰ���㲻�ڶ����У����
                        queue[tail] = v[cur];
                        tail++;
                        mark[v[cur]] = true;
                    }
                }
                cur = next[cur];
            }
            //�Ե�ǰ��������б��ɳ���ϣ�����
            mark[queue[head]] = false;
            head++;
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(dis[i] + " ");
        }
    }

}
