/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-11
 * Time: 10:15
 */
class Solution {
    //991. 坏了的计算器
    //看完算法原理自己写的，一遍过，就是参数begin和end一开始写反了
    //感觉比吴小哲的清晰简单
    public int brokenCalc(int begin, int end) {
        int ret=0;
        while(end!=begin){
            if(end>begin&&end%2==0) end/=2;
            else end++;
            ret++;
        }
        return ret;
    }

    //吴小哲的解法，理论上比我的快，因为他只考虑了target>startValue的情况，另一个情况直接在返回值加上差值即可
    public int brokenCalc2(int startValue, int target) {
        //正难则反+贪心
        int ret=0;
        while(target>startValue){
            if(target%2==0) target/=2;
            else target+=1;
            ret++;
        }
        return ret+startValue-target;
    }
}