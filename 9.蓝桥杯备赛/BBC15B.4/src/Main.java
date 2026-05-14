/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-29
 * Time: 20:43
 */
import java.util.*;
public class Main{
    //食堂
    //超时代码
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] a=new int[n][5];
        for(int i=0;i<n;i++){
            for(int j=0;j<5;j++) a[i][j]=sc.nextInt();
            int ret=0;
            //4桌：①4人寝
            //②2人寝>=2时，2人寝+2人寝
            //③2人寝<=1时，3人寝
            while(a[i][3]>0){
                if(a[i][2]>0){a[i][2]--;a[i][3]--;ret+=4;}
                else if(a[i][0]>=2){a[i][0]-=2;a[i][3]--;ret+=4;}
                else if(a[i][1]>0){a[i][1]--;a[i][3]--;ret+=3;}
                else if(a[i][0]>0){a[i][0]--;a[i][3]--;ret+=2;}
            }
            //6桌：
            //放6个人
            //①3人寝>=2时，3人寝+3人寝
            //②4人寝>=1且2人寝>=1时，4人寝+2人寝
            //③2人寝>=3时，2人寝+2人寝+2人寝
            //放5个人
            //④3人寝>=1且2人寝>=1，3人寝+2人寝
            //放4个人
            //⑤2人寝>=2，2人寝+2人寝
            //⑥4人寝>=1，4人寝
            //放3个人
            //⑦3人寝>=1，3人寝
            while(a[i][4]>0){
                if(a[i][1]>=2){a[i][1]-=2;a[i][4]--;ret+=6;}
                else if(a[i][2]>=1&&a[i][0]>=1){a[i][2]--;a[i][0]--;a[i][4]--;ret+=6;}
                else if(a[i][0]>=3){a[i][0]-=3;a[i][4]--;ret+=6;}
                else if(a[i][1]>=1&&a[i][0]>=1){a[i][1]--;a[i][0]--;a[i][4]--;ret+=5;}
                else if(a[i][0]>=2){a[i][0]-=2;a[i][4]--;ret+=4;}
                else if(a[i][2]>0){a[i][2]--;a[i][4]--;ret+=4;}
                else if(a[i][1]>0){a[i][1]--;a[i][4]--;ret+=3;}
                else if(a[i][0]>0){a[i][0]--;a[i][4]--;ret+=2;}
            }
            System.out.println(ret);
        }
        sc.close();
    }

    //优化版
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while(n-->0){
            long a2=sc.nextLong();
            long a3=sc.nextLong();
            long a4=sc.nextLong();
            long b4=sc.nextLong();
            long b6=sc.nextLong();
            long ret=0;
            if(b4>0){
                if(a4>0){long mn=Math.min(b4,a4);a4-=mn;b4-=mn;ret+=4*mn;}
                if(a2>=2){long mn=Math.min(b4,a2/2);a2-=2*mn;b4-=mn;ret+=4*mn;}
                if(a3>0){long mn=Math.min(b4,a3);a3-=mn;b4-=mn;ret+=3*mn;}
                if(a2>0){long mn=Math.min(b4,a2);a2-=mn;b4-=mn;ret+=2*mn;}
            }
            if(b6>0){
                if(a3>=2){long mn=Math.min(b6,a3/2);a3-=2*mn;b6-=mn;ret+=6*mn;}
                if(a4>0&&a2>0){long mn=Math.min(b6,Math.min(a4,a2));a4-=mn;a2-=mn;b6-=mn;ret+=6*mn;}
                if(a2>=3){long mn=Math.min(b6,a2/3);a2-=3*mn;b6-=mn;ret+=6*mn;}
                if(a3>0&&a2>0){long mn=Math.min(b6,Math.min(a3,a2));a3-=mn;a2-=mn;b6-=mn;ret+=5*mn;}
                if(a4>0){long mn=Math.min(b6,a4);a4-=mn;b6-=mn;ret+=4*mn;}
                if(a2>=2){long mn=Math.min(b6,a2/2);a2-=2*mn;b6-=mn;ret+=4*mn;}
                if(a3>0){long mn=Math.min(b6,a3);a3-=mn;b6-=mn;ret+=3*mn;}
                if(a2>0){long mn=Math.min(b6,a2);a2-=mn;b6-=mn;ret+=2*mn;}
            }
            System.out.println(ret);
        }
        sc.close();
    }
    
}
