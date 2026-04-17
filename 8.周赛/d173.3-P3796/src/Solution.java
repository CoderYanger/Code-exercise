import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-05
 * Time: 22:27
 */
class Solution {
    //3796. 找到带限制序列的最大值
    public int findMaxVal(int n, int[][] restrictions, int[] diff) {
        //初始化每个位置的最大可能值为极大值
        long[] maxA=new long[n];
        Arrays.fill(maxA,Long.MAX_VALUE);
        //初始条件：a[0]=0;
        maxA[0]=0;
        //应用限制条件:restrictions中的位置idx不能超过maxVal
        for(int[] r:restrictions){
            int idx=r[0];
            int maxVal=r[1];
            maxA[idx]=maxVal;
        }
        //从左到右遍历：约束a[i]<=a[i-1]+diff[i-1]
        for(int i=1;i<n;i++)
            if(maxA[i-1]!=Long.MAX_VALUE)
                maxA[i]=Math.min(maxA[i],maxA[i-1]+diff[i-1]);
        //从右到左遍历：约束a[i]<=a[i+1]+diff[i]
        for(int i=n-2;i>=0;i--)
            if(maxA[i]!=Long.MAX_VALUE)
                maxA[i]=Math.min(maxA[i],maxA[i+1]+diff[i]);
        //计算序列中的最大值（保证非负）
        long maxVal=0;
        for(long val:maxA) maxVal=Math.max(maxVal,Math.max(val,0));
        return (int)maxVal;
    }
}
