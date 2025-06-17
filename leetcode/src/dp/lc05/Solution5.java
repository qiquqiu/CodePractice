package dp.lc05;

class Solution5 {
    // 最长回文子串 s = "babad"  ->  "bab"
    // 本算法时间复杂度太高了，为 O(n^3)
    public String longestPalindrome(String s) {
        String res = String.valueOf(s.charAt(0));
        int n = s.length();
        for (int left = 0; left < n - 1; left++) {
            for (int right = n - 1; right > left; right--) {
                if (isPalindrome(s.substring(left, right + 1))) {
                    res = res.length() < s.substring(left, right + 1).length()
                            ? s.substring(left, right + 1) : res;
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String s) {
        // 默认传入的s为非null
        if (s.length() == 1) {
            return true;
        }
        char[] strs = s.toCharArray();
        int left = 0;
        int right = strs.length - 1;
        while (left < right) {
            if (strs[left++] != strs[right--]) {
                return false;
            }
        }
        return true;
    }
}