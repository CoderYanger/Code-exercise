/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-06-26
 * Time: 15:54
 */
class Solution {
    //1344. 时钟指针的夹角
    //解法一：刻度法
    public double angleClock(int hour, int minutes) {
        // 分针所在的刻度位置（每5分钟1个大刻度）
        double minuteMark = minutes / 5.0;
        // 时针所在的刻度位置（整点刻度 + 分钟带来的偏移）
        double hourMark = (hour % 12) + minutes / 60.0;
        // 刻度差的绝对值
        double diffMark = Math.abs(hourMark - minuteMark);
        // 每个刻度对应 30 度
        double angle = diffMark * 30;
        // 取较小夹角
        return Math.min(angle, 360 - angle);
    }

    //解法二：角度法
    public double angleClock(int hour, int minutes) {
        // 1. 计算分针角度：每分钟走 6 度 (360/60)
        double minuteAngle = minutes * 6.0;
        // 2. 计算时针角度：整点走 30 度/小时 + 分钟偏移 0.5 度/分钟
        // hour%12 处理 12 点等价于 0 点的情况
        double hourAngle = (hour % 12) * 30.0 + minutes * 0.5;
        // 3. 求两针角度差的绝对值
        double diff = Math.abs(hourAngle - minuteAngle);
        // 4. 返回较小的夹角（圆周 360 度，取小的那段弧）
        return Math.min(diff, 360 - diff);
    }
    
}
