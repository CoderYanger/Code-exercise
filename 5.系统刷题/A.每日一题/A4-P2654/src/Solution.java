/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-15
 * Time: 23:23
 */
class Solution {
    //2654. 使数组所有元素变成 1 的最少操作次数
    //自己写的，有点瑕疵，没通过
    public int minOperations(int[] nums) {
        int sum=0;//统计1的个数
        int n=nums.length;
        for(int x:nums) if(x==1) sum++;
        if(sum!=0) return n-sum;
        //没有1的情况
        for(int i=1;i<n;i++){
            int n1=nums[i-1],n2=nums[i];
            if(gcd(n1,n2)==1) return n;
        }
        return -1;
    }
    //欧几里得的辗转相除法求最大公约数
    public int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    // public boolean prime(int x){
    //     for(int i=2;i<=(int)Math.sqrt(x);i++)
    //         if(x%i==0) return false;
    //     return true;
    // }
    //自己第一次写的求最大公约数
    // public int gcd(int n1,int n2){
    //     for(int i=Math.min(n1,n2);i>1;i--)
    //         if(n1%i==0&&n2%i==0) return i;
    //     return 1;
    // }

    //看完官方题解之后自己写了一遍，能AC
    public int minOperations(int[] nums) {
        int sum=0;//统计1的个数
        int n=nums.length;
        int g=0;
        //统计1的个数的同时统计全部数的最大公因数
        for(int x:nums){if(x==1) sum++;g=gcd(g,x);}
        if(sum!=0) return n-sum;
        //全部数的最大公因数比1大直接返回-1
        if(g>1) return -1;
        //到这里说明有个区间的最大公因数是1，找到这个区间
        int minlen=n;
        for(int i=0;i<n;i++){
            int tmpgcd=0;
            for(int j=i;j<n;j++){
                tmpgcd=gcd(tmpgcd,nums[j]);
                //说明找到了一个能让最大公因数变成1的区间
                if(tmpgcd==1){
                    //更新，只要一个最小的就行
                    minlen=Math.min(minlen,j-i+1);
                    break;
                }
            }
        }
        //由这些数字得到一个 1 所需的次数是 minLen−1
        //再由这个 1 使得其他数字都变为 1 所需的次数是 n−1
        return minlen+n-2;
    }
    //欧几里得的辗转相除法求最大公约数
    public int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}