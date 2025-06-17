package hashtable.lc438;

import java.util.ArrayList;
import java.util.List;

public class Solution438 {
    // 链接：
    // https://leetcode.cn/problems/find-all-anagrams-in-a-string/solutions/9749/hua-dong-chuang-kou-tong-yong-si-xiang-jie-jue-zi-/

    // 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，
    // 返回这些子串的起始索引。不考虑答案输出的顺序。
    // 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
    // 注：s和p只含有小写字母(这里为了避免每次减97或者减‘a’麻烦就直接开128)

    // 输入: s = "cbaebabacd", p = "abc"
    // 输出: [0,6]
    // 解释:
    // 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
    // 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。

    // 1.暴力解法
    public List<Integer> findAnagrams(String s, String p) {
        int[] hash = new int[128];
        int[] temp = new int[128];
        // 先将判断标准p中的字符保存哈希表
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        char[] cs = s.toCharArray();
        List<Integer> res = new ArrayList<>();
        int left = 0, slen = s.length(), plen = p.length(), count;
        boolean isValid;
        for (int right = left + plen - 1; right < slen; left++, right++) {
            isValid = true;
            count = plen;
            System.arraycopy(hash, 0, temp, 0, 128);
            for (int i = left; i <= right; i++) {
                if (temp[cs[i]] == 0) {
                    isValid = false;
                    break;
                } else {
                    temp[cs[i]]--;
                    count--;
                }
            }
            if (isValid && count == 0) {
                res.add(left);
            }
        }
        return res;
    }
}

