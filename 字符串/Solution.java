import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public static boolean Find(int target, int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        if (array != null && rows > 0 && cols > 0) {
            int row = 0;
            int col = cols - 1;
            while (row < rows && col >= 0) {
                if (array[row][col] == target) {
                    return true;
                } else if (array[row][col] > target) {
                    col--;
                } else {
                    row++;
                }
            }
        }
        return false;
    }

    public static boolean Find2(int target, int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        if (array != null && rows > 0 && cols > 0) {
            int row = rows - 1;
            int col = 0;
            while (row >= 0 && col < cols) {
                if (array[row][col] == target) {
                    return true;
                } else if (array[row][col] > target) {
                    row--;
                } else {
                    col++;
                }
            }
        }
        return false;
    }


    public String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }

//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//
//        Stack<Integer> stack = new Stack<>();
//        ArrayList<Integer> arrayList =new ArrayList<>();
//        while(listNode!=null){
//            stack.push(listNode.val);
//            listNode = listNode.next;
//        }
//        if(!stack.isEmpty()){
//            arrayList.add(stack.pop());
//        }
//        return arrayList;
//
//    }

    ArrayList<Integer> arrayList = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        if (listNode != null) {
            this.printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }
    //0 1 1 2 3

    public static int fib(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static int Fibonacci(int n) {
        int a = 0;
        int b = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;

    }

    public static int minNumberInRotateArray(int[] array) {
        int len = array.length;
        int temp;
        if (len == 0) {
            return 0;
        }
        for (int i = 0; i < len / 2; i++) {
            temp = array[i];
            array[i] = array[len - i - 1];
            array[len - i - 1] = temp;
        }
        int min = array[0];
        for (int i = 0; i < len; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }

        return count;
    }


    public static void BTD(int n, int x) {
//        while(n!=0){
//            int temp=n%x;
//            n=n/x;
//            System.out.print(temp);
//        }
        if (n != 0) {
            int temp = n % x;
            BTD(n / x, x);
            if (temp < 10) {
                System.out.print(temp);
            } else {
                System.out.print(temp + 10 - 'A');
            }
        }

    }

    public static int MoreThanHalfNum_Solution(int[] array) {
        int count = 1;
        int temp = array[0];
        for (int i = 1; i < array.length; i++) {
            if (temp == array[i]) {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                temp = array[i];
                count = 0;
            }
        }
        if (count > 0) {
            return temp;
        } else {
            return 0;
        }
    }


    public void reOrderArray(int[] array) {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                arrayList1.add(array[i]);
            } else {
                arrayList2.add(array[i]);
            }
        }
        for (int i = 0; i < arrayList1.size(); i++) {
            array[i] = arrayList1.get(i);
        }
        for (int i = 0; i < arrayList2.size(); i++) {
            array[i + arrayList1.size()] = arrayList2.get(i);
        }
    }

    public static void reOrderArray1(int[] array) {
        int len = array.length;
        int temp;
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j > i; j--) {
                if ((array[j] & 1) == 1 && (array[j - 1] & 1) != 1) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }


    public ListNode FindKthToTail(ListNode head,int k) {
            Stack<ListNode> stack =new Stack<>();
            while(head.next!=null){
                stack.push(head.next);
                head=head.next;
            }

            return stack.get(stack.size()-k);
//        if(head==null){
//            return null;
//        }
//        ListNode node1=head;
//        ListNode node2=head;
//
//        int count=0;
//        while(node1!=null){
//            if(count>=k){
//                node2=node2.next;
//            }
//            node1=node1.next;
//            count++;
//
//        }
//        return count < k?null:node2;
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = null;
        while (head != null) {
            result.next = head.next;
            result = head;
        }
        return  result;
    }
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode result=null;
        while(list1!=null&&list2!=null){
            if(list1.val>=list2.val){
                result=list2;
                list2=list2.next;
            }else{
                result=list1;
                list1=list1.next;
            }
            result=result.next;
        }
        if(list1!=null) {
            result = list1;
        }
        if(list2!=null){
            result=list2;
        }
        return result;
    }

//        ListNode res=head;
//        Stack<ListNode> stack =new Stack<>();
//        while(head!=null){
//            stack.push(head);
//            head=head.next;
//        }
//        ListNode temp;
//        for(int i=0;i<stack.size();i++){
//            temp=stack.pop();
//            res.next=temp.next;
//            res.next=temp;
//        }
//        return res;


    public static void main(String[] args) {
//        System.out.println(NumberOf1(3));
//        BTD(10,2);
        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(MoreThanHalfNum_Solution(array));
    }

    private class ListNode {
        ListNode next;
        int val;
    }
}
