/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 图;

import java.util.Scanner;

/**
 * 10 9 1 2 3 4 5 2 4 6 2 6 8 7 9 7 1 6 2 4
 *
 * @author msy
 */
public class findunion {

    static int fu[] = new int[1000];
    static int n, m, sum = 0;

    static int getroot(int v) {//查找集合i（一个元素是一个集合）的源头（递归实现）
        if (fu[v] == v) {   //如果集合i的父亲是自己，说明自己就是源头，返回自己的标号
            return v;
        } else {//否则查找集合i的父亲的源头
            fu[v] = getroot(fu[v]);//路径压缩，每次在函数返回的时候，将遇到的其他对象也改为最后找的编号
            return fu[v];
        }
    }

    static void merge(int v, int u) {
        int temp1 = getroot(v);
        int temp2 = getroot(u);
        if (temp1 != temp2) {//判断两个节点是否在同一个集合中(是否有同一个祖先)
            fu[temp2] = temp1;//将右边的变为左边集合的左集合，并且经过路径压缩之后，将fu[u]的根的值赋值为v的祖先f[temp1]。
            //最好是将深度较小的连接到深度较大的集合中
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
            fu[i] = i;//初始化
        }
        int x, y;
        for (int i = 1; i <= m; i++) {
            x = scan.nextInt();
            y = scan.nextInt();
            merge(x, y);
        }

        for (int i = 1; i <= n; i++) {
            if (fu[i] == i) {
                sum++;
            }
        }
        System.out.println("森林中树的个数：" + sum);
    }

}
