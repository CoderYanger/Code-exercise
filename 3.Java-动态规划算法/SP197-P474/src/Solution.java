/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-29
 * Time: 16:15
 */
class Solution {
    //474. 一和零
    //优化前的代码
    public int findMaxForm(String[] strs, int m, int n) {
        int len=strs.length;
        int[][][] dp=new int[len+1][m+1][n+1];
        // dp[0][0][0]=1;
        for(int i=1;i<=len;i++){
            //统计此字符串中0和1的个数
            int a=0,b=0;
            //我的写法：一开始忘记下标的映射关系导致报错了
            // for(int c=0;c<strs[i-1].length();c++){
            //     char ch=strs[i-1].charAt(c);
            //     if(ch=='0') a++;else b++;
            // }
            //吴小哲的写法：本质上跟我的一样
            for(char ch:strs[i-1].toCharArray())
                if(ch=='0') a++;else b++;
            //注意这里j和k都从0开始，跟之前的一样，肯定不会越界，就放在填表逻辑中填了（不要钻牛角尖）
            for(int j=0;j<=m;j++){
                for(int k=0;k<=n;k++){
                    dp[i][j][k]=dp[i-1][j][k];
                    if(j>=a&&k>=b)
                        dp[i][j][k]=Math.max(dp[i][j][k],dp[i-1][j-a][k-b]+1);
                }
            }
        }
        return dp[len][m][n];
    }

    //空间优化后的版本
    //降为二维
    //修改遍历顺序（因为用到的是i-1那一面的数据，属于用之前的数据更新现在的数据）
    public int findMaxForm2(String[] strs, int m, int n) {
        int len=strs.length;
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=len;i++){
            //统计此字符串中0和1的个数
            int a=0,b=0;
            //吴小哲的写法：本质上跟我的一样
            for(char ch:strs[i-1].toCharArray())
                if(ch=='0') a++;else b++;
            for(int j=m;j>=a;j--)//修改遍历顺序，同时做时间上常数级优化，删掉if
                for(int k=n;k>=b;k--)//修改遍历顺序，同时做时间上常数级优化，删掉if
                    // dp[i][j][k]=dp[i-1][j][k];
                    dp[j][k]=Math.max(dp[j][k],dp[j-a][k-b]+1);
        }
        return dp[m][n];
    }
}