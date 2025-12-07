import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-22
 * Time: 21:53
 */
class Solution {
    //978. 最长湍流子数组
    //看完算法原理后自己写的，一遍过
    //吴小哲跟我写的差不多，它是用循环依次初始化1，然后找最大值的时候是在循环里及时更新的，而我是之后单独找的
    public int maxTurbulenceSize(int[] arr) {
        int n=arr.length;
        int[] f=new int[n];
        int[] g=new int[n];
        Arrays.fill(f,1);
        Arrays.fill(g,1);
        for(int i=1;i<n;i++){
            int a=arr[i-1],b=arr[i];
            if(a>b) g[i]=f[i-1]+1;
            else if(a<b) f[i]=g[i-1]+1;
        }
        int max=0;
        for(int x:f) max=Math.max(max,x);
        for(int x:g) max=Math.max(max,x);
        return max;
    }
}