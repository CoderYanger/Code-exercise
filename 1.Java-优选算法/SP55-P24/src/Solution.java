/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-12
 * Time: 09:03
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
    //24. 两两交换链表中的节点
    /*给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
    你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
    示例 1：
    输入：head = [1,2,3,4]
    输出：[2,1,4,3]
    示例 2：
    输入：head = []
    输出：[]
    示例 3：
    输入：head = [1]
    输出：[1]
    提示：
    链表中节点的数目在范围 [0, 100] 内
0 <= Node.val <= 100*/
    public ListNode swapPairs(ListNode head) {//自己写一遍
        //如果没有prev直接返回原链表
        if(head==null||head.next==null) return head;
        ListNode newhead=new ListNode(0);
        newhead.next=head;
        ListNode prev=newhead,cur=prev.next,
                next=cur.next,//前提要保证有cur，所以前面加上if(head==null) return head;
                nnext=next.next;//前提要保证有next，所以在前面加上||head.next==null 也是return head;否则就引用空指针了
        while(cur!=null&&next!=null){//根据两个前提保证取的终止条件
            //不满足这俩条件的时候要么是偶数，没有要换的了，要么是奇数剩下一个，没必要换了
            //交换节点
            prev.next=next;
            next.next=cur;
            cur.next=nnext;
            //修改下一阶段的指针
            prev=cur;
            cur=nnext;//此处的nnext是上一阶段的，一定有
            if(cur!=null) next=cur.next;
            if(next!=null) nnext=next.next;
        }
        return newhead.next;
    }
}
