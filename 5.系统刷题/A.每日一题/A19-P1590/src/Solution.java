import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-30
 * Time: 20:07
 */
class Solution {
    //1590. 使数组和能被 P 整除
    //一边遍历一边计算前缀和%p的余数
    public int minSubarray(int[] nums, int p) {
        //前缀和+同余定理+哈希表
        //先算出整个数组%p的余数
        long x=0;
        //后面+p是为了防止余数变成负数
        for(int t:nums) x=(x+t+p)%p;
        //所有数的和能被整除就无需移除
        if(x==0) return 0;
        Map<Long,Integer> hash=new HashMap<>();
        //y作为遍历过程中的临时余数
        int n=nums.length;long s=0;
        //因为题目不允许全部移除，所以看ret与n的大小关系即可判断是否有解
        int ret=n;
        hash.put(s,-1);
        for(int right=0;right<n;right++){
            s=(nums[right]+s+p)%p;
            hash.put(s,right);
            //如果存在目标余数就更新
            //目标余数：能够配合s相减后让余数为x的值
            //推导过程：(s[right]-s[left])%p=x%p
            //同时%p时：s[left]=s[right]-x;
            long left=(s-x+p)%p;
            if(hash.containsKey(left))
                ret=Math.min(ret,right-hash.get(left));
        }
        return ret<n?ret:-1;
    }

    //一边遍历一边计算前缀和%p的余数
    public int minSubarray(int[] nums, int p) {
        //前缀和+同余定理+哈希表
        //先算出整个数组%p的余数
        long x=0;
        //后面+p是为了防止余数变成负数
        for(int t:nums) x=(x+t+p)%p;
        //所有数的和能被整除就无需移除
        if(x==0) return 0;
        Map<Long,Integer> hash=new HashMap<>();
        //y作为遍历过程中的临时余数
        int n=nums.length;long s=0;
        //因为题目不允许全部移除，所以看ret与n的大小关系即可判断是否有解
        int ret=n;
        // hash.put(s,-1);
        for(int right=0;right<n;right++){
            hash.put(s,right);
            s=(nums[right]+s+p)%p;
            //如果存在目标余数就更新
            //目标余数：能够配合s相减后让余数为x的值
            //推导过程：(s[right]-s[left])%p=x%p
            //同时%p时：s[left]=s[right]-x;
            long left=(s-x+p)%p;
            if(hash.containsKey(left))
                ret=Math.min(ret,right-hash.get(left)+1);
        }
        return ret<n?ret:-1;
    }
}