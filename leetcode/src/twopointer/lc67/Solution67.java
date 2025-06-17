package twopointer.lc67;

public class Solution67 {
    // 由题意里面a，b的长度知，显然只能按位进位算，否则int或long均溢出
    // 1000 1010 + 1011 = 1001 0101
    // 1010 + 1011 = 1 0101

    //   1 0 1 1
    //  +1 0 1 1
    //  ————————
    // 1 0 1 1 0
    public String addBinary(String a, String b) {
        // 如果长短不一，就把短的以0补为长度一样（可以补，也可以截取，这里采用补）
        int len1 = a.length(), len2 = b.length();
        StringBuilder sb = new StringBuilder();

        if (len1 != len2) {
            int maxLen = Math.max(len1, len2);
            String longer = len1 > len2 ? a : b;
            String shorter = len1 > len2 ? b : a;

            for (int i = 0; i < maxLen - shorter.length(); i++) {
                sb.append(0);
            }
            sb.append(shorter); // else里面不用重置sb

            // 简单一层递归
            return addBinary(longer, sb.toString());
        } else {
            char[] charA = a.toCharArray();
            char[] charB = b.toCharArray();
            int nextPlus = 0; // 下一位是否进位的标志

            for (int i = len1 - 1; i >= 0; i--) {
                int sum = (charA[i] - '0') + (charB[i] - '0') + nextPlus;

                // 进位和不进位一共就三种情况
                if (sum == 2) {
                    sb.append(0);
                    nextPlus = 1;
                } else if (sum == 3) {
                    sb.append(1);
                    nextPlus = 1;
                } else {
                    // 不用向下一位进位
                    sb.append(sum);
                    nextPlus = 0;
                }
            }
            if (nextPlus == 1) {
                sb.append(1);
            }
        }
        return sb.reverse().toString();
    }
}
