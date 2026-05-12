/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-29
 * Time: 20:38
 */
import java.util.*;
public class Main{
    //回文字符串
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        for(int i=0;i<N;i++){
            String s=sc.next();
            int n=s.length();
            boolean mark=false;//标记当前字符串能否转成回文
            for(int k=0;k<=n;k++){
                if(k>0&&!ismatch(s.charAt(n-k))) break;
                if(islegal(s,0,n-1-k)){mark=true;break;}
            }
            System.out.println(mark?"Yes":"No");
        }
        sc.close();
    }
    private static boolean ismatch(char c){
        return c=='l'||c=='q'||c=='b';
    }
    private static boolean islegal(String s,int left,int right){
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    //博主一开始的错误思路
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        String[] s=new String[N];
        for(int i=0;i<N;i++){
            s[i]=sc.next();
            int n=s[i].length();
            int left=0,right=n-1;
            boolean mark=true;//标记当前字符串能否转成回文
            while(left<right){
                if(s[i].charAt(left)!=s[i].charAt(right)){
                    if(left==0&&ismatch(s[i].charAt(right))){right--;continue;}
                    else{mark=false;break;}
                }
                right--;
                left++;
            }
            System.out.println(mark?"Yes":"No");
        }
        sc.close();
    }
    private static boolean ismatch(char c){
        return c=='l'||c=='q'||c=='b';
    }
    
}
