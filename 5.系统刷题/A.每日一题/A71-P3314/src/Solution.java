import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-20
 * Time: 19:17
 */
class Solution {
    //3314. 构造最小位运算数组 I
    //解法一：暴力解法
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ret=new int[nums.size()];
        int index=0;
        //遍历每个质数
        for(int x:nums){
            //获取一下加入之前的index位置
            int tmp=index;
            for(int i=0;i<x;i++)
                if((i|(i+1))==x){
                    ret[index++]=i;
                    break;//找到一个最小的立马弹出
                }
            //如果没找到就添加－1
            if(index==tmp) ret[index++]=-1;
        }
        return ret;
    }

    //解法二：位运算
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ret=new int[nums.size()];
        int index=0;
        for(int x:nums){
            if(x==2) ret[index++]=-1;
            else{
                //写法一
                //int lowbit=(x+1)&~x;
                //写法二
                int lowbit=(~x)&-(~x);
                ret[index++]=x^(lowbit>>1);
            }
        }
        return ret;
    }
}