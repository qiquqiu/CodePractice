package unclassified.lc09;

public class HuiWenNum01 {
    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(121));
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        char[] s1 = str.toCharArray();
        char[] s2 = new char[s1.length];
        for (int i = s1.length - 1; i >= 0; i--) {
            s2[s1.length - 1 - i] = s1[i];
        }
        String strRet = new String(s2);
        System.out.println(strRet);
        return str.equals(strRet);
    }
}