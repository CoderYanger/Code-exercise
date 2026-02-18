/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-18
 * Time: 22:33
 */
class Solution {
    //3652. 按策略买卖股票的最佳时机
    //解法一优化前的代码
    public long maxProfit(int[] p, int[] s, int k) {
        int n=p.length;
        //先计算不修改时的最大利润
        long total=0;
        for(int i=0;i<n;i++) total+=p[i]*s[i];
        //计算修改后能获得的最大利润
        //保证索引1~index
        long[] prev=new long[n+1];//前缀和
        long[] suff=new long[n+2];//后缀和
        //前缀和prev[i]:i之前的前缀和，不包括i
        for(int i=1;i<=n;i++) prev[i]=prev[i-1]+p[i-1]*s[i-1];
        //后缀和suff[i]:i-1之后的后缀和，包括i-1
        //统一含义：后缀和suff[i]:i-2之后的后缀和，不包括i-2
        for(int i=n;i>=1;i--) suff[i]=suff[i+1]+p[i-1]*s[i-1];
        long ret=total,sum=0;
        for(int right=0;right<n;right++){
            //进窗口
            sum+=p[right];
            int left=right-k+1;
            if(left<0) continue;
            //更新
            //计算窗口内的前k/2个和
            long prevsum=0;
            for(int i=left;i<left+k/2;i++) prevsum+=p[i];
            //计算窗口内的后k/2个和
            long suffsum=sum-prevsum;
            //拼接三个部分[0,left-1][left,right][right+1,n-1]
            long tmp=suffsum+prev[left]+suff[right+2];
            //不修改和修改后能拿的最大利润取最大值
            ret=Math.max(ret,tmp);
            //出窗口
            sum-=p[left];
        }
        return ret;
    }

    //解法一优化后的代码
    public long maxProfit(int[] p, int[] s, int k) {
        int n=p.length;
        //先计算不修改时的最大利润
        long total=0;
        for(int i=0;i<n;i++) total+=p[i]*s[i];
        //计算修改后能获得的最大利润
        //保证索引1~index
        long[] prev=new long[n+1];//前缀和
        long[] suff=new long[n+2];//后缀和
        //前缀和prev[i]:i之前的前缀和，不包括i
        for(int i=1;i<=n;i++) prev[i]=prev[i-1]+p[i-1]*s[i-1];
        //后缀和suff[i]:i-1之后的后缀和，包括i-1
        //统一含义：后缀和suff[i]:i-2之后的后缀和，不包括i-2
        for(int i=n;i>=1;i--) suff[i]=suff[i+1]+p[i-1]*s[i-1];
        long ret=total,sum=0;
        //优化：预处理区间和
        long[] prefix=new long[n+1];
        //prefix[i]:i之前的前缀和,不包括i
        for(int i=1;i<=n;i++) prefix[i]=prefix[i-1]+p[i-1];
        for(int right=0;right<n;right++){
            //进窗口
            sum+=p[right];
            int left=right-k+1;
            if(left<0) continue;
            //更新
            //计算窗口内的前k/2个和
            //优化：用前缀和相减代替原本的遍历
            long prevsum=prefix[left+k/2]-prefix[left];
            //计算窗口内的后k/2个和
            long suffsum=sum-prevsum;
            //拼接三个部分[0,left-1][left,right][right+1,n-1]
            long tmp=suffsum+prev[left]+suff[right+2];
            //不修改和修改后能拿的最大利润取最大值
            ret=Math.max(ret,tmp);
            //出窗口
            sum-=p[left];
        }
        return ret;
    }

    //解法二：单纯前缀和解法
    public long maxProfit(int[] p, int[] s, int k) {
        int n=p.length;
        long[] sum=new long[n+1];
        long[] sumsell=new long[n+1];
        for(int i=1;i<=n;i++){
            sum[i]=sum[i-1]+p[i-1]*s[i-1];
            sumsell[i]=sumsell[i-1]+p[i-1];
        }
        long ret=Long.MIN_VALUE;//可能出现负数
        for(int i=k;i<=n;i++)
            ret=Math.max(ret,sum[i-k]+sum[n]-sum[i]+sumsell[i]-sumsell[i-k/2]);
        return Math.max(sum[n],ret);
    }

    //解法三：滑动窗口
    public long maxProfit(int[] p, int[] s, int k) {
        long total=0,maxsum=0,sum=0;
        for(int i=0;i<p.length;i++){
            //计算不修改时的最大利润
            total+=p[i]*s[i];
            //进窗口
            sum+=p[i]*(1-s[i]);
            //还未形成窗口时
            if(i<k-1){
                //在下一轮循环中，中间下标的元素从右半部分移到左半部分，s[i-k/2+1]从1变成0
                if(i>=k/2-1) sum-=p[i-k/2+1];
                continue;
            }
            //更新
            maxsum=Math.max(maxsum,sum);
            //出窗口
            //中间下标i-k/2+1元素右半部分移到左半部分，s[i-k/2+1]从1变成0
            //尾下标i-k+1元素出窗口
            sum-=p[i-k/2+1]-p[i-k+1]*s[i-k+1];
        }
        return total+maxsum;
    }
}