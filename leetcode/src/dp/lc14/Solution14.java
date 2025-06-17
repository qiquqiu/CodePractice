package dp.lc14;

public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0]; // 默认第一个单词为最长公共前缀
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) { // 只有indexOf=0,才说明是公共前缀
                prefix = prefix.substring(0, prefix.length() - 1); // 每次去除末尾的字符
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    /*public String longestCommonPrefix(String[] strs) {
        StringBuilder ret = new StringBuilder();
        boolean flag = true;
        if (strs.length == 1 && strs[0] == "") {
            return "";
        }
        int len = getShortest(strs).length();
        int k = 0;
        while (true) {
            int i = 0;
            for (i = 0; i < strs.length - 1; i++) {
                if (strs[i].charAt(k) != strs[i+1].charAt(k)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ret.append(strs[i].charAt(k));
                k++;
                //出来时i显然不是0，不过既然相同才能到此也无所谓了
            } else {
                break;
            }
            if (k >= len) {
                break;
            }
        }
        return ret.toString();
    }

    public String getShortest(String[] strs) {
        String shortest = strs[0];
        for (String str : strs) {
            if (str.length() < shortest.length()) {
                shortest = str;
            }
        }
        return shortest;
    }*/
}
