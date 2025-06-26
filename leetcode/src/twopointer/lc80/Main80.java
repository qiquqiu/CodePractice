package twopointer.lc80;

public class Main80 {
    public static void main(String[] args) {
        Solution80 s = new Solution80();
        int[] arr = new int[]{1, 1, 1, 2, 2, 2, 3};
        int totalCnt = s.removeDuplicates(arr);
        System.out.println("totalCnt = " + totalCnt);
        // 题目会根据方法返回值，输出原arr对应长度的结果
        for (int i = 0; i < totalCnt; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
