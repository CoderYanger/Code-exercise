/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-18
 * Time: 17:43
 */
class Solution {
    //1442. 形成两个异或相等数组的三元组数目
    public int countTriplets(int[] arr) {
        int n=arr.length;
        //xor[k]：从下标0一直到arr[k-1]的下标结果
        int[] xor=new int[n+1];
        for(int k=1;k<=n;k++) xor[k]=xor[k-1]^arr[k-1];
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                for(int k=j;k+1<=n;k++){
                    int a=xor[j]^xor[i];
                    int b=xor[k+1]^xor[j];
                    if(a==b) cnt++;
                }
            }
        }
        return cnt;
    }

    //1442. 形成两个异或相等数组的三元组数目
    //优化
    public int countTriplets(int[] arr) {
        int n=arr.length;
        //xor[k]：从下标0一直到arr[k-1]的下标结果
        int[] xor=new int[n+1];
        for(int k=1;k<=n;k++) xor[k]=xor[k-1]^arr[k-1];
        int cnt=0;
        for(int i=0;i<n;i++)
            for(int k=i+1;k+1<=n;k++)
                if(xor[i]==xor[k+1]) cnt+=(k-i);
        return cnt;
    }
    
}
