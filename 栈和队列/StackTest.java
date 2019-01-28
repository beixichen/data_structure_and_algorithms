/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fx50jk
 */
public class StackTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ALStack<Integer> stk=new ALStack<Integer>();
        int i;
        int intValue;
        for(i=1;i<=5;i++)
        {
            stk.push(i);
        }
        System.out.println("Stack size: "+stk.size());
        System.out.println("Poping the stack: ");
        while(!stk.isEmpty())
        {
        intValue=stk.pop();
            System.out.print(intValue+"  ");
            
        }
        // TODO code application logic here
    }
    
}
