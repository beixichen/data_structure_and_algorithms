/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package 图;

import java.util.Scanner;

/**
5 7 1 5
1 2
1 3
2 3
2 4
3 4
3 5
4 5
 * @author msy  
 * 广度优先更适用于权值相同的情况
 * 最小转机问题
 */
public class MinTransit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        class Node{
            int x;
            int count;
        }
        Node [] node=new Node[100];
        for (int i = 0; i < 100; i++) {
            node[i]=new Node();
        }
        Scanner scan=new Scanner(System.in);
        int cityAir[][]=new int[50][50];
        boolean mark[]=new boolean[50];
        int head,tail,cur;
        int startCity,endCity;
        boolean flag=false;
        int n = scan.nextInt();//n个城市
        int m = scan.nextInt();//m条道路
         startCity=scan.nextInt();
        endCity=scan.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    cityAir[i][j] = 0;
                } else {
                    cityAir[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 1; i <= m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
           
            cityAir[a][b] = 1;
            cityAir[b][a] = 1;
        }
       
        head=1;
        tail=1;
        node[tail].x=startCity;
        node[tail].count=0;
        tail++;
        mark[1]=true;
        while (head<tail) {            
            cur=node[head].x;//队首城市编号
            for (int i = 1; i <=n; i++) {//从1-n依次尝试
                //判断从城市cur到城市i是否有航班且判断城市i是否已在队列中
                if (cityAir[cur][i]!=Integer.MAX_VALUE&&mark[i]==false) {
                    //有航班且不在队列中，将i城市入队
                    node[tail].x=i;
                    node[tail].count=node[head].count+1;
                    tail++;
                    mark[i]=true;
                }
                //如果到达目标城市那么就结束查找
                if (node[tail-1].x==endCity) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
            head++;
        }
        System.out.println(node[tail-1].count);
    }
    
}
