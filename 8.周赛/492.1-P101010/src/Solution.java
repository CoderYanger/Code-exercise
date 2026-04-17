import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-08
 * Time: 15:31
 */
class Solution {
    //101010. 容量最小的箱子
    public int minimumIndex(int[] nums, int it) {
        int n=nums.length;
        //存<值，下标>
        int[] a=new int[101];
        Arrays.fill(a,-1);
        for(int i=0;i<n;i++){//遍历每个值充当下标
            if(a[nums[i]]!=-1) a[nums[i]]=Math.min(a[nums[i]],i);
            else a[nums[i]]=i;
        }
        for(int i=it;i<101;i++) if(a[i]!=-1) return a[i];
        return -1;
    }

    //优化版
    public int minimumIndex(int[] nums, int it) {
        int minC=0x3f3f3f3f;
        int ret=-1;
        for(int i=0;i<nums.length;i++){
            //获取容量
            int c=nums[i];
            //更新：容量能装下，也比之前的容量小
            if(c>=it&&c<minC){
                minC=c;
                ret=i;
            }
        }
        return ret;
    }
}
