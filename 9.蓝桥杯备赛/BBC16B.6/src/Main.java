/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-18
 * Time: 13:30
 */
import java.util.Scanner;
import java.io.*;
public class Main {
    //数组翻转
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        //留5个避免越界
        int MAX_VAL=1000005;
        //maxlen[v]:存储数值v的所有连续段中，长度最长的值
        int[] maxlen=new int[MAX_VAL];
        //secondmaxlen[v]:存储数值v的所有连续段中，长度次长的值
        int[] secondmaxlen=new int[MAX_VAL];
        //先获取第一个数字
        int lastVal=sc.nextInt();
        //记录当前连续段的长度，初始化为1
        int currentlen=1;
        //优化：记录输入中的最大值，最后仅需遍历到这个最大值即可，省去后续无用遍历
        int maxInputVal=lastVal;
        //接着遍历剩下的数字
        for(int i=1;i<n;i++){
            int val=sc.nextInt();
            //更新输入的最大值
            maxInputVal=Math.max(maxInputVal,val);
            //①当前数字与上一个数字相同，继续延续，长度+1
            if(val==lastVal) currentlen++;
                //②当前数字与上一个不同，重置当前段
            else{
                //更新lastVal的最长/次长连续段长度
                updatelen(maxlen,secondmaxlen,lastVal,currentlen);
                //重置当前连续段：切换为新数字，长度重置为1
                lastVal=val;
                currentlen=1;
            }
        }
        //清算最后一个连续段
        updatelen(maxlen,secondmaxlen,lastVal,currentlen);
        //计算所有数值的最大分数：分数=数值v*(最长段+次长段)
        long maxscore=0;
        for(int i=1;i<=maxInputVal;i++){
            //只处理出现过的数值
            if(maxlen[i]>0){
                //总长度=最长+次长
                long total=(long)maxlen[i]+secondmaxlen[i];
                //计算当前数值的分数
                long score=total*i;
                //更新全局最大分数
                maxscore=Math.max(maxscore,score);
            }
        }
        System.out.println(maxscore);
        sc.close();
    }
    private static void updatelen(int[] maxlen,int[] secondmaxlen,int val,int len){
        //①当前段长度≥原最长段→原最长段降为次长段，当前段成为新最长段
        if(len>=maxlen[val]){
            secondmaxlen[val]=maxlen[val];
            maxlen[val]=len;
        }
        //②当前段长度<原最长段，但>次长段→仅更新次长段
        else if(len>secondmaxlen[val]) secondmaxlen[val]=len;
        //③当前段长度<原次长段→无需更新
    }
}
