/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-06-16
 * Time: 19:42
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
    //2095. 删除链表的中间节点
    public ListNode deleteMiddle(ListNode head) {
        //只有一个节点
        if(head.next==null) return null;
        //876.链表的中间结点
        //本题先让快指针走两步，慢指针少走一步，这样最终刚好落在中间节点的前一个节点
        ListNode fast=head.next.next,slow=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow.next=slow.next.next;//删除slow的下一个
        return head;
    }
}
