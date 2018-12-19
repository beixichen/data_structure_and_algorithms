/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ͼ;

import java.util.Scanner;

/**
 * 1���Ȱ��ߵ�Ȩֵ��������
 * 2�����δ�ʣ��ı���ѡ��Ȩֵ��С�ұߵ��������㲻��ͬһ������(����ͨ)�ı�(Ҫ�Զ����Ƿ���ͨ���м�飬ʹ�ò��鼯(���ཻ����)���߱���)
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
 * ʱ�临�Ӷ� O(MlogM+MlogN)����������ҳ���
 * ��С�����������ٵı�����ͼ��ͨ���������㶼���Ի��ൽ��
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

    //���鼯��������
    static int findroot(int v) {
        if (findunion[v] == v) {
            return v;
        } else {
            findunion[v] = findroot(findunion[v]);//����·��ѹ��
            return findunion[v];
        }
    }

    static boolean merge(int v, int u) {
        int temp1, temp2;
        temp1 = findroot(v);
        temp2 = findroot(u);
        if (temp1 != temp2) {//����һ��������
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
            findunion[i] = i;//��ʼ�����鼯
        }

        for (int i = 1; i <= m; i++) {//��С����ö��
            if (merge(e[i].u, e[i].v)) {//�ж����������Ƿ��Ѿ���ͨ
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
