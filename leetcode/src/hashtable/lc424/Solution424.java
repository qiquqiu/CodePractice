package hashtable.lc424;

public class Solution424 {
    // 题目：替换后的最长字符
    // 输入：s = "ABAB", k = 2
    // 输出：4
    // 解释：用两个'A'替换为两个'B',反之亦然。
    public int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int distanceMaxLen = 0; // 表示在窗口内最多出现的重复字符数量
        int left = 0, right = 0, len = s.length();
        while (right < len) {
            char ch = s.charAt(right);
            map[ch - 'A']++; // 总是记录当前窗口中各字符出现的次数
            // 总是更新distanceMaxLen为窗口中出现次数最多的字符的出现次数
            distanceMaxLen = Math.max(distanceMaxLen, map[ch - 'A']);
            // 如果 窗口大小 - distanceMaxLen > k
            // 说明不能在k的范围内将其他字符变为最多出现的字符
            // 此时让左指针右移（注意无论是否left++，总会有right++，
            // 所以说窗口只会变大或者不变，不会变小）
            if (right - left + 1 - distanceMaxLen > k) {
                // 窗口左端右移，两行操作
                map[s.charAt(left) - 'A']--;
                left++;
            }
            // 否则，如果满足right - left + 1 - distanceMaxLen <= k
            // 说明k个名额完全足够将其他字符变为最多出现的字符从而被变为相同连续字符
            // 那么就继续变大（right++）窗口向右试探，如果之后不行，反正窗口也会维持上次最大状态
            // 因为窗口不会变小，顶多不变！！！又由于最终right等于了len，所以最后直接返回right - left
            // 不用再加1，就是窗口最大长度
            right++;
        }
        return right - left;
    }
}
