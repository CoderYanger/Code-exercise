/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-18
 * Time: 18:23
 */
public class Solution {
    //2903. 找出满足差值条件的下标 I
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        //心路历程：
        //用哈希表做的话，可以用HashMap，存<下标，数>因为数据量比较少，
        //也可以定义一个hash[101]来代替模拟哈希表，但这题不太方便，
        //因为可能出现相同的两个数，如果用哈希表还得定义个变量记录出现的次数
        //如果用Arrays.sort排序的话，会方便点，
        //但时间复杂度会直接涨到Nlog(N)
        //如果不排序的话也可以做⬇️
        int n=nums.length;
        for(int i=indexDifference;i<n;i++){
            //j去找最值，因为是求绝对值，所以最大值和最小值都要找
            int max=-0x3f3f3f3f,min=0x3f3f3f3f,
                    indexmax=-1,indexmin=-1;
            for(int j=i-indexDifference;j>=0;j--){
                if(nums[j]>max){max=nums[j];indexmax=j;}
                if(nums[j]<min){min=nums[j];indexmin=j;}
            }
            if(indexmax!=-1&&Math.abs(i-indexmax)>=
                    indexDifference&&Math.abs(nums[i]-max)
                    >=valueDifference) return new int[]{i,indexmax};
            if(indexmin!=-1&&Math.abs(i-indexmin)>=
                    indexDifference&&Math.abs(nums[i]-min)
                    >=valueDifference) return new int[]{i,indexmin};
        }
        return new int[]{-1,-1};
    }

    public int[] findIndices2(int[] nums, int indexDifference, int valueDifference) {
        //优化版本
        int n=nums.length;
        int max=0,min=0;
        for(int i=indexDifference;i<n;i++){
            //j去找最值，因为是求绝对值，所以最大值和最小值都要找
            int j=i-indexDifference;
            if(nums[j]>nums[max]) max=j;//更新最大值的下标
            if(Math.abs(nums[i]-nums[max])>=valueDifference)
                return new int[]{i,max};
            if(nums[j]<nums[min]) min=j;//更新最小值的下标
            if(Math.abs(nums[i]-nums[min])>=valueDifference)
                return new int[]{i,min};
        }
        return new int[]{-1,-1};
    }
}
