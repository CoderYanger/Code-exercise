import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-24
 * Time: 18:09
 */
class Solution {
    //873. 最长斐波那契子序列
    //注释处是自己照着算法原理写的，本以为用一个getOrDefault依然能干三个事情，没想到还是要一个个把数和下标捆绑在一起扔哈希表里，因为这次的值捆绑的不是dp的值了，而是要通过下标去找值的
    //最后还是看了吴小哲的解法才写出来
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer,Integer> hash=new HashMap<>();
        int n=arr.length;
        //将值+下标绑定放进去，这次不是绑定的dp的值了，改成下标了
        for(int i=0;i<n;i++) hash.put(arr[i],i);
        int[][] dp=new int[n][n];
        //初始化
        for(int i=0;i<n;i++) for(int j=0;j<n;j++) dp[i][j]=2;
        //统计
        int ret=2;
        for(int j=2;j<n;j++){//固定最后一个数
            for(int i=1;i<j;i++){//枚举倒数第二个数
                int a=arr[j]-arr[i];
                //判断a符合条件且存在
                if(a<arr[i]&&hash.containsKey(a)){
                    dp[i][j]=dp[hash.get(a)][i]+1;//这里自己写的时候卡住了
                    ret=Math.max(ret,dp[i][j]);
                }
            }
        }
        return ret<3?0:ret;
        // HashMap<Integer,Integer> hash=new HashMap<>();
        // int n=arr.length;
        // for(int j=2;j<n;j++){
        //     for(int i=1;i<j;i++){
        //         hash.put(arr[j]-arr[i],hash.getOrDefault(arr[j]-arr[i],1)+1);
        //     }
        // }
        // int ret=2;
        // Set<hash.Entry<Integer,Integer>> entries=hash.entrySet();
        // for(hash.Entry<Integer,Integer> entry:entries){
        //     int val=entry.getValue();
        //     ret=Math.max(ret,val);
        // }
        // return ret<3?0:ret;
    }
}