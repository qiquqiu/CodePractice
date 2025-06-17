package hashtable.lc76;

public class Solution76 {
    // 滑动窗口法
    public String minWindow(String s, String t) {
        int[] hash = new int[128];
        char[] ct = t.toCharArray();
        char[] cs = s.toCharArray();

        // 先将短的字符串t转成哈希表用于后序比对
        for (int i = 0; i < t.length(); i++) {
            hash[ct[i]]++;
        }

        // count用来保存滑动窗口中应该出现的t中的字符的个数
        // 或者说是当前窗口中尚未包含的t中的字符的个数（此实现是减法的思路）
        int left = 0, right = 0, ansLeft = 0, ansRight = 0, minLen = cs.length + 1, count = ct.length;

        while (right < cs.length) {
            // 无论窗口右端的字符“cs[right]”是否是t中的字符，都将哈希表“cs[right]”出现次数自减1，然后right后移
            // 若窗口右端是t中字符，将应该出现的t中的字符数count减一（表示已经出现了一个了）
            if (hash[cs[right]] > 0) {
                count--;
            }
            hash[cs[right]]--;
            right++;
            // 若窗口已经全部包含t中所有字符，已经找到可行解
            // 循环找该可行解（right固定，left++）下的最小解
            while (count == 0) {
                // 保存、更新“已经包含全部t中字符的窗口”的长度right - left
                // 并且保存该窗口的左右索引
                if (right - left < minLen) {
                    minLen = right - left;
                    ansLeft = left;
                    ansRight = right;
                }
                // 从窗口左端开始，缩小窗口，如果‘遇到t中的字符①’就count++，因为窗口又少了一个t中字符
                // ①解释：注意判断标准是“0”，而能够进入本while的条件是count==0，也就是所有t中字符的哈希值都是0了！
                if (hash[cs[left]] == 0) {
                    count++;
                }
                // 同理地，无论字符“cs[left]”是否是t中的字符，都将哈希表“cs[left]”出现次数加1
                // 这样与Line25一互补，刚好导致了我们之前扩展窗口（即right+++）的过程中导致的非t中字符的哈希表中
                // 的也被减了的值可以重新加回来；总的来说就是关心特定字符下操作“count”
                hash[cs[left]]++;
                left++;
            }
        }
        // substring(ansLeft, ansRight) 含左不含右，因为在count--之后right又加了1
        return minLen == cs.length + 1 ? "" : s.substring(ansLeft, ansRight);
    }
}