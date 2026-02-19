import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-22
 * Time: 13:17
 */
class Solution {
    //955. 删列造序 II
    public int minDeletionSize(String[] s) {
        int n=s.length,m=s[0].length(),ret=0;
        String[] a=new String[n];
        Arrays.fill(a,"");
        next://此处next跟下面的循环绑定，直接继续迭代下一次循环
        //遍历每一列
        for(int i=0;i<m;i++){
            //遍历每一个字符串
            for(int j=0;j<n-1;j++){
                if((a[j]+s[j].charAt(i)).compareTo(a[j+1]+s[j+1].charAt(i))>0){
                    ret++;
                    continue next;
                }
            }
            //执行到这里说明，第i列可以保留
            //更新缓存数组:字符串可以直接+=追加
            for(int j=0;j<n;j++) a[j]+=s[j].charAt(i);
        }
        return ret;
    }
}
