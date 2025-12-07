/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-18
 * Time: 13:40
 */
class Solution {
    //740. 删除并获得点数
    public int deleteAndEarn(int[] nums) {
        int n=10001;
        //预处理
        int[] arr=new int[n];
        for(int x:nums) arr[x]+=x;
        //创建dp表
        int[] f=new int[n];
        int[] g=new int[n];
        //初始化
        f[0]=arr[0];g[0]=0;
        //填表
        for(int i=1;i<n;i++){
            f[i]=g[i-1]+arr[i];
            g[i]=Math.max(f[i-1],g[i-1])+0;
        }
        return Math.max(g[n-1],f[n-1]);
    }
}