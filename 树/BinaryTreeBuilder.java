/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ��;

/**
 *
 * @author fx50jk
 */
class Node {  
    Node left = null;  
    Node right = null;  
    char val;  
}  
public class BinaryTreeBuilder {  
    /** 
     * ����ǰ���������������ؽ����������� 
     * @param preOrder ǰ��������� 
     * @param start ������ʼλ�� 
     * @param inOrder ����������� 
     * @param end �����������λ�� 
     * @param length �����ڵ��� 
     * @return �����ĸ��ڵ� 
     */  
    public static Node buildTree(char[] preOrder, int start,  char[] inOrder, int end, int length) {  
        //������֤  
        if (preOrder == null || preOrder.length == 0 || inOrder == null  
                || inOrder.length == 0 || length <= 0) {  
            return null;  
        }  
          
        //�����������ڵ�  
        char value = preOrder[start];  
        Node root = new Node();  
        root.val = value;  
          
        //�ݹ���ֹ����������ֻ��һ���ڵ�  
        if (length == 1)  
            return root;  
          
        //�ֲ���������������������  
        int i = 0;  
        while (i < length) {  
            if (value == inOrder[end - i]) {  
                break;  
            }  
            i++;  
        }      
        //����������������  
        root.left = buildTree(preOrder, start + 1, inOrder, end - i - 1, length - 1 - i);  
        //����������������  
        root.right = buildTree(preOrder, start + length - i, inOrder, end, i );  
          
        return root;  
    }  
    
     //��������������������ڲ��Խ��
    public static void preTraverseBinTree(Node node){
        if (node==null) {
              return;
          }
        System.out.print(node.val+"\t");
        if (node.left!=null) {
            preTraverseBinTree(node.left);
          }
        if(node.right!=null){
            preTraverseBinTree(node.right);
        }
      }
    //��������������������ڲ��Խ��
    public static void inTraverseBinTree(Node node){
        if (node==null) {
              return;
          }
        if (node.left!=null) {
            inTraverseBinTree(node.left);
          }
        System.out.print(node.val+"\t");
        if(node.right!=null){
            inTraverseBinTree(node.right);
        }
      }
  //��������������������ڲ��Խ��
    public static void postTraverseBinTree(Node node){
        if (node==null) {
              return;
          }
        if (node.left!=null) {
            postTraverseBinTree(node.left);
          }
        if(node.right!=null){
            postTraverseBinTree(node.right);
        }
        System.out.print(node.val+"\t");
      }
    public static void main(String[] args) {  
        char[] preOrder = new char[] {'a', 'b', 'd', 'c', 'e', 'f'};  
        char[] inOrder = new char[] {'d', 'b', 'a', 'e', 'c', 'f'};  
        Node tree = buildTree(preOrder, 0, inOrder, inOrder.length - 1, inOrder.length);  
          System.out.print("����������:  {");
        preTraverseBinTree(tree);
        System.out.println("}");
        System.out.print("����������:  {");
        inTraverseBinTree(tree);
        System.out.println("}");
        System.out.print("����������:  {");
        postTraverseBinTree(tree);
        System.out.println("}");
    }  
}  
