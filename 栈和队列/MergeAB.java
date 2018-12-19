/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ’ª∫Õ∂”¡–;

/**
 *
 * @author fx50jk
 */

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;

        ListNode mergeHead=null;
        if(list1.val<=list2.val){
            mergeHead = list1;
            mergeHead.next = Merge(list1.next,list2);
        }else{
            mergeHead = list2;
            mergeHead.next = Merge(list1,list2.next);
        }
        return mergeHead;
    }
}

 
public class MergeAB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Solution().Merge(null, null);
    }
    
}
