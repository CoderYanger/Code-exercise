import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-12
 * Time: 18:39
 */
class Solution {
    //23. 合并K个升序链表
    /*给你一个链表数组，每个链表都已经按升序排列。
    请你将所有链表合并到一个升序链表中，返回合并后的链表。
    示例 1：
    输入：lists = [[1,4,5],[1,3,4],[2,6]]
    输出：[1,1,2,3,4,4,5,6]
    解释：链表数组如下：
            [
            1->4->5,
            1->3->4,
            2->6
            ]
    将它们合并到一个有序链表中得到。
            1->1->2->3->4->4->5->6
    示例 2：
    输入：lists = []
    输出：[]
    示例 3：
    输入：lists = [[]]
    输出：[]
    提示：
    k == lists.length
0 <= k <= 10^4
            0 <= lists[i].length <= 500
            -10^4 <= lists[i][j] <= 10^4
    lists[i] 按 升序 排列
    lists[i].length 的总和不超过 10^4*/

    public ListNode mergeKLists(ListNode[] lists) {//用堆写
        PriorityQueue<ListNode> heap=new PriorityQueue<>((v1, v2)->v1.val-v2.val);//此处用lambda表达式
        for(ListNode l:lists) if(l!=null) heap.offer(l);
        ListNode ret=new ListNode(0);
        ListNode prev=ret;
        while(!heap.isEmpty()){
            ListNode t=heap.poll();
            prev.next=t;
            prev=t;
            if(t.next!=null) heap.offer(t.next);
        }
        return ret.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {//用堆写
        PriorityQueue <ListNode> heap=new PriorityQueue<>(new Comparator<ListNode>(){//此处改成传比较器
            @Override
            public int compare(ListNode v1,ListNode v2){
                return v1.val-v2.val;//负数(前-后)就是小根堆，放前面的
            }
        });
        //把节点放堆里
        for(ListNode l: lists) if(l!=null) heap.offer(l);
        ListNode ret=new ListNode(0);
        ListNode prev=ret;
        while(!heap.isEmpty()){
            ListNode t=heap.poll();
            prev.next=t;
            prev=t;
            if(t.next!=null) heap.offer(t.next);
        }
        return ret.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        //递归写法，看着挺难，其实跟之前写的一样，就是把数组中的数换成链表了，多了一个合并链表的方法
        return merge(lists,0,lists.length-1);
    }
    public ListNode merge(ListNode[] lists,int left,int right){
        if(left>right) return null;
        if(left==right) return lists[left];
        int mid=(left+right)/2;
        ListNode l1=merge(lists,left,mid);
        ListNode l2=merge(lists,mid+1,right);
        return mergeTwoList(l1,l2);
    }
    public ListNode mergeTwoList(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode ret=new ListNode(0);
        ListNode prev=ret;
        ListNode cur1=l1,cur2=l2;
        while(cur1!=null&&cur2!=null){
            if(cur1.val>=cur2.val){
                prev.next=cur2;
                prev=cur2;
                cur2=cur2.next;
            }else{
                prev.next=cur1;
                prev=cur1;
                cur1=cur1.next;
            }
        }
        if(cur1!=null) prev.next=cur1;
        if(cur2!=null) prev.next=cur2;
        return ret.next;
    }
}
