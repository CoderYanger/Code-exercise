/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-18
 * Time: 20:02
 */
class Solution {
    //717. 1 比特与 2 比特字符
    public boolean isOneBitCharacter(int[] bits) {
        int n=bits.length;
        int index=0;
        while(index<n-1){
            //1的后面必须带一个
            if(index<n&&bits[index]==1) index+=2;
                //是0的话只能是一个字符
            else index++;
        }
        //判断能不能走到最后一个
        return index==n-1;
    }
}