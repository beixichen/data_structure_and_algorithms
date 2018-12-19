/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package 树;

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
     * 根据前序遍历和中序遍历重建二叉树子树 
     * @param preOrder 前序遍历数组 
     * @param start 子树起始位置 
     * @param inOrder 中序遍历数组 
     * @param end 中序遍历结束位置 
     * @param length 子树节点树 
     * @return 子树的根节点 
     */  
    public static Node buildTree(char[] preOrder, int start,  char[] inOrder, int end, int length) {  
        //参数验证  
        if (preOrder == null || preOrder.length == 0 || inOrder == null  
                || inOrder.length == 0 || length <= 0) {  
            return null;  
        }  
          
        //建立子树根节点  
        char value = preOrder[start];  
        Node root = new Node();  
        root.val = value;  
          
        //递归终止条件：子树只有一个节点  
        if (length == 1)  
            return root;  
          
        //分拆子树的左子树和右子树  
        int i = 0;  
        while (i < length) {  
            if (value == inOrder[end - i]) {  
                break;  
            }  
            i++;  
        }      
        //建立子树的左子树  
        root.left = buildTree(preOrder, start + 1, inOrder, end - i - 1, length - 1 - i);  
        //建立子树的右子树  
        root.right = buildTree(preOrder, start + length - i, inOrder, end, i );  
          
        return root;  
    }  
    
     //将二叉树先序遍历，用于测试结果
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
    //将二叉树中序遍历，用于测试结果
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
  //将二叉树后序遍历，用于测试结果
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
          System.out.print("先序遍历结果:  {");
        preTraverseBinTree(tree);
        System.out.println("}");
        System.out.print("中序遍历结果:  {");
        inTraverseBinTree(tree);
        System.out.println("}");
        System.out.print("后序遍历结果:  {");
        postTraverseBinTree(tree);
        System.out.println("}");
    }  
}  
