import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-24
 * Time: 13:08
 */
class Solution {
    //3074. 重新分装苹果
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum=0;
        //先把所有苹果堆一起
        for(int x:apple) sum+=x;
        Arrays.sort(capacity);
        int m=capacity.length;
        int i=m-1;//先装大箱子，再装小箱子
        //还有箱子就继续装
        while(sum>0) sum-=capacity[i--];
        return m-1-i;//用的箱子数=总箱子数-剩下的箱子数
    }
}
