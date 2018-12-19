/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package 栈和队列;

import java.util.Stack;

/**
 *
 * @author fx50jk
 */
//判断一个数组是不是出栈顺序
public class outStack {
    
    static boolean IsPopOrder(int [] pushA,int [] popA) {
      if(pushA.length==0 || popA.length==0){
          return false;
      }
      Stack<Integer> stack = new Stack<Integer>();
      int j=0;
      for(int i=0;i<pushA.length;i++){
          stack.push(pushA[i]);
          while(j<popA.length && stack.peek()==popA[j]){
              j++;
              stack.pop();
          }
      }
      return stack.isEmpty();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int []a={1,2,3,4,5};
        int []b={3,4,2,5,1};
        System.out.println(IsPopOrder(a, b));
    }
    
}
