import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-07-18
 * Time: 19:23
 */
class Solution {
    //1846. 减小和重新排列数组后的最大元素
    //解法一：贪心+直接排序
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        arr[0]=1;
        for(int i=1;i<n;i++)
            if(arr[i]-arr[i-1]>1)
                arr[i]=arr[i-1]+1;
        return arr[n-1];
    }

    //1846. 减小和重新排列数组后的最大元素
    //解法二：贪心+计数排序
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n=arr.length;
        int[] cnt=new int[n+1];
        for(int x:arr) cnt[Math.min(n,x)]++;
        int mx=0;
        for(int x=1;x<=n;x++) mx=Math.min(mx+cnt[x],x);
        return mx;
    }
}
