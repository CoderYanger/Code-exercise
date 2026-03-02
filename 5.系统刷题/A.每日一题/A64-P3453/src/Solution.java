/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-14
 * Time: 23:14
 */
//3453. 分割正方形 I
class Solution {
    //浮点二分
    public double separateSquares(int[][] squares) {
        //计算所有正方形的总面积
        long totS=0;
        //记录所有正方形的最大y坐标，作为二分查找的右边界
        int maxY=0;
        for(int[] sq:squares){
            int l=sq[2];
            totS+=(long)l*l;
            //正方形的顶部y坐标=左下角y坐标+边长
            maxY=Math.max(maxY,sq[1]+l);
        }
        //二分查找
        double left=0,right=maxY;
        for(int i=0;i<47;i++){
            double mid=left+(right-left)/2;
            if(check(squares,mid,totS)) left=mid;
            else right=mid;
        }
        return left;
    }
    private boolean check(int[][] squares,double y,long totS){
        //累加分割线y下方的面积
        double area=0;
        for(int[] sq:squares){
            //当前正方形的左下角y坐标
            double yi=sq[1];
            //只有正方形左下角在分割线下方时才能贡献面积
            if(yi<y){
                int l=sq[2];
                //计算有效高度
                //y-yi<=l：正方形部分在下方，有效高度y-yi
                //y-yi>l：正方形完全在下方，有效高度为l
                double h=Math.min(y-yi,l);
                //累加面积
                area+=l*h;
            }
        }
        return area<totS-area;
    }
}

class Solution {
    //放大整型二分——求最左端点模型
    private static final int M=100_000;
    public double separateSquares(int[][] squares) {
        long totS=0;
        int maxY=0;
        for(int[] sq:squares){
            int l=sq[2];
            totS+=(long)l*l;
            maxY=Math.max(maxY,sq[1]+l);
        }
        long left=0,right=(long)maxY*M;
        //求最左端点模型
        while(left<right){
            long mid=left+(right-left)/2;
            if(check(squares,mid,totS)) left=mid+1;
            else right=mid;
        }
        return (double)right/M;
    }
    //判断是否在最左端点的左边
    private boolean check(int[][] squares,long y,double totS){
        long area=0;
        for(int[] sq:squares){
            long yi=sq[1];
            if(yi*M<y){
                long l=sq[2];
                area+=l*Math.min(y-yi*M,l*M);
            }
        }
        return area<totS*M-area;
    }
}

class Solution {
    //补差值整型二分——求最左端点模型
    public double separateSquares(int[][] squares) {
        long totS=0;
        int maxY=0;
        for(int[] sq:squares){
            int l=sq[2];
            totS+=(long)l*l;
            maxY=Math.max(maxY,sq[1]+l);
        }
        int left=0,right=maxY;
        //求最左端点模型
        while(left<right){
            int mid=left+(right-left)/2;
            //可以用之前的判断方法，但是后续要用到求面积，所以就换了一下，本质不变
            //判断mid是否在最左端点的左边
            //判断方法保证了left最终落到的位置在大于目标位置的第一个位置
            //比如目标位置在y=1.7500，那么left就在2.0000
            if(2*clac(squares,mid)<totS) left=mid+1;
            else right=mid;
        }
        //开始回退多余的小数值
        int y=left;
        //核心原理：精准浮点数分割点=y-(多余面积/单位高度的面积增量)
        //多余面积=y下方的面积*2-总面积，得到需要回退的面积量
        long areaY=clac(squares,y);//y下方的面积
        long sumL=areaY-clac(squares,y-1);//y-1下方的面积
        //÷2是为了还原面积×2的比例
        return y-(2*areaY-totS)/(sumL*2.0);
    }
    //求分割线在y时，下方正方形的总面积
    private long clac(int[][] squares,long y){
        long area=0;
        for(int[] sq:squares){
            long yi=sq[1];
            if(yi<y){
                long l=sq[2];
                area+=(long)l*Math.min(y-yi,l);
            }
        }
        return area;
    }
}

class Solution {
    //扫描线差分
    public double separateSquares(int[][] squares) {
        long totS=0;
        TreeMap<Integer,Long> diff=new TreeMap<>();
        for(int[] sq:squares){
            int y=sq[1];
            long l=sq[2];
            totS+=l*l;
            //::是方法引用，Long::sum引用的是Long类的静态方法sum(long a,long b)，作用就是返回a+b
            diff.merge(y,l,Long::sum);
            diff.merge(y+(int)l,-l,Long::sum);
        }
        long area=0,sumL=0;
        int preY=0;//不好计算下一个y,改为维护上一个y
        //var：占位符，根据变量的初始化值，自动推断出变量的具体类型
        for(var e:diff.entrySet()){
            int y=e.getKey();
            area+=sumL*(y-preY);//新增面积=底边长×高
            if(area>=totS-area)
                return y-(2*area-totS)/(sumL*2.0);
            preY=y;
            sumL+=e.getValue();//矩形底边长度之和
        }
        //照顾编译器
        return -1;
    }
}