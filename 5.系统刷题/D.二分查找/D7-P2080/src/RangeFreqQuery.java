import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-15
 * Time: 12:34
 */
class RangeFreqQuery {
    //2080. 区间内查询数字的频率
    private final Map<Integer,List<Integer>> pos=new HashMap<>();
    public RangeFreqQuery(int[] arr) {
        for(int i=0;i<arr.length;i++)
            pos.computeIfAbsent(arr[i],k->new ArrayList<>()).add(i);
    }

    public int query(int left, int right, int value) {
        List<Integer> a=pos.get(value);
        if(a==null) return 0;
        //[left,right]
        return solve(a,right+1)-solve(a,left);
    }
    //找到第一个>=target的下标索引：求最左端点模型
    private int solve(List<Integer> a, int target){
        int left=0,right=a.size()-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(a.get(mid)<target) left=mid+1;
            else right=mid;
        }
        //比如当要找的right是5时，但链表长度为3，那么找的时候只能停在2的位置，自然要返回a.size()
        //此时左端点left能找到多少就是多少，a.size()反正都在[left,right]这个区间内，用a.size()减就行了
        return a.get(left)<target?a.size():left;
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */