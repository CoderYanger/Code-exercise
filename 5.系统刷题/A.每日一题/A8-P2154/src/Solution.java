import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-19
 * Time: 13:09
 */
class Solution {
    //2154. 将找到的值乘以 2
    //解法一：排序+枚举
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        for(int x:nums)
            if(x==original)
                original*=2;
        return original;
    }
    //解法二：哈希表
    public int findFinalValue1(int[] nums, int original) {
        Set<Integer> hash=new HashSet<>();
        for(int x:nums) hash.add(x);
        while(hash.contains(original)) original*=2;
        return original;
    }


    //解法三：位运算
    public int findFinalValue(int[] nums, int original) {
        //mask第k位为1，表示original×2ᵏ在数组中存在
        int mask=0;
        for(int x:nums){
            //我们只关心x=original×2ᵏ这种形式的数
            int k=x/original;
            //满足以下两个条件
            //①x是original的整数倍→能被整除
            //②k是2的幂
            //k&(k-1)：判断是不是2的幂的经典方法
            if(x%original==0&&(k&(k-1))==0) 
                //把mask里第k位设为1，表示original×2ᵏ存在
                mask|=k;
        }
        //我们要找第一个不满足的：需要按位取反，取出最右侧的1，即为第一个不满足的
        mask=~mask;
        return original*(mask&-mask);
    }
}