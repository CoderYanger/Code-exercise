/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-10
 * Time: 09:54
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //吴小哲的思路比之前的简单太多了
        ListNode cur1=l1,cur2=l2;
        ListNode newhead=new ListNode(0);//哨兵节点
        ListNode cur=newhead;
        int t=0;
        while(cur1!=null||cur2!=null||t>0){
            if(cur1!=null) { t+=cur1.val;cur1=cur1.next;}
            if(cur2!=null) { t+=cur2.val;cur2=cur2.next;}
            cur.next=new ListNode(t%10);
            cur=cur.next;
            t/=10;
        }
        return newhead.next;
    }
}