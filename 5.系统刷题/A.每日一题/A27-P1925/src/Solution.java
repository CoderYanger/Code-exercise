import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-08
 * Time: 21:39
 */
class Solution {
    //1925. 统计平方和三元组的数目
    public int countTriples(int n) {
        int ret=0;
        Set<Integer> hash=new HashSet<>();
        for(int i=1;i<=n;i++) hash.add(i*i);
        for(int i=1;i<=n;i++){
            int a=i*i;
            for(int j=1;j<=n;j++){
                int b=j*j;
                if(hash.contains(a+b)) ret++;
            }
        }
        return ret;
    }
}