/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-04
 * Time: 23:29
 */
class Solution {
    //2211. 统计道路上的碰撞次数
    public int countCollisions(String s) {
        //往左：-1，撞停：0，往右：记录个数
        int prev=-1;
        int ret=0;
        for(char c:s.toCharArray()){
            if(c=='L'){
                if(prev>=0){
                    //只有一个R和L相撞，之后就是撞停的了
                    ret+=prev+1;
                    prev=0;
                }
            }else if(c=='R'){
                if(prev<=0) prev=1;
                else prev++;
            }else{
                if(prev>0) ret+=prev;
                prev=0;
            }
        }
        return ret;
    }

    public int countCollisions(String s) {
        int n=s.length();
        int l=0,r=n-1;
        while(l<n&&s.charAt(l)=='L') l++;
        while(r>=l&&s.charAt(r)=='R') r--;
        int ret=0;
        for(int i=l;i<=r;i++)
            if(s.charAt(i)!='S') ret++;
        return ret;
    }
}