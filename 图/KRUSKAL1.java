/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ͼ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 1���Ȱ��ߵ�Ȩֵ�������� 2���������n-1����(Ҫ�Զ����Ƿ���ͨ���м�飬ʹ�ò��鼯���߱���)
 *
 * @author msy
 */
class Edge implements Comparable {

    public int i, j, w;

    public Edge(int i, int j, int w) {
        this.i = i;
        this.j = j;
        this.w = w;
    }

    @Override
    public int compareTo(Object o) {
        Edge to = (Edge) o;
        if (this.w > to.w) {
            return 1;
        } else if (this.w == to.w) {
            return 0;
        } else {
            return -1;
        }

    }

    @Override
    public String toString() {
        return "start=" + i + "||end=" + j + "||w=" + w;
    }
}

public class KRUSKAL1 {

    /**
     * ����С����Kruskal�㷨 �㷨˼�룺��³˹�����㷨����һ��;�������е���С��������������ͨ��N=(V,{E})������
     * ��С�������ĳ�ʦ״̬Ϊֻ��n��������ޱߵķ���ͨͼT=(V,{})��;��ÿ�������Գ�һ����ͨ������
     * ��E��ѡ�������С�ıߣ����ñ��·��Ķ�������T�в�ͬ����ͨ�����ϣ��򽫴˱߼��뵽T�У�������ȥ�˱�
     * ��ѡ����һ����С�ıߡ��Դ����ƣ�ֱ��T�����еĶ��㶼��ͬһ��ͨ������Ϊֹ��
     *
     * @param V ͼ�еĽڵ㼯��
     * @param E ͼ�бߵļ���
     */
    public static void KRUSKAL(int[] V, Edge[] E) {
        Arrays.sort(E);//���߰���Ȩ��w��������  
        ArrayList<HashSet> sets = new ArrayList<>();
        for (int i = 0; i < V.length; i++) {
            HashSet set = new HashSet();
            set.add(V[i]);
            sets.add(set);
        }

        System.out.println("++++++++++++++++++++++size=" + sets.size());
        for (int i = 0; i < E.length; i++) {
            int start = E[i].i, end = E[i].j;
            int counti = -1, countj = -2;
            for (int j = 0; j < sets.size(); j++) {
                HashSet set = sets.get(j);
                if (set.contains(start)) {
                    counti = j;
                }

                if (set.contains(end)) {
                    countj = j;
                }
            }
            if (counti < 0 || countj < 0) {
                System.err.println("û�����������ҵ��ڵ㣬����");
            }

            if (counti != countj) {
                System.out.println("���start=" + start + "||end=" + end + "||w=" + E[i].w);
                HashSet setj = sets.get(countj);
                sets.remove(countj);
                HashSet seti = sets.get(counti);
                sets.remove(counti);
                seti.addAll(setj);
                sets.add(seti);
            } else {
                System.out.println("������һ�������У��������start=" + start + "||end=" + end + "||w=" + E[i].w);

            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] V = {1, 2, 3, 4, 5, 6};
        Edge[] E = new Edge[10];
        E[0] = new Edge(1, 2, 6);
        E[1] = new Edge(1, 3, 1);
        E[2] = new Edge(1, 4, 5);
        E[3] = new Edge(2, 3, 5);
        E[4] = new Edge(2, 5, 3);
        E[5] = new Edge(3, 4, 5);
        E[6] = new Edge(3, 5, 6);
        E[7] = new Edge(3, 6, 4);
        E[8] = new Edge(4, 6, 2);
        E[9] = new Edge(5, 6, 6);
        KRUSKAL(V, E);
    }

}
