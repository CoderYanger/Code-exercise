import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-25
 * Time: 17:38
 */
class Solution {
    //446. 等差数列划分Ⅱ-子序列
    public int numberOfArithmeticSlices(int[] nums) {
        //自己写的放最下面的注释处了，自己写不出来还是看了吴小哲的
        //主要错在1.没有处理重复的元素：提前放入哈希表+遍历该元素的每个下标
        //改为<元素，下标数组>
        Map<Long, List<Integer>> hash=new HashMap<>();
        int n=nums.length;
        //提前放进哈希表，以便处理重复元素的多个下标
        for(int i=0;i<n;i++){
            long tmp=(long)nums[i];//(long)nums[i]一定要带long否则报错
            //不在哈希表就先创建一个空List
            if(!hash.containsKey(tmp)) hash.put(tmp,new ArrayList<Integer>());
            hash.get(tmp).add(i);
        }
        int[][] dp=new int[n][n];
        int sum=0;
        for(int i=0;i<n-1;i++){//用两种方式遍历均可
            for(int j=i+1;j<n;j++){
                long a=2L*nums[i]-nums[j];//在这个计算过程中可能溢出，导致溢出的值也符合等差序列
                if(hash.containsKey(a)){
                    for(int k:hash.get(a)){//处理重复元素的下标，都计入
                        if(k<i) dp[i][j]+=dp[k][i]+1;
                        else break;//小优化
                    }
                }
                sum+=dp[i][j];
            }
            // hash.put(nums[i],i);删掉
        }
        return sum;

        //下面的代码是一开始自己写的，主要的问题是不能一边遍历一边放哈希表里，因为后出现的元素会覆盖之前的索引，导致无法找到所有符合条件的k，没有处理数组中存在重复元素的情况
        // Map<Integer,Integer> hash=new HashMap<>();
        // int n=nums.length;
        // int[][] dp=new int[n][n];
        // int sum=0;
        // for(int i=0;i<n-1;i++){
        //     for(int j=i+1;j<n;j++){
        //         int a=2*nums[i]-nums[j];
        //         if(hash.containsKey(a)){
        //             dp[i][j]+=dp[hash.get(a)][i]+1;
        //         }
        //         sum+=dp[i][j];
        //     }
        //     hash.put(nums[i],i);
        // }
        // return sum;
    }
}