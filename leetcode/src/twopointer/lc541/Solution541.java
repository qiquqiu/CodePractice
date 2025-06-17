package twopointer.lc541;

public class Solution541 {
    public String reverseStr(String s, int k) {
        char[] cs = s.toCharArray();
        int l = 0, r = l + 2 * k - 1;
        // 剩余部分还能凑成2k个
        while (r < cs.length) {
            // 就反转这2k个的前k个
            reverse(cs, l, r - k);
            // 窗口移动
            l += 2 * k;
            r += 2 * k;
        }
        // 如果剩余部分字符大于等于k个
        if (cs.length - l >= k) {
            reverse(cs, l, l + k - 1);
        } else {
            // 如果剩余部分字符少于k个
            reverse(cs, l, cs.length - 1);
        }
        return new String(cs);
    }

    // 提取方法：把指定的char从begin索引到end索引之间字符反转（闭区间）
    public void reverse(char[] cs, int begin, int end) {
        char temp = ' ';
        while (begin < end) {
            temp = cs[begin];
            cs[begin] = cs[end];
            cs[end] = temp;
            begin++;
            end--;
        }
    }
}