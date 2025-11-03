/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-12
 * Time: 09:02
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
    //143. 重排链表
    /*给定一个单链表 L 的头节点 head ，单链表 L 表示为：
    L0 → L1 → … → Ln - 1 → Ln
    请将其重新排列后变为：
    L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
    不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
    示例 1：
    输入：head = [1,2,3,4]
    输出：[1,4,2,3]
    示例 2：
    输入：head = [1,2,3,4,5]
    输出：[1,5,2,4,3]
    提示：
    链表的长度范围为 [1, 5 * 104]
            1 <= node.val <= 1000*/
    
    //自己费了5、6个小时，不是缺数字就是成环，被豆包和kimi当狗耍了
    public void reorderList(ListNode head) {
        if(head==null||head.next==null||head.next.next==null) return ;
        ListNode newhead= new ListNode(0);
        newhead.next=head;
        ListNode cur=head,next=cur.next;
        int count=1;
        //先找中间节点
        while(next!=null){ cur=next;next=cur.next;count++; }//此时cur即尾结点
        //计数器找到中间节点
        int l=count/2,r=count-l;
        ListNode left=newhead.next;
        while(l>1){left=left.next;l--;}
        ListNode mid=left.next,newhead2=new ListNode(0),cur2=mid;//newhead2作后半部分的哨兵节点，cur2作待插入节点
        left.next=null;//分开
        ListNode next2=cur2.next;
        //后半部分的逆序
        newhead2.next=null;
        while(r>0&&cur2!=null){
            next2=cur2.next;//拿next2记录防丢
            cur2.next=newhead2.next;
            newhead2.next=cur2;
            cur2=next2;//cur2往后移动
            r--;
        }
        //合并两个链表
        ListNode cur1=newhead.next;cur2=newhead2.next;
        ListNode newHead=new ListNode(0);
        newHead.next=cur1;
        while(cur2!=null){
            ListNode next1=cur1.next;
            if(next1==null){
                cur1.next=cur2;
                cur2=cur2.next;
                cur1=cur1.next;
                continue;
            }
            ListNode next3=cur2.next;
            //连接
            cur2.next=next1;
            cur1.next=cur2;
            //修改指针
            cur1=next1;
            cur2=next3;
        }
        return;
    }
    public void reorderList(ListNode head) {
        if(head==null||head.next==null||head.next.next==null) return ;
        ListNode fast=head,slow=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //逆序
        ListNode newhead2=new ListNode(0);
        ListNode cur=slow.next;
        slow.next=null;//将链表断开
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=newhead2.next;
            newhead2.next=cur;
            cur=next;
        }
        //合并
        ListNode ret=new ListNode(0),prev=ret;
        ListNode cur1=head,cur2=newhead2.next;
        while(cur1!=null){
            prev.next=cur1;
            prev=cur1;
            cur1=cur1.next;
            if(cur2!=null){
                prev.next=cur2;
                prev=cur2;
                cur2=cur2.next;
            }
        }
    }
    }