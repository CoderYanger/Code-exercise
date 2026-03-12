import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-17
 * Time: 20:19
 */
class Solution {
    //解法一：枚举时分
    public List<String> readBinaryWatch(int t) {
        //存储所有符合条件的时间
        List<String> ret=new ArrayList<>();
        //遍历小时
        for(int h=0;h<12;h++)
            //遍历分钟
            for(int m=0;m<60;m++)
                //小时的二进制1个数+分钟的二进制1个数=亮灯总数，满足即合法时间
                if(Integer.bitCount(h)+Integer.bitCount(m)==t)
                    ret.add(h+":"+(m<10?"0":"")+m);
        return ret;
    }

    public List<String> readBinaryWatch(int t) {
        //解法二：二进制枚举
        List<String> ret=new ArrayList<>();
        for(int i=0;i<1024;i++){
            int h=i>>6,m=i&63;
            if(h<12&&m<60&&Integer.bitCount(i)==t)
                ret.add(h+":"+(m<10?"0":"")+m);
        }
        return ret;
    }
}
