import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-25
 * Time: 13:31
 */
class Solution {
    //3819. 非负元素轮替
    public int[] rotateElements(int[] nums, int k) {
        //类似大家围一桌，负数不动位置，非负数起身走k个空座位重新入座
        int n=nums.length;
        int[] ret=new int[n];
        //收集非负数下标->找空座位重新凑一桌
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]>=0)
                list.add(i);
            else ret[i]=nums[i];
        }
        //看看有多少个位置可坐
        int m=list.size();
        //没有位置可坐，说明没有非负数
        if(m==0) return nums;
        //确定新座位的位置->找到去除绕一圈后的最终偏移量
        int kk=k%m;
        for(int i=0;i<m;i++){
            int a=(i+kk)%m;//避免越界
            //当前座位是给后kk个人坐的
            ret[list.get(i)]=nums[list.get(a)];
        }
        return ret;
    }
}