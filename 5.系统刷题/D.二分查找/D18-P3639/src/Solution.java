/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-03
 * Time: 20:09
 */
class Solution {
    //3639. 变为活跃状态的最小时间
    public int minTime(String s, int[] order, int k) {
        int left=0,right=order.length;
        while(left<right){
            int mid=left+(right-left)/2;
            if(check(mid,s,order,k)) left=mid+1;
            else right=mid;
        }
        //处理无解情况
        if(check(left,s,order,k)) return -1;
        return left-1;
    }
    //判断在mid时刻有效子字符串的个数是否<k
    private boolean check(int mid,String s,int[] order, int k){
        char[] ch=s.toCharArray();
        //动态规划求mid时刻有效子字符串的个数
        //dp[i]:以i结尾的有效子字符串的个数
        int n=ch.length;
        //用long防止溢出
        long[] dp=new long[n];
        //从s开始初始化ch数组，因为s可能本身就有'*'
        for(int i=0;i<mid;i++)
            ch[order[i]]='*';
        //初始化第一个字符
        dp[0]=ch[0]=='*'?1:0;
        for(int i=1;i<n;i++){
            //以i结尾的子串共i+1个
            if(ch[i]=='*') dp[i]=i+1;
                //继承前面的有效子串数
            else dp[i]=dp[i-1];
        }
        long sum=0;
        for(long x:dp) sum+=x;
        return sum<k;
    }


    //解法二优化：用单个变量代替dp数组的反复空间开销
    public int minTime(String s, int[] order, int k) {
        int left=0,right=order.length;
        while(left<right){
            int mid=left+(right-left)/2;
            if(check(mid,s,order,k)) left=mid+1;
            else right=mid;
        }
        //处理无解情况
        if(check(left,s,order,k)) return -1;
        return left-1;
    }
    //判断在mid时刻有效子字符串的个数是否<k
    private boolean check(int mid,String s,int[] order, int k){
        char[] ch=s.toCharArray();
        int n=ch.length;
        //从s开始初始化ch数组，因为s可能本身就有'*'
        for(int i=0;i<mid;i++)
            ch[order[i]]='*';
        //优化核心：去掉dp数组，用单个变量实现累加
        long prev=ch[0]=='*'?1:0;//替代dp[0]
        long sum=prev;//实时累加，替代最后遍历dp求和
        for(int i=1;i<n;i++){
            long cur=0;
            if(ch[i]=='*') cur=i+1;
            else cur=prev;
            sum+=cur;
            //更新前一个值
            prev=cur;
            //剪枝：避免无效计算
            if(sum>=k) return false;
        }
        return sum<k;
    }
}