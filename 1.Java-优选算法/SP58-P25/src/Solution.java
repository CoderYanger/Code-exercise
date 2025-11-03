/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-12
 * Time: 21:34
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        //自己大致写了一遍，又看了看书，然后找AI改了改
        ListNode cur=head;int n=0;
        while(cur!=null){
            n++;
            cur=cur.next;
        }
        n/=k;
        ListNode newhead=new ListNode(0);
        ListNode prev=newhead;cur=head;
        while(n>0){
            ListNode tmp=cur;
            for(int j=0;j<k;j++){
                if(cur!=null){
                    ListNode next=cur.next;
                    cur.next=prev.next;
                    prev.next=cur;
                    cur=next;
                }
            }
            prev=tmp;
            n--;
        }
        if(cur!=null) prev.next=cur;
        return newhead.next;
    }
}