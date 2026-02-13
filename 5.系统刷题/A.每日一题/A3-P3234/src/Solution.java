import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-15
 * Time: 19:29
 */
class Solution {
    //3234. 统计 1 显著的字符串的数量
    public int numberOfSubstrings(String s) {
        int n = s.length();
        // 记录所有 '0' 的索引
        List<Integer> zeros = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                zeros.add(i);
            }
        }
        // 在末尾添加 n 作为哨兵，处理边界:最后一个0之后的全1字符串
        zeros.add(n);
        int m = zeros.size();

        int ans = 0;
        // 在 zeros 列表中的索引，指向 left 右侧的第一个 '0'
        int zero_idx = 0;

        // 枚举子串起始位置
        for (int left = 0; left < n; left++) {
            // 子字符串不包含 '0'
            ans += zeros.get(zero_idx) - left;

            // 子字符串包含 '0'，枚举可能的 '0' 的数量 c0
            // j 是 zeros 列表的索引
            for (int j = zero_idx; j < m - 1; j++) {
                // 子字符串中 '0' 的数量
                int c0 = j - zero_idx + 1;

                // 如果 c0*c0 > n, 那么 c1 必然小于 c0*c0
                if (c0 * c0 > n) {
                    break;
                }

                // 最后一个 '0' 的位置
                int end_zeros_pos = zeros.get(j);
                // 下一个 '0' 的位置
                int next_zero_pos = zeros.get(j + 1);

                // 合法的右端点 right 需要满足三个条件:
                // 1. right >= end_zeros_pos (必须包含这 c0 个 '0')
                // 2. right < next_zero_pos (不能包含第 c0+1 个 '0')
                // 3. right >= left + c0*c0 + c0 - 1 (满足 "1显著" 条件)

                // right的起始节点
                //end_zeros_pos：子串必须包含这c0个0，不然0的个数不够
                //left + c0 * c0 + c0 - 1：子串里1的个数至少是c0²->right至少要到这个位置
                int start_r = Math.max(end_zeros_pos, left + c0 * c0 + c0 - 1);
                // right的结束节点
                int end_r = next_zero_pos - 1;
                // 存在合法的右端点right->即代表有多少个[left,right]的子串
                if (start_r <= end_r) {
                    ans += (end_r - start_r + 1);
                }
            }

            // 当前位置变为 '0'，更新->保证zer0_idx始终指向left右边第一个0
            if (zero_idx < m && zeros.get(zero_idx) == left) {
                zero_idx++;
            }
        }

        return ans;
    }
}
