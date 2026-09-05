import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-22
 * Time: 16:33
 */
class Solution {
    //101020. 构造奇偶一致的数组 II
    public boolean uniformArray(int[] nums1) {
        int cnt0=0,cnt1=0;
        for(int x:nums1){
            if(x%2==0) cnt0++;
            else cnt1++;
        }
        //全是奇数或全是偶数就返回true
        if(cnt0==0||cnt1==0) return true;
        List<Integer> list=new ArrayList<>();
        for(int x:nums1) list.add(x);
        Collections.sort(list);
        return list.get(0)%2==1;
    }

    //优化
    public boolean uniformArray(int[] nums1) {
        int cnt0=0,cnt1=0,mn=0x3f3f3f3f;
        for(int x:nums1){
            mn=Math.min(x,mn);
            if(x%2==0) cnt0++;
            else cnt1++;
        }
        return cnt0==0||cnt1==0||mn%2==1;
    }
}
