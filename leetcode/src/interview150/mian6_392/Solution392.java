package interview150.mian6_392;

public class Solution392 {
    // 简单双指针思路，成功击败100%，开始想哈希，既复杂又错误了
    public boolean isSubsequence(String s, String t) {
        if (s.equals("")) {
            return true;
        }
        if (s.length() == 1) {
            return t.contains(s);
        }

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        int p1 = 0, p2 = 0;
        for (p2 = 0; p2 < arr2.length; p2++) {
            if (p1 == arr1.length) {
                return true;
            }
            if (arr1[p1] == arr2[p2]) {
                p1++;
            }
        }

        return p1 == arr1.length;
    }
}
