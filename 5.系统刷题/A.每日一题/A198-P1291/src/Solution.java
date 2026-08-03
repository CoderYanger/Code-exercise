import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-07-26
 * Time: 12:37
 */
class Solution {
    //1291. 顺次数
    //解法一：枚举左右端点
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ret=new ArrayList<>();
        for(int d=1;d<=9;d++){
            int x=d;
            for(int i=d;i<=9&&x<=high;i++){
                if(x>=low) ret.add(x);
                //把i+1加到x的末尾
                x=x*10+i+1;
            }
        }
        Collections.sort(ret);
        return ret;
    }

    //1291. 顺次数
    //解法二：先枚举长度，再枚举位置
    private static final String s="123456789";
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ret=new ArrayList<>();
        int minlen=String.valueOf(low).length();
        int maxlen=String.valueOf(high).length();
        //枚举 s 的字串（先枚举字串长度，再枚举字串位置）
        for(int len=minlen;len<=maxlen;len++){
            for(int r=len;r<=s.length();r++){
                int x=Integer.parseInt(s.substring(r-len,r));
                if(low<=x&&x<=high) ret.add(x);
            }
        }
        return ret;
    }


    //1291. 顺次数
    //解法三：滑动窗口
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ret=new ArrayList<>();
        //第一个窗口
        int x0=12;
        //用于计算窗口最左边数字的权重，初始为10（因为12的十位是1，权重是10）
        int pow10=10;
        //外层循环：枚举窗口长度 length，从2开始
        for(int length=2;x0<=high;length++){
            //窗口长度增加，权重也要相应增加
            pow10*=10;
            int x=x0;
            //内层循环：在当前长度下，滑动窗口
            for(int i=length;i<=9&&x<=high;i++){
                if(x>=low) ret.add(x);
                //窗口向右滑动，i+1进入窗口，i+1-length离开窗口
                x=x*10+i+1-(i+1-length)*pow10;
            }
            x0=x0*10+length+1;
        }
        return ret;
    }
    
}
