package liststackqueue.lc402;

public class Main402 {
    public static void main(String[] args) {
        Solution402 s402 = new Solution402();
        // 删除之后的答案含有前导0的例题仍然适用Line23前的算法
        String str = s402.removeKdigits("10001", 4);
        System.out.println(str);
    }
}
