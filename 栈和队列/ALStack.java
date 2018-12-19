/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ’ª∫Õ∂”¡–;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author fx50jk
 * @param <T>
 */
public class ALStack<T> extends Stack<T>{
    private ArrayList<T> stackList=null;
    public ALStack(){
    stackList=new ArrayList<T>();
    }
    public String checkForBalance(String str)
    {
    ALStack<Character> s=new ALStack<>();
    int i=0;
    char scanCh,matchCh;
    String msg = null;
    while (i<str.length())
    {
        scanCh=str.charAt(i);
        if(scanCh=='('||scanCh=='['||scanCh=='{')
        {
            s.push(scanCh);
        }
        else if(scanCh==')'||scanCh==']'||scanCh=='}')
        {
            try {
                matchCh=s.pop();
                if(matchCh=='('&&scanCh!=')'||matchCh=='['&&scanCh!=']'||matchCh=='{'&&scanCh!='}')
                {
                msg+="*";
                return "\n"+msg+"missing left symbol";
                }
            } catch (RuntimeException e) {
                msg+="*";
                return "\n"+msg+"missing left symbol";
                
            }
            i++;
            msg+=" ";
        }
        if(s.isEmpty())
              return "\n"+msg+"Expression is balanced";
        else
        {
          msg+="*";
                return "\n"+msg+"missing right symbol";
        }
    }
   return null;
      
    }
   
}
