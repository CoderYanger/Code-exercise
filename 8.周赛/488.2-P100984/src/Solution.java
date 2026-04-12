import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-08
 * Time: 13:23
 */
class Solution {
    //100984. 合并相邻且相等的元素
    //解法一：暴力模拟
    public List<Long> mergeAdjacent(int[] nums) {
        int n=nums.length;
        List<Long> ret=new ArrayList<>();
        for(int x:nums) ret.add((long)x);
        for(int i=0;i<ret.size()-1;i++){
            if(ret.get(i).equals(ret.get(i+1))){
                ret.add(i,2*ret.get(i));
                ret.remove(i+1);
                ret.remove(i+1);
                i=-1;
            }
        }
        return ret;
    }

    //解法一的优化
    public List<Long> mergeAdjacent(int[] nums) {
        int n=nums.length;
        List<Long> ret=new ArrayList<>();
        for(int x:nums) ret.add((long)x);
        for(int i=0;i<ret.size()-1;i++){
            if(ret.get(i).equals(ret.get(i+1))){
                ret.add(i,2*ret.get(i));
                ret.remove(i+1);
                ret.remove(i+1);
                if(i-2>=-1) i-=2;
                else i--;
            }
        }
        return ret;
    }

    //解法二：顺序表模拟栈
    public List<Long> mergeAdjacent(int[] nums) {
        //用顺序表模拟栈
        List<Long> stack=new ArrayList<>();
        for(int x:nums){
            long val=x;
            while(!stack.isEmpty()&&stack.get(stack.size()-1).equals(val)){
                val*=2;
                stack.remove(stack.size()-1);
            }
            stack.add(val);
        }
        return stack;
    }
}