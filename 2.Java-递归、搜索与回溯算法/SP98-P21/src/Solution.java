/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-23
 * Time: 19:47
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
    //21. 合并两个有序链表
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //递归写法
        if(list1==null) return list2;
        if(list2==null) return list1;
        if(list1.val<=list2.val){list1.next=mergeTwoLists(list1.next,list2); return list1;}
        else {list2.next=mergeTwoLists(list2.next,list1);return list2;}
    }
}
