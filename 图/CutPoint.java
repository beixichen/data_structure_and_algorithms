/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ͼ;

import java.util.Scanner;

/**���ڽӱ����洢 ʱ�临�Ӷ�ΪO(M+N)
 * ���ڽӾ���洢 ʱ�临�Ӷ�ΪO(N^2)
 * ���ֻ��Ҫ��low[v]>=num[u] �Ĵ��ڵ��ڸ�Ϊ����   ���ڵ��ڴ����v�����ܲ��������׽ڵ�u���ص�����  
 * ���ڱ�ʾ���ܹ��ص����׽ڵ�    ���ڴ��������׽ڵ㶼�ز�ȥ
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
    static int low[] = new int[10];//�������������ܹ��ص�����Сʱ���
    static boolean flag[] = new boolean[10];
    static int index;

    static void dfs(int cur, int father) {
        int child = 0;
        index++;//ʱ�����1
        num[cur] = index;//��ǰ�����ʱ���
        low[cur] = index;//��ǰ�����ܹ��������綥���ʱ���
        for (int i = 1; i <= n; i++) {
            if (e[cur][i] == 1) {
                if (num[i] == 0) {//�����ǰ�����ʱ�����Ϊ0��˵������i��û�б����ʹ�
                    child++;
                    dfs(i, cur);//����������ȱ���
                    low[cur] = Math.min(low[cur], low[i]);//���µ�ǰ����cur�ܷ���ʵİ�����Ķ����ʱ���
                    //�����ǰ���㲻�Ǹ��ڵ㣬��������low[i]>=num[cur](�������ڲ��������׽ڵ�ͻص�����)����ǰ����Ϊ���
                    if (cur != root && low[i] >= num[cur]) {
                        flag[cur] = true;
                    }
                    //�����ǰ�����Ǹ��ڵ㣬�������������ӣ��ø��ڵ���Ǹ��
                    if (cur == root && child >= 2) {
                        flag[cur] = true;
                    }
                } else if (i != father) {//�������i�����ʹ�������������㲻�ǵ�ǰ����cur�ĸ��ף�����Ҫ���µ�ǰ�ڵ��Ǹ������ʵ����綥���ʱ���
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
