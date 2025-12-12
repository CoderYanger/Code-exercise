import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-30
 * Time: 19:17
 */
class Solution {
    //179. 最大数
    //本想自己写出来，但是发现举步维艰，最后还是看的吴小哲的代码
    public String largestNumber(int[] nums) {
        //优化：把所有的数转换成字符串
        int n=nums.length;
        String[] strs=new String[n];
        for(int i=0;i<n;i++) strs[i]=""+nums[i];
        //排序
        Arrays.sort(strs,(a, b)->(b+a).compareTo(a+b));
        //提取结果
        StringBuffer ret=new StringBuffer();
        for(String s:strs) ret.append(s);

        if(ret.charAt(0)=='0') return "0";
        return ret.toString();
    }
}