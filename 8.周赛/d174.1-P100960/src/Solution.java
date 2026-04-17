import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-18
 * Time: 17:19
 */
class Solution {
    //100960. 最好可到达的塔
    public int[] bestTower(int[][] towers, int[] center, int radius) {
        int n=towers.length;
        List<int[]> list=new ArrayList<>();
        int x1=center[0],y1=center[1];
        for(int i=0;i<n;i++){
            int x2=towers[i][0],y2=towers[i][1];
            int dis=Math.abs(x2-x1)+Math.abs(y2-y1);
            if(dis<=radius) list.add(new int[]{x2,y2,towers[i][2]});
        }
        if(list.size()==0) return new int[]{-1,-1};
        Collections.sort(list,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                if(a[2]-b[2]!=0) return b[2]-a[2];
                if(a[0]-b[0]!=0) return a[0]-b[0];
                return a[1]-b[1];
            }
        });
        int[] a=list.get(0);
        return new int[]{a[0],a[1]};
    }
}
