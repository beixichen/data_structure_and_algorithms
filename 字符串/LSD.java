/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package �ַ���;

/**
 *
 * @author fx50jk
 */
public class LSD {

    static void LSD_sort(String[] a, int w) {
        int N = a.length;
        int R = 256;
        String aux[] = new String[N];

        for (int d = w - 1; d >= 0; d--) {//���ݵ�d���ַ����м���������
            int[] count = new int[R + 1];
            for (int i = 0; i < N; i++) {//�������Ƶ��
                count[a[i].charAt(d) + 1]++;
            }
            for (int i = 0; i < R; i++) {//��Ƶ��ת��Ϊ����
                count[i + 1] += count[i];
            }
            for (int i = 0; i < N; i++) {//��Ԫ�ؽ��з���
                aux[count[a[i].charAt(d)]++] = a[i];
            }
//             for (int i = 0; i < N; i++) {//��д��a[i]��
//              a[i] = aux[i];
//            }
        }

        for (int i = 0; i < N; i++) {
            a[i] = aux[i];
            System.out.println(a[i]);
        }
    }

    static void MSD_sort(){
    
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] a = {"4PGC938", "2IYE230", "3ATW723"};
        LSD_sort(a, a[0].length());
        byte b=(byte)129;
        System.out.println(b);
    }

}
