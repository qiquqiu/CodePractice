package dp.lc05;

public class Main5 {
    public static void main(String[] args) {
//        Solution5 s5 = new Solution5();
//        String s1 = "badccda";
//        String res = s5.longestPalindrome(s1);
//        System.out.println(res);

        Solution05_dp1 sdp1 = new Solution05_dp1();
        String sdp1ret = sdp1.longestPalindrome("abbba");
        System.out.println(sdp1ret);
    }
}
