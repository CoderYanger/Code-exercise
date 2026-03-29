/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-10
 * Time: 21:12
 */
import java.util.Scanner;
import java.util.Arrays;
public class Main {
    //甘蔗
    //甘蔗最大高度为1000，因此高度维度设为1010足够覆盖所有情况
    static final int N=1010;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //获取甘蔗数量n，差值大小m
        int n=scan.nextInt();
        int m=scan.nextInt();
        //获取甘蔗高度数组
        int[] a=new int[n+1];
        for(int i=1;i<=n;i++) a[i]=scan.nextInt();
        //获取差值集合
        int[] b=new int[n+1];
        for(int i=0;i<m;i++) b[i]=scan.nextInt();
        //动态规划
        //f[i][j]：处理到第i根甘蔗，将其砍成高度j时，最少需要砍的甘蔗数量
        //初始化为0x3f3f3f3f表示初始状态不可达
        int[][] f=new int[n+1][N];
        for(int i=0;i<=n;i++) Arrays.fill(f[i],0x3f3f3f3f);
        //初始化第一根甘蔗的状态
        f[1][a[1]]=0;//第1根甘蔗，砍成原高度，需要砍的数量为0
        for(int j=0;j<a[1];j++) f[1][j]=1;//砍成高度j，砍的数量为1（只能砍第1根本身）
        //状态转移：从第二根甘蔗开始
        for(int i=2;i<=n;i++){//遍历每一根甘蔗
            for(int j=0;j<=a[i];j++){//当前甘蔗高度j，只能砍短，因此不能超过原高度a[i]
                for(int k=0;k<m;k++){//遍历差值集合中的每一个差值
                    //情况1：当前高度-前一根高度=差值：j-prev=b[k]→prev=j-b[k]
                    int prev1=j-b[k];
                    //前一根高度必须≥0，且≤前一根的高度a[i-1]（只能砍短，不能变长）
                    if(prev1>=0&&prev1<=a[i-1])
                        //转移：前一根状态+当前是否砍（j==a[i]就不砍，加0，否则砍，加1）
                        f[i][j]=Math.min(f[i][j],f[i-1][prev1]+(j==a[i]?0:1));
                    //情况2：前一根高度-当前高度=差值：prev-j=b[k]→prev=j+b[k]
                    int prev2=j+b[k];
                    //前一根高度必须≤前一根原高度a[i-1]（只能砍短）
                    if(prev2<=a[i-1])
                        //转换逻辑同上
                        f[i][j]=Math.min(f[i][j],f[i-1][prev2]+(j==a[i]?0:1));
                }
            }
        }
        //计算最终结果：最后一根甘蔗的所有可能高度中，最少砍的数量
        int mincuts=0x3f3f3f3f;
        for(int j=0;j<=a[n];j++) mincuts=Math.min(mincuts,f[n][j]);
        if(mincuts==0x3f3f3f3f) System.out.println(-1);
        else System.out.println(mincuts);
        scan.close();
    }
}