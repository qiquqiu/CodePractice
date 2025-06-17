package twopointer.lc844;

public class Solution844_2 {
    // 2.使用双指针法实现（进阶：时间复杂度O(n)，空间复杂度是O(1)）
    public boolean backspaceCompare(String s, String t) {
        // 逆序操作
        return dealBackspace(s).equals(dealBackspace(t));
    }

    public String dealBackspace(String s) {
        char[] cs = s.toCharArray();
        // 从后面开始逆序更新覆盖数组的索引的慢指针
        int slow = cs.length - 1;
        // 代表当前还需删除的字符个数
        int skip = 0;
        for (int fast = cs.length - 1; fast >= 0; fast--) {
            // 由于只是遍历完原字符串，所以最后如果skip不为0也不会有影响
            if (cs[fast] == '#') {
                skip++;
            } else {
                if (skip == 0) {
                    cs[slow--] = cs[fast];
                } else {
                    skip--;
                }
            }
        }
        return new String(cs).substring(slow + 1);
    }
}

