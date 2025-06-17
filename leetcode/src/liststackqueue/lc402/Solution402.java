package liststackqueue.lc402;

public class Solution402 {
    // 分析：首先要明白最终的数字的位数是定值，那么只需要从高位向低位遍历
    // 按照“位的高低”和“数的大小”这两个依据，（两个依据要同时兼顾）来删掉k个数即可
    // 按照此逻辑，操作就应该是循环多次从高位到低位找当前串下最大数值
    // 不过这题明明思路已经对的了，还有逆天超时数据；期待O(n)
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        StringBuilder sb = new StringBuilder(num);
        for (int i = 0; i < k; i++) {
            int idx = 0;
            for (int j = 1; j < sb.length() && sb.charAt(j) >= sb.charAt(j - 1); j++) {
                // 这里一定是for而不是if！
                // 例如13681，此次我们要删除的应该是8而非3！！！
                // （可以成为 这类题 的标准）
                // 也就是说如果sb.charAt(j) >= sb.charAt(j - 1)那么删除依据就是“数的大小”
                // 因为无论怎样最终位数一样，若删除高位小值数将导致低位大值数统一前移成高位
                idx = j;
            }
            // 如果idx就等于0，表示首位就是最大数值，同样删除即可
//            sb.delete(idx, idx + 1); while在里面的话这行可以但是下一行不行？
            sb.deleteCharAt(idx);
        }
        // 循环处理首位前导0
        // 最后处理一次就够了，反正前导0不会影响后续删除数
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.delete(0, 1);
        }
        return sb.toString().isEmpty() ? "0" : sb.toString();
    }
}
