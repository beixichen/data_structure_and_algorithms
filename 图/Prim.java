/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ͼ;

import java.util.Scanner;

/**
 *1������ѡ��һ��������뵽��������
 * 2��������ÿ�����㵽ÿһ�������������̵ı߼��뵽��������
 * 3���ظ�n-1�ν����ж������
 * @author msy   
 * ʱ�临�Ӷ�O(N^2)    ���ڽӱ�洢O(MlogN)
 */
public class Prim {

    static int n,m,min;
    static int e[][]=new int[100][100];
    static int dis[]=new int[100];
    static boolean mark[]=new boolean[100];
    static int count=0,sum=0;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        m=scan.nextInt();
        int a,b,c;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i==j) {
                    e[i][j]=0;
                }else{
                    e[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 1; i <= m; i++) {
            a=scan.nextInt();
            b=scan.nextInt();
            c=scan.nextInt();
            e[a][b]=c;
            e[b][a]=c;
        }
        //��ʼ��dis���飬��ǰ��������ֻ����1�Ŷ��㣬����ֵ��Ϊ1�Ŷ��㵽��������ĳ�ʼ���룬������ܵ��ＴΪ�����
        for (int i = 1; i <= n; i++) {//dis����һֱ����ʾ��ǰ�������еĶ��㵽�����������̾���
            dis[i]=e[1][i];
        }
        mark[1]=true;
        count++;
        int temp=0;
        while (count<n) {            
            min=Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                if (mark[i]==false&&dis[i]<min) {//�ҵ�dis�����е���Сֵ�����ҵ���������������Ķ���
                    min=dis[i];
                    temp=i;
                }
            }
            mark[temp]=true;
            count++;
            sum+=dis[temp];
            System.out.print(dis[temp]+"  ");
            for (int i = 1; i <= n; i++) {//������������ÿһ����������ľ���
                if (mark[i]==false&&dis[i]>e[temp][i]) {//����ڵ�temp����������ľ����С�����dis
                    dis[i]=e[temp][i];
                }
            }
            
        }
          System.out.println("\n��С��������·����Ϊ��"+sum);
    }
  
}
