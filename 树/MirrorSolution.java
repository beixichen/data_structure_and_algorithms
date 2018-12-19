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
public class MirrorSolution {

    /**
     * @param args the command line arguments
     */
     public void Mirror(TreeNode root) {        
        if(root==null) return;

        //交换左右子节点
        TreeNode tempNode;
        tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;

        Mirror(root.left);
        Mirror(root.right);
    }
    public static void main(String[] args) {
        // TODO code application logic here
    }

    private static class TreeNode {
        private TreeNode left;
        private TreeNode right;
    }
    
}
