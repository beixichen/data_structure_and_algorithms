/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package 图;

import java.util.Scanner;

/**
 *1、任意选择一个顶点加入到生成树中
 * 2、将树中每个顶点到每一个非树顶点的最短的边加入到生成树中
 * 3、重复n-1次将所有顶点加入
 * @author msy   
 * 时间复杂度O(N^2)    用邻接表存储O(MlogN)
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
        //初始化dis数组，当前生成树中只含有1号顶点，数组值即为1号定点到各个顶点的初始距离，如果不能到达即为无穷大
        for (int i = 1; i <= n; i++) {//dis数组一直都表示当前生成树中的顶点到非树顶点的最短距离
            dis[i]=e[1][i];
        }
        mark[1]=true;
        count++;
        int temp=0;
        while (count<n) {            
            min=Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                if (mark[i]==false&&dis[i]<min) {//找到dis数组中的最小值，就找到了离生成树最近的顶点
                    min=dis[i];
                    temp=i;
                }
            }
            mark[temp]=true;
            count++;
            sum+=dis[temp];
            System.out.print(dis[temp]+"  ");
            for (int i = 1; i <= n; i++) {//更新生成树到每一个非树顶点的距离
                if (mark[i]==false&&dis[i]>e[temp][i]) {//如果节点temp到非树顶点的距离更小则更新dis
                    dis[i]=e[temp][i];
                }
            }
            
        }
          System.out.println("\n最小生成树的路径和为："+sum);
    }
  
}
