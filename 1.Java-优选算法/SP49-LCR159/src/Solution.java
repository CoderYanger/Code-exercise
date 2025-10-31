import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-07
 * Time: 15:04
 */
class Solution {
    //LCR159. 库存管理Ⅲ
    /*仓库管理员以数组 stock 形式记录商品库存表，其中 stock[i] 表示对应商品库存余量。请返回库存余量最少的 cnt 个商品余量，返回 顺序不限。
    示例 1：
    输入：stock = [2,5,7,4], cnt = 1
    输出：[2]
    示例 2：
    输入：stock = [0,2,3,6], cnt = 2
    输出：[0,2] 或 [2,0]
    提示：
            0 <= cnt <= stock.length <= 10000
            0 <= stock[i] <= 10000
*/
    public int[] inventoryManagement(int[] nums, int k) {
        qsort(nums,0,nums.length-1,k);
        int[] ret=new int[k];
        for(int i=0;i<k;i++) ret[i]=nums[i];
        return ret;
    }
    public void swap(int[] nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
    public void qsort(int[]nums,int l,int r,int k){
        if(l>=r) return ;
        int key=nums[new Random().nextInt(r-l+1)+l];
        int left=l-1,right=r+1,i=l;
        while(i<right){
            if(nums[i]<key) swap(nums,++left,i++);
            else if(nums[i]==key) i++;
            else swap(nums,--right,i);
        }
        //[l,left][left+1,right-1][right,r]
        int a=left-l+1,b=right-left-1;
        if(a>=k) qsort(nums,l,left,k);
        else if(a+b>=k) return ;//未必有序，但一定能保证前K个小的元素能在前面
        else qsort(nums,right,r,k-a-b);
    }
}