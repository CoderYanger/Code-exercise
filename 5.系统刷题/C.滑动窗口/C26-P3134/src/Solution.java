import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-08
 * Time: 21:42
 */
class Solution {
    //3134. 找出唯一性数组的中位数
    public int medianOfUniquenessArray(int[] nums) {
        int n=nums.length;
        long k=((long)n*(n+1)/2+1)/2;//中位数的位置，第k小的数
        //求左端点模板↓
        int left=0,right=n;
        while(left<right){
            int mid=left+(right-left)/2;//取靠左的位置
            //mid是不断调节的，目标位置在k
            //检查不同元素个数<=mid时的子数组数量是否>=k
            if(!check(nums,mid,k)) left=mid+1;//比k小，left往右调整
            else right=mid;//比k大，right往左调整
        }
        return right;
    }
    //检查是否覆盖第k小，ret>=k算覆盖到k
    private boolean check(int[] nums,int upper,long k){
        long ret=0;
        int n=nums.length,kinds=0;
        //<元素，个数>
        Map<Integer,Integer> hash=new HashMap<>();
        for(int left=0,right=0;right<n;right++){
            //进窗口
            int in=nums[right];
            if(hash.getOrDefault(in,0)==0) kinds++;
            hash.put(in,hash.getOrDefault(in,0)+1);
            //出窗口
            while(kinds>upper){
                int out=nums[left];
                hash.put(out,hash.get(out)-1);
                if(hash.get(out)==0){
                    hash.remove(out);
                    kinds--;
                }
                left++;
            }
            //更新
            ret+=right-left+1;
            //判断是否提前返回（无需遍历完所有子数组）
            if(ret>=k) return true;
        }
        return false;
    }
}
