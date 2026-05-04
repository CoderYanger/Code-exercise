/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-04-17
 * Time: 18:33
 */
import java.util.*;
public class Main {
    //字符统计
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s=sc.nextLine();
        int[] hash=new int[26];
        for(char c:s.toCharArray()) hash[c-'A']++;
        int mx=0;
        for(int i=0;i<26;i++) mx=Math.max(mx,hash[i]);
        StringBuffer cur=new StringBuffer();
        for(int i=0;i<26;i++) if(hash[i]==mx) cur.append((char)(i+'A'));
        System.out.println(cur.toString());
        sc.close();
    }
}