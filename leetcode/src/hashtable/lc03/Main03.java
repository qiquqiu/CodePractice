package hashtable.lc03;

import java.util.HashSet;
import java.util.Set;

public class Main03 {
    public static void main(String[] args) {//abcabcbb
        Solution03 solution03 = new Solution03();
        int res = solution03.lengthOfLongestSubstring("dvdf");
        System.out.println("无重复字符的最长子串：" + res);
    }
}

class Solution03 {
    // leetcode第三题：寻找无重复字符的最长子串
    // 滑动窗口解决（显然要使用哈希表来实现）
    // 但是我们自己写哈希表来每次总是判断一整个子串有无重复字符还是太麻烦
    // 所以直接使用HashSet，注意使用add添加进入HashSet的元素，在遍历HashSet
    // 的时候并不是按照我们添加的顺序来遍历元素，不过好在本题需求最终的长度而非串
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        char[] cs = s.toCharArray();
        Set<Character> hash = new HashSet<>();
        int left = 0, right = 0, res = 1;
        while (right < cs.length) {
            if (!hash.contains(cs[right])) {
                // 如果当前窗口右边尚未重复，则直接加入并且计算长度
                hash.add(cs[right++]);
            } else {
                // 若再向右包含一个出现重复，则针对此窗口从左开始缩小
                // 直到cs[right]在“哈希表中”不再是重复的字符串
                // 而想要达到上一行的效果，就必须在“cs[left]”处删除与cs[right]
                // 相同的字符，从而实现消除重复使达唯一
                // 这里的删除，是直接从哈希表中删除
                hash.remove(cs[left++]);
            }
            // 由于right在内部++了，所以长度直接右-左即可
            res = Math.max(res, right - left);
        }
        return res;
    }
}
