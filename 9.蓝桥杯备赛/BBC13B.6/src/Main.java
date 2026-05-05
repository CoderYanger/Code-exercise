/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-04-17
 * Time: 18:35
 */
import java.util.*;
public class Main {
    //最大子矩阵
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //存储每个数
        String[] s={"69859241839387868941","17615876963131759284","37347348326627483485",
                "53671256556167864743","16121686927432329479","13547413349962773447","27979945929848824687",
                "53776983346838791379","56493421365365717745","21924379293872611382","93919353216243561277",
                "54296144763969257788","96233972513794732933","81443494533129939975","61171882988877593499",
                "61216868895721348522","55485345959294726896","32124963318242554922","13593647191934272696",
                "56436895944919899246"};
        int[][] nums=new int[20][20];
        for(int i=0;i<20;i++) for(int j=0;j<20;j++) nums[i][j]=s[i].charAt(j)-'0';
        //右下角形成正方形的和
        int[][] sum=new int[20][20];
        sum[0][0]=nums[0][0];
        //初始化第一行
        for(int i=1;i<20;i++) sum[i][0]=sum[i-1][0]+nums[i][0];
        //初始化第一列
        for(int j=1;j<20;j++) sum[0][j]=sum[0][j-1]+nums[0][j];
        //填其他位置
        for(int i=1;i<20;i++)
            for(int j=1;j<20;j++)
                sum[i][j]=sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+nums[i][j];
        //记录最大值
        int ret=sum[4][4];
        for(int i=4;i<20;i++){
            for(int j=4;j<20;j++){
                int up=i-5<0?0:sum[i-5][j];
                int left=j-5<0?0:sum[i][j-5];
                int c=(i-5<0||j-5<0)?0:sum[i-5][j-5];
                ret=Math.max(ret,sum[i][j]-up-left+c);
            }
        }
        System.out.println(ret);
        sc.close();
    }
}