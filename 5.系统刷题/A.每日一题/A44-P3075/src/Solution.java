import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-31
 * Time: 20:53
 */
class Solution {
    //3075. 幸福值最大化的选择方案
    public long maximumHappinessSum(int[] h, int k) {
        int n=h.length;
        Arrays.sort(h);
        long ret=h[n-1];
        for(int i=n-2;i>n-1-k&&h[i]>n-1-i;i--)
            ret+=h[i]-(n-1-i);
        return ret;
    }
}