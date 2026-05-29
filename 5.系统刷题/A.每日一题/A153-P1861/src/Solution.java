/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-10
 * Time: 22:41
 */
class Solution {
    //1861. 旋转盒子
    //解法一：正序遍历模拟
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m=boxGrid.length,n=boxGrid[0].length;
        char[][] ret=new char[n][m];
        for(int i=0;i<m;i++){
            //遍历每一列
            int cnt=0;
            for(int j=0;j<n;j++){
                //遇到石头先设为空位置
                if(boxGrid[i][j]=='#'){
                    boxGrid[i][j]='.';
                    cnt++;
                }
                ret[j][m-1-i]=boxGrid[i][j];
                //遇到障碍物或者底部就往回填石头
                if(j==n-1||boxGrid[i][j+1]=='*'){
                    for(int k=j;cnt>0;k--,cnt--){
                        boxGrid[i][k]='#';
                        ret[k][m-1-i]=boxGrid[i][k];
                    }
                }
            }
        }
        return ret;
    }
    
    //解法二：倒序遍历模拟
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m=boxGrid.length,n=boxGrid[0].length;
        char[][] ret=new char[n][m];
        //初始化为空位置，后续往上填障碍物和石头
        for(char[] row:ret) Arrays.fill(row,'.');
        for(int i=0;i<m;i++){
            //指针k用于填障碍物和石头，从“底部”往“上”填
            int k=n-1;
            for(int j=n-1;j>=0;j--){
                //遇到障碍物
                if(boxGrid[i][j]=='*'){
                    ret[j][m-1-i]='*';
                    k=j-1;//后续石头往“上”填
                    //遇到石头
                }else if(boxGrid[i][j]=='#'){
                    ret[k][m-1-i]='#';
                    k--;//当前位置填完后，剩下的只能往“上”填
                }
                //遇到空位置
                //什么都不做，因为初始化时已解决
            }
        }
        return ret;
    }

}
