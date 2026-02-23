/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-01
 * Time: 16:08
 */
class Solution {
    //840. 矩阵中的幻方
    public int numMagicSquaresInside(int[][] nums) {
        int m=nums.length,n=nums[0].length;
        int ret=0;
        //枚举每个幻方的左上角
        for(int i=0;i<m-2;i++){
            for(int j=0;j<n-2;j++){
                if(nums[i+1][j+1]!=5) continue;
                if(islegal(nums[i][j],nums[i][j+1],nums[i][j+2],
                        nums[i+1][j],nums[i+1][j+1],nums[i+1][j+2],
                        nums[i+2][j],nums[i+2][j+1],nums[i+2][j+2]))
                    ret++;
            }
        }
        return ret;
    }
    public boolean islegal(int... val){
        int[] count=new int[16];
        for(int v:val) count[v]++;
        //幻方中1~9每个数必须只出现一次
        for(int v=1;v<=9;v++)
            if(count[v]!=1)
                return false;//数字缺失或重复，必定不是幻方
        return (val[0]+val[1]+val[2]==15&&//第一行
                val[3]+val[4]+val[5]==15&&//第二行
                val[6]+val[7]+val[8]==15&&//第三行
                val[0]+val[3]+val[6]==15&&//第一列
                val[1]+val[4]+val[7]==15&&//第二列
                val[2]+val[5]+val[8]==15&&//第三列
                val[0]+val[4]+val[8]==15&&//主对角线
                val[2]+val[4]+val[6]==15);//副对角线
    }
}