import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-12
 * Time: 16:41
 */
class Solution {
    //3433. 统计用户被提及情况
    public int[] countMentions(int num, List<List<String>> events) {
        //按照时间戳从小到大排序，时间戳相同时，离线事件排在前面
        events.sort((a,b)->{
            int ta=Integer.parseInt(a.get(1));
            int tb=Integer.parseInt(b.get(1));
            return ta!=tb?ta-tb:b.get(0).charAt(0)-a.get(0).charAt(0);
        });
        int[] ret=new int[num];
        int[] online=new int[num];
        for(List<String> e:events){
            //获取当前时间
            int cur=Integer.parseInt(e.get(1));
            //获取事件状态
            String men=e.get(2);
            //离线状态
            if(e.get(0).charAt(0)=='O')
                //获取离线状态用户的id，并计算该用户下次在线时间
                online[Integer.parseInt(men)]=cur+60;
                //@所有人
            else if(men.charAt(0)=='A')
                for(int i=0;i<num;i++)
                    ret[i]++;
                //@所有在线用户
            else if(men.charAt(0)=='H')
                for(int i=0;i<num;i++){
                    if(online[i]<=cur)//确保在线
                        ret[i]++;
                }
                //@指定id
            else
                //按空格把字符串拆分成字符串数组
                for(String s:men.split(" ")){
                    //substring截取id后的数字
                    int i=Integer.parseInt(s.substring(2));
                    ret[i]++;
                }
        }
        return ret;
    }
}
