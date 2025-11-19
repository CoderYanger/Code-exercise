/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-23
 * Time: 19:49
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
    //206. 反转链表
    public ListNode reverseList(ListNode head) {
        //递归出口：空链表或者单链表无需逆置，直接返回
        if(head==null||head.next==null) return head;
        //将此节点后面的逆置
        ListNode newhead=reverseList(head.next);
        //原本当前节点的下一个连接到自己
        head.next.next=head;
        //自己的下一个置空
        head.next=null;
        return newhead;
    }
}