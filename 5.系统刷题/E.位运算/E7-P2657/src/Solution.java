import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-04
 * Time: 13:32
 */
class Solution {
    //2657. 找到两个数组的前缀公共数组
    //解法一：模拟
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        int[] C=new int[n];
        Map<Integer,Integer> hash=new HashMap<>();
        for(int i=0;i<n;i++){
            int cnt=0;
            hash.merge(A[i],1,Integer::sum);
            hash.merge(B[i],1,Integer::sum);
            if(A[i]!=B[i]){
                if(hash.get(A[i])==2) cnt++;
                if(hash.get(B[i])==2) cnt++;
            }else if(hash.get(A[i])==2) cnt++;
            if(i>=1) C[i]=C[i-1]+cnt;
            else C[i]=cnt;
        }
        return C;
    }

    //解法二：位运算
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        long p=0,q=0;
        for(int i=0;i<A.length;i++){
            p|=1L<<A[i];
            q|=1L<<B[i];
            A[i]=Long.bitCount(p&q);
        }
        return A;
    }
}
