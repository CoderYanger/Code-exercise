import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-07
 * Time: 14:28
 */
class Solution {
    //3769. 二进制反射排序
    public int[] sortByReflection(int[] nums) {
        int n=nums.length;
        int[][] pair=new int[n][2];
        for(int i=0;i<n;i++){
            pair[i][0]=nums[i];
            pair[i][1]=conversion(nums[i]);
        }
        Arrays.sort(pair,(a, b)->{
            if(a[1]!=b[1]) return a[1]-b[1];
            return a[0]-b[0];
        });
        int[] ret=new int[n];
        for(int i=0;i<n;i++) ret[i]=pair[i][0];
        return ret;
    }
    public int conversion(int x){
        if(x==0) return 0;
        StringBuffer sb=new StringBuffer();
        while(x!=0){
            int tmp=x%2;
            sb.append(tmp);
            x/=2;
        }
        //2告诉程序前面的字符串是什么进制表示的数字，进而转换成十进制
        return Integer.parseInt(sb.toString(),2);
    }
}