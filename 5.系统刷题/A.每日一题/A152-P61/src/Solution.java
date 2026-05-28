/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-10
 * Time: 19:17
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
    //61. 旋转链表
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return null;
        //计算长度，找尾结点
        int len=1;
        ListNode tail=head;
        while(tail.next!=null){
            len++;
            tail=tail.next;
        }
        k%=len;
        //首尾相连
        tail.next=head;
        //找到最终头节点的前一个节点
        ListNode newtail=head;
        for(int i=0;i<len-k-1;i++) newtail=newtail.next;
        //断开第k-1个节点和第k个节点
        ListNode newhead=newtail.next;
        newtail.next=null;
        return newhead;
    }
}