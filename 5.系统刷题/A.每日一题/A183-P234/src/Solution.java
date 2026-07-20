/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-06-16
 * Time: 18:28
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
    //234. 回文链表
    //解法一：双指针+顺序表
    public boolean isPalindrome(ListNode head) {
        List<Integer> list=new ArrayList<>();
        ListNode cur=head;
        while(cur!=null){
            list.add(cur.val);
            cur=cur.next;
        }
        int left=0,right=list.size()-1;
        while(left<right){
            if(list.get(left)!=list.get(right)) return false;
            left++;right--;
        }
        return true;
    }


    //234. 回文链表
    //解法二：递归
    private ListNode left;
    public boolean isPalindrome(ListNode head) {
        left=head;
        return dfs(head);
    }
    private boolean dfs(ListNode right){
        //递：先把right移到链表末尾
        if(right.next!=null&&!dfs(right.next)) return false;
        //归：从右到左遍历链表
        if(left.val!=right.val) return false;
        //left 往右走
        left=left.next;
        //归：right会往左走
        return true;
    }

    //234. 回文链表
    //解法三：递归
    public boolean isPalindrome(ListNode head) {
        ListNode mid=middleNode(head);
        ListNode head2=reverseList(mid);
        while(head2!=null){
            if(head.val!=head2.val) return false;
            head=head.next;
            head2=head2.next;
        }
        return true;
    }
    //876.链表的中间结点
    private ListNode middleNode(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    //206.反转链表
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode nxt=cur.next;
            cur.next=pre;
            pre=cur;
            cur=nxt;
        }
        return pre;
    }
}
