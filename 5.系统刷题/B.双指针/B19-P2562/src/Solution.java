/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-18
 * Time: 18:04
 */
class Solution {
    //2562. 找出数组的串联值
    public long findTheArrayConcVal(int[] nums) {
        int n=nums.length;
        int left=0,right=n-1;
        long ret=0;
        while(left<right&&n>1){
            StringBuffer sb=new StringBuffer();
            sb.append(String.valueOf(nums[left++]))
                    .append(String.valueOf(nums[right--]));
            ret+=Integer.valueOf(sb.toString());
        }
        //判断只剩下一个元素的情况
        if(left==right) ret+=nums[left];
        return ret;
    }

    //也可以不用StringBuffer（但拼接的新字符串会生成新的对象）
    public long findTheArrayConcVal2(int[] nums) {
        long ret=0;
        for (int i=0,j=nums.length-1;i<=j;i++,j--) {
            if(i!=j) ret+=Integer.parseInt(Integer.toString(nums[i])+ Integer.toString(nums[j]));
            else ret+=nums[i];
        }
        return ret;
    }
}