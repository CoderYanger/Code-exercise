/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-08-09
 * Time: 11:25
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
    //21. 合并两个链表
    /*将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    示例 1：
    输入：l1 = [1,2,4], l2 = [1,3,4]
    输出：[1,1,2,3,4,4]
    示例 2：
    输入：l1 = [], l2 = []
    输出：[]
    示例 3：
    输入：l1 = [], l2 = [0]
    输出：[0]
    提示：
    两个链表的节点数目范围是 [0, 50]
            -100 <= Node.val <= 100
    l1 和 l2 均按 非递减顺序 排列*/
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newhead=new ListNode(-1);
        ListNode tmp=newhead;
        //二者指向同一处地址，tmp记录尾节点
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                tmp.next=list1;
                list1=list1.next;
                tmp=tmp.next;
            }else{
                tmp.next=list2;
                list2=list2.next;
                tmp=tmp.next;
            }
        }
        if(list1!=null){
            tmp.next=list1;
        }else{
            tmp.next=list2;
        }
        return newhead.next;
    }
}