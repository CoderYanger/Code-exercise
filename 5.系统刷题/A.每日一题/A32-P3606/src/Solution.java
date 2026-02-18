import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-13
 * Time: 19:01
 */
class Solution {
    //3606. 优惠券校验器
    public List<String> validateCoupons(String[] c, String[] b, boolean[] isActive) {
        int n=c.length;
        List<String> ret=new ArrayList<>();
        String[][] tmp=new String[n][2];
        for(int i=0;i<n;i++){
            if(isc(c[i])&&isb(b[i])&&isActive[i]){
                tmp[i][0]=c[i];
                tmp[i][1]=b[i];
            }else{
                //标记为无效记录，防止空指针报错
                tmp[i][0]="";
                tmp[i][1]="";
            }
        }
        Arrays.sort(tmp,(x,y)->{
            //处理空记录：空记录排在最后
            if(x[0].equals("")&&y[0].equals("")) return 0;
            if(x[0].equals("")) return 1;//x为空，x在后面
            if(y[0].equals("")) return -1;//y为空，x在前面
            //先比较品牌首字符
            int tmpret=Character.compare(x[1].charAt(0),y[1].charAt(0));
            if(tmpret!=0) return tmpret;
            //品牌首字母相同，再比较代码
            return x[0].compareTo(y[0]);
        });
        for(String[] t:tmp){
            if(t[0].equals("")) continue;
            ret.add(t[0]);
        }
        return ret;
    }
    private boolean isc(String s){
        for(char c:s.toCharArray()){
            if(!(c>='a'&&c<='z')&&!(c>='A'&&c<='Z')
                    &&!(c>='0'&&c<='9')&&!(c=='_'))
                return false;
        }
        return true;
    }
    private boolean isb(String s){
        return (s.equals("electronics")||s.equals("grocery")||s.equals("pharmacy")||s.equals("restaurant"));
    }


//用comparable接口并实现compareTo的正确写法
class Coupon implements Comparable<Coupon>{
    String code;//优惠卷代码
    String brand;//品牌
    public Coupon(String code,String brand){
        this.code=code;
        this.brand=brand;
    }
    @Override
    public int compareTo(Coupon other){
        //这次空记录根本添加不需添加进来，所以原本的下面处理空记录的代码不生效
        // //处理空记录：空记录排在最后
        // if(this.code.equals("")&&other.code.equals("")) return 0;
        // if(this.code.equals("")) return 1;//x为空，x在后面
        // if(other.code.equals("")) return -1;//y为空，x在前面
        //先比较品牌首字符
        int tmpret=this.brand.compareTo(other.brand);
        if(tmpret!=0) return tmpret;
        //品牌首字母相同，再比较代码
        return this.code.compareTo(other.code);
    }
}
class Solution {
    public List<String> validateCoupons(String[] c, String[] b, boolean[] isActive) {
        int n=c.length;
        List<String> ret=new ArrayList<>();
        List<Coupon> coupons=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(isc(c[i])&&isb(b[i])&&isActive[i])
                coupons.add(new Coupon(c[i],b[i]));
            //无效数据不需添加
        }
        Collections.sort(coupons);
        for(Coupon coupon:coupons)
            ret.add(coupon.code);
        return ret;
    }
    private boolean isc(String s){
        if(s==null||s.equals("")) return false;
        for(char c:s.toCharArray()){
            if(!(c>='a'&&c<='z')&&!(c>='A'&&c<='Z')
                &&!(c>='0'&&c<='9')&&!(c=='_')) 
            return false;
        }
        return true;
    }
    private boolean isb(String s){
        //注意判断空串""要用equals而不是==
        if(s==null||s.equals("")) return false;
        return (s.equals("electronics")||s.equals("grocery")||s.equals("pharmacy")||s.equals("restaurant"));
    }
}

//用Comparator为自定义类实现多套排序规则
class Coupon{
    String code;//优惠卷代码
    String brand;//品牌
    public Coupon(String code,String brand){
        this.code=code;
        this.brand=brand;
    }
}
class Solution {
    public List<String> validateCoupons(String[] c, String[] b, boolean[] isActive) {
        int n=c.length;
        List<String> ret=new ArrayList<>();
        List<Coupon> coupons=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(isc(c[i])&&isb(b[i])&&isActive[i])
                coupons.add(new Coupon(c[i],b[i]));
            //无效数据不需添加
        }
        //用Comparator为自定义类实现多套排序规则体现在这儿
        //规则1：单纯按品牌升序排序
        Comparator<Coupon> bybrand=new Comparator<Coupon>(){
            @Override 
            public int compare(Coupon c1,Coupon c2){
                return c1.brand.compareTo(c2.brand);//写法一
                return Comparator.<String>naturalOrder().compare(c1.brand,c2.brand);//写法二
            }
        };
        //规则2：单纯按代码升序排序
        Comparator<Coupon> bycode=new Comparator<Coupon>(){
            @Override 
            public int compare(Coupon c1,Coupon c2){
                // return c1.code.compareTo(c2.code);//写法一
                return Comparator.<String>naturalOrder().compare(c1.code,c2.code);//写法二
            }
        };
        //规则3：先按品牌升序，再按代码升序
        Comparator<Coupon> brandandcode=new Comparator<Coupon>(){
            @Override 
            public int compare(Coupon c1,Coupon c2){
                int brandcompare=c1.brand.compareTo(c2.brand);//写法一
                //int brandcompare=Comparator.<String>naturalOrder().compare(c1.brand,c2.brand);//写法二
                if(brandcompare!=0) return brandcompare;
                return c1.code.compareTo(c2.code);//写法一
                //Comparator.<String>naturalOrder().compare(c1.code,c2.code);//写法二
            }
        };
        //用Comparator定义了三套比较规则，但是我们需要的是第三套
        Collections.sort(coupons,brandandcode);
        for(Coupon coupon:coupons)
            ret.add(coupon.code);
        return ret;
    }
    private boolean isc(String s){
        if(s==null||s.equals("")) return false;
        for(char c:s.toCharArray()){
            if(!(c>='a'&&c<='z')&&!(c>='A'&&c<='Z')
                &&!(c>='0'&&c<='9')&&!(c=='_')) 
            return false;
        }
        return true;
    }
    private boolean isb(String s){
        //注意判断空串""要用equals而不是==
        if(s==null||s.equals("")) return false;
        return (s.equals("electronics")||s.equals("grocery")||s.equals("pharmacy")||s.equals("restaurant"));
    }
}
}
