package hashtable.lc03;

import java.util.ArrayList;
import java.util.Optional;

/*
 * 该方法不行！！
 * 所谓的 spitStr 结合 这个for循环 for (int i = -1; i < str.length(); i++)
 * 以为能够获取到所有的“子串”，但是并不行！！！，例如：pwwkew的后四位，是没有办法通过这个获取的
 * 而尚在还未达到目标的情况下就已经如此复杂了，想要沿着这个思路继续去做显然是更困难的……
 *
 * */

public class DifStr01 {
    public static void main(String[] args) {
        Solution sss = new Solution();
        sss.lengthOfLongestSubstring("pwwkew");
    }
}

class Solution {
    ArrayList<Integer> list;

    public int lengthOfLongestSubstring(String str) {
        for (int i = -1; i < str.length(); i++) {
            spitStr(delByIndex(str, i));
        }
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println((Integer) list.get(i));
//        }
        Optional<Integer> max = list.stream().max(Integer::compareTo);
        if (max.isPresent()) {
            System.out.println("最大值是: " + max.get());
        }
        return 0;
    }

    public void spitStr(String str) {
        list = new ArrayList<>();
        String left = "";
        String right = "";
        for (int i = str.length(); i > 0; i--) {
//            System.out.println("i = " + i);
            for (int j = 0; j < str.length(); ) {
                if (j + i < str.length()) {
                    left = str.substring(j, j + i);
                    if (j + i + i < str.length()) {
                        right = str.substring(j + i, j + i + i);
                    } else {
                        right = str.substring(j + i);
                    }
                } else {
                    left = str.substring(j);
                    right = "";//起重置作用
                }

                j = j + i + i;//abcabcbb            abc abc bb

//                System.out.println("left = " + left);
//                System.out.println("right = " + right + "\n");
                if (isNoReap(left)) {
                    list.add(left.length());
                }
                if (!right.isEmpty() && isNoReap(right)) {
                    list.add(right.length());
                }
            }
        }
    }

    public String delByIndex(String str, int index) {
        if (index == 0) {
            str = str.substring(1);
        } else if (index == str.length() - 1) {
            str = str.substring(0, index);
        } else if (index == -1) {

        } else {
            String s1 = str.substring(0, index);
            String s2 = str.substring(index + 1);
            str = s1 + s2;
        }
        return str;
    }

    public boolean isNoReap(String str) {
        if (str.equals("")) {
            return false;
        }
        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i; j < str.length() - 1; j++) {
                if (str.charAt(i) == str.charAt(j + 1)) {
                    return false;
                }
            }
        }
        return true;
    }
}