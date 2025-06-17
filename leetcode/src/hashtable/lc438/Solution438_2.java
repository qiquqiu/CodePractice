package hashtable.lc438;

import java.util.ArrayList;
import java.util.List;

public class Solution438_2 {
    // 2.滑动窗口解法
    public List<Integer> findAnagrams(String s, String p) {
        int[] hash = new int[26];
        char[] cs = s.toCharArray();
        for (int i = 0; i < p.length(); i++) {
            hash[p.charAt(i) - 'a']++;
        }
        List<Integer> res = new ArrayList<>();
        int left = 0;
        for (int right = 0; right < cs.length; right++) {
            // 先将读取的在其哈希表中自减
            hash[cs[right] - 'a']--;
            // 一旦当前窗口右端是非目标字符，则一直把左边自减的自增回来
            // 并且不断右移左指针，直到左指针回到right本位置才结束while
            // 对于开始的时候，就是这样的效果：如果cs[right]不是目标字符
            // 则通过右移左指针，来进而整体右移动窗口，因为开始的时候
            // left就等于right=0，下面的if就不会被执行，只会出现left自增后
            // right再自增，直到cs[right]是目标字符进而只需判断长度上是否符合即可
            // 已经不需要判断字符匹配问题了，因为while循环严格实现了此点，很妙！
            // 这里关键是“left”的处理！！！
            while (hash[cs[right] - 'a'] < 0) {
                hash[cs[left] - 'a']++;
                left++;
            }
            if (right - left + 1 == p.length()) {
                res.add(left);
            }
        }
        return res;
    }
}
