import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-02
 * Time: 00:21
 */
class Solution {
    //961. 在长度 2N 的数组中找出重复 N 次的元素
    public int repeatedNTimes(int[] nums) {
        Set<Integer> hash=new HashSet<>();
        //写法一：hash.add(x)是先判断是否有x再决定是否add
        //如果有x，直接返回false,!hash.add(x)就是返回true
        //如果没有x:add(x),然后返回true，!hash.add(x)就是返回false
        // for(int x:nums) if(!hash.add(x)) return x;
        //写法二：
        for(int x:nums){
            if(hash.contains(x)) return x;
            else hash.add(x);
        }
        //照顾编译器
        return 0;
    }
}
