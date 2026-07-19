/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-06-16
 * Time: 18:27
 */

import java.util.ArrayList;

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
    //2130. 链表最大孪生和
    //解法一：双指针
    public int pairSum(ListNode head) {
        List<Integer> list=new ArrayList<>();
        //记录最大值
        int mx=0;
        ListNode cur=head;
        while(cur!=null){
            list.add(cur.val);
            cur=cur.next;
        }
        int left=0,right=list.size()-1;
        while(left<right){
            mx=Math.max(mx,list.get(left)+list.get(right));
            left++;right--;
        }
        return mx;
    }


    //2130. 链表最大孪生和
    //解法二：递归
    private int ret;
    private ListNode left;
    public int pairSum(ListNode head) {
        left=head;
        dfs(head);
        return ret;
    }
    private void dfs(ListNode right){
        //递：先把right移到链表末尾
        if(right.next!=null) dfs(right.next);
        //归：从右到左遍历链表
        ret=Math.max(ret,left.val+right.val);
        left=left.next;
        //归：right会往左走
    }


    //2130. 链表最大孪生和
    //解法三：迭代
    public int pairSum(ListNode head){
        ListNode mid=middleNode(head);
        ListNode head2=reverseList(mid);
        int ret=0;
        while(head2!=null){
            ret=Math.max(ret,head.val+head2.val);
            head=head.next;
            head2=head2.next;
        }
        return ret;
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
