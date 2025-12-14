import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-12
 * Time: 15:08
 */
class Solution {
    //397. 整数替换
    //递归+记忆化搜索解法
    //一开始存备忘录是在分支里存储的，代码冗余，看完AI发现可以放在最开始检查，然后在最后放进去
    //不用记忆化搜索也可以通过，因为偶数会÷2，会很快降到1
    //因为整型最大值会溢出，所以改成了Long类型
    //跟吴小哲写的基本一样
    HashMap<Long,Integer> hash;
    public int integerReplacement(int n) {
        hash=new HashMap<Long,Integer>();
        return dfs(n*1L);
    }
    public int dfs(long n){
        if(hash.containsKey(n)) return hash.get(n);
        if(n==1) return 0;
        int ret=0;
        if(n%2==0)
            ret=dfs(n/2)+1;
        else
            ret=Math.min(dfs(n+1),dfs(n-1))+1;
        hash.put(n,ret);
        return ret;
    }

    //一开始是走+1和-1的贪心了，后来发现还是在整型最大的时候出错了
    //看完吴小哲的代码后发现直接把那快速变成偶数的两步加到ret中，然后把n改为改变后的值就行了
    public int integerReplacement2(int n) {
        int ret=0;
        while(n!=1){
            if(n%2==0){n/=2;ret++;}
            else if(n==3){ret+=2;n=1;}
            else if(n%4==1){n=n/2;ret+=2;}
            else if(n%4==3){n=n/2+1;ret+=2;}//写成(n+1)/2会整型溢出
        }
        return ret;
    }
}