import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-16
 * Time: 20:31
 */
class Solution {
    //2367. 等差三元组的数目
    public int arithmeticTriplets(int[] nums, int diff) {
        int ret=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
            for(int j=i+1;j<n;j++)
                for(int k=j+1;k<n;k++)
                    if(nums[j]-nums[i]==diff&&
                            nums[k]-nums[j]==diff)
                        ret++;
        return ret;
    }


    //哈希表解法
    public int arithmeticTriplets2(int[] nums, int diff) {
        Set<Integer> hash=new HashSet<>();
        int ret=0;
        for(int x:nums) hash.add(x);
        for(int x:nums)
            if(hash.contains(x+diff)&&hash.contains(x+2*diff))
                ret++;
        return ret;
    }

    //三指针解法
    public int arithmeticTriplets3(int[] nums, int diff) {
        int ret=0;
        int n=nums.length;
        for(int i=0,j=1,k=2;i<n-2&&j<n-1&&k<n;i++){
            j=Math.max(j,i+1);//根据单调性，j不需要回来
            while(j<n-1&&nums[j]-nums[i]<diff) j++;
            //j越界或者直接大于差值直接diff就直接去枚举下一个i
            if(j>=n-1||nums[j]-nums[i]>diff) continue;
            k=Math.max(k,j+1);//跟j一个道理
            while(k<n&&nums[k]-nums[j]<diff) k++;
            if(k<n&&nums[k]-nums[j]==diff) ret++;
        }
        return ret;
    }
}