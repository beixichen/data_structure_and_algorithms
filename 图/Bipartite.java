/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package 图;

import java.util.Scanner;

/**
 *二分图的最大匹配
 * 6 5
1 4
1 5
2 5
2 6
3 4
 * @author msy
 */
public class Bipartite {

    static int e[][]=new int[100][100];
    static int []match=new int[100];
    static boolean []mark=new boolean[100];
    static int n,m;
    static boolean dfs(int u){
        for (int i = 1; i <= n; i++) {
            if (mark[i]==false&&e[u][i]==1) {
                mark[i]=true;
                //如果点i未被配对或者已经找到了新的配对
                if (match[i]==0||dfs(match[i])) {
                    match[i]=u;
                    match[u]=i;
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        m=scan.nextInt();
        int sum=0;
        int x,y;
        for (int i = 1; i <= m; i++) {
            x=scan.nextInt();
            y=scan.nextInt();
            e[x][y]=1;
            e[y][x]=1;
        }
        for (int i = 1; i <= n; i++) {
            match[i]=0;
        }
        for (int i = 1; i <= n; i++) {
            for(int j=1;j<=n;j++){
                mark[j]=false;
            }
            if (dfs(i)) {
                sum++;
            }
        }
        System.out.println(sum);
    }
    
}
