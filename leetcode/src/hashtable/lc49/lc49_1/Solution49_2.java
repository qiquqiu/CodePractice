package hashtable.lc49.lc49_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution49_2 {
    // 如下为超时写法
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int strsLen = strs.length;
        if (strsLen == 1) {
            List<String> single = new ArrayList<>();
            single.add(strs[0]);
            res.add(single);
            return res;
        }
        List<String> strArr = new ArrayList<>();
        for (String s : strs) {
            strArr.add(s);
        }

        while (!strArr.isEmpty()) {
            int index = 1;
            List<String> curList = new ArrayList<>();
            while (index < strsLen) {
                if (isAnagram(strArr.get(0), strArr.get(index))) {
                    curList.add(strArr.get(index));
                    strArr.remove(index);
                    strsLen--;
                } else {
                    index++;
                }
            }
            curList.add(strArr.get(0));
            strArr.remove(0);
            strsLen--;
            res.add(curList);
        }
        return res;
    }

    // 判断字符串t是否是字符串s的字母异位词（O(2n)=O(n)）
    public boolean isAnagram(String s, String t) {
        int[] hash = new int[26];
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int len = cs.length;
        for (char aChar : cs) {
            hash[aChar - 97]++;
        }
        for (char aChar : ct) {
            if (hash[aChar - 97] != 0) {
                hash[aChar - 97]--;
                len--;
            } else {
                return false;
            }
        }
        if (len == 0) {
            return true;
        }
        return false;
    }

    public boolean isAnagram2(String s, String t) {
        Arrays.sort(s.toCharArray());
        Arrays.sort(t.toCharArray());
        return s.equals(t);
    }
}
