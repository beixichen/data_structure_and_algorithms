/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ͼ;

import java.util.Scanner;

/**
 * 10 9 1 2 3 4 5 2 4 6 2 6 8 7 9 7 1 6 2 4
 *
 * @author msy
 */
public class findunion {

    static int fu[] = new int[1000];
    static int n, m, sum = 0;

    static int getroot(int v) {//���Ҽ���i��һ��Ԫ����һ�����ϣ���Դͷ���ݹ�ʵ�֣�
        if (fu[v] == v) {   //�������i�ĸ������Լ���˵���Լ�����Դͷ�������Լ��ı��
            return v;
        } else {//������Ҽ���i�ĸ��׵�Դͷ
            fu[v] = getroot(fu[v]);//·��ѹ����ÿ���ں������ص�ʱ�򣬽���������������Ҳ��Ϊ����ҵı��
            return fu[v];
        }
    }

    static void merge(int v, int u) {
        int temp1 = getroot(v);
        int temp2 = getroot(u);
        if (temp1 != temp2) {//�ж������ڵ��Ƿ���ͬһ��������(�Ƿ���ͬһ������)
            fu[temp2] = temp1;//���ұߵı�Ϊ��߼��ϵ��󼯺ϣ����Ҿ���·��ѹ��֮�󣬽�fu[u]�ĸ���ֵ��ֵΪv������f[temp1]��
            //����ǽ���Ƚ�С�����ӵ���Ƚϴ�ļ�����
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
            fu[i] = i;//��ʼ��
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
        System.out.println("ɭ�������ĸ�����" + sum);
    }

}
