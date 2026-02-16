/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-02
 * Time: 10:38
 */
class Solution {
    //2141. 同时运行 N 台电脑的最长时间
    public long maxRunTime(int n, int[] batteries) {
        long total=0;
        //计算所有电池的总电量
        for(int b:batteries) total+=b;
        //二分查找
        long l=0;//左端点：0小时一定能满足（无需运行）
        //右端点：总电量/n+1，这个时间一定无法满足
        //原因：n*(total/n+1)>tatal，总电量不够n台电脑运行那么久
        long r=total/n+1;
        //二分查找最长能运行的时间
        //开区间的终止条件：l+1==r，此时l就是最大 可运行时间
        while(l+1<r){
            //取中间值，用l+(r-l)/2避免溢出
            long x=l+(r-l)/2;
            //计算所有电池运行x小时能提供的有效总电量
            long sum=0;
            //每块电池最多贡献x小时的电量，超出x的部分用不上
            for(int b:batteries) sum+=Math.min(x,b);
            //判断x小时是否可行
            //可行，尝试更长时间
            if(n*x<=sum) l=x;
                //不可行，尝试更短时间
            else r=x;
        }
        return l;
    }

    public long maxRunTime(int n, int[] batteries) {
        long total=0;
        Arrays.sort(batteries);
        for(int b:batteries) total+=b;
        for(int i=batteries.length-1;;i--){
            if(batteries[i]<=total/n) return total/n;
            total-=batteries[i];
            n--;
        }
    }
}
