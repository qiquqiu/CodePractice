package hashtable.lc128;

public class Main128 {
    public static void main(String[] args) {
        // 出问题的案例
        // 经过调试，发现问题原因确实很逆天，因为可以负数，所以说桶初始全部为0是不行的！
        int[] nums = {9, 1, -3, 2, 4, 8, 3, -1, 6, -2, -4, 7};
//        int[] nums = {0, 1, 2, 4, 8, 5, 6, 7, 9, 3, 55, 88, 77, 99, 999999999};
        Solution128_method1 solution128Method1 = new Solution128_method1();
        int i = solution128Method1.longestConsecutive(nums);
        System.out.println("结果： " + i);
    }
}
