/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 图;

import java.util.Scanner;

/**
 * 1、先按边的权值进行排序
 * 2、依次从剩余的边中选择权值较小且边的两个顶点不再同一个集合(不连通)的边(要对顶点是否连通进行检查，使用并查集(不相交集合)或者遍历)
 *6 9
2 4 11
3 5 13
4 6 3
5 6 4
2 3 6
4 5 7
1 2 1
3 4 9
1 3 2
 * @author msy
 * 时间复杂度 O(MlogM+MlogN)快速排序和找出边
 * 最小生成树，最少的边来让图连通，任意两点都可以互相到达
 */
class Kruskaledge {

    int u;
    int v;
    int w;

}

public class Kruskal {

    static int sum = 0, count = 0;
    static int n, m;
    static Kruskaledge[] e = new Kruskaledge[100];
    static int[] findunion = new int[100];



    static void quickSort(int left, int right) {
        if (left > right) {
            return;
        }
        Kruskaledge t;
        int low = left;
        int high = right;
        while (low < high) {
            while (e[high].w >= e[left].w && low < high) {
                high--;
            }
            while (e[low].w <= e[left].w && low < high) {
                low++;
            }

            if (low < high) {
                t = e[low];
                e[low] = e[high];
                e[high] = t;
            }
        }
        t = e[left];
        e[left] = e[low];
        e[low] = t;
        quickSort(left, low - 1);
        quickSort(low + 1, right);

    }

    //并查集查找祖先
    static int findroot(int v) {
        if (findunion[v] == v) {
            return v;
        } else {
            findunion[v] = findroot(findunion[v]);//进行路径压缩
            return findunion[v];
        }
    }

    static boolean merge(int v, int u) {
        int temp1, temp2;
        temp1 = findroot(v);
        temp2 = findroot(u);
        if (temp1 != temp2) {//不在一个集合中
            findunion[temp2] = temp1;
            return true;
        }
        return false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        for (int i = 1; i <= m; i++) {
            e[i] = new Kruskaledge();
        }
        for (int i = 1; i <= m; i++) {
            e[i].u = scan.nextInt();
            e[i].v = scan.nextInt();
            e[i].w = scan.nextInt();
        }
        quickSort(1, m);

        for (int i = 1; i <= n; i++) {
            findunion[i] = i;//初始化并查集
        }

        for (int i = 1; i <= m; i++) {//从小到大枚举
            if (merge(e[i].u, e[i].v)) {//判断两个顶点是否已经连通
                count++;
                sum += e[i].w;
            }
            if (count == n - 1) {
                break;
            }
        }

        System.out.println(sum);
    }

}
