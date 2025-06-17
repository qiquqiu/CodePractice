package twopointer.lc26;

public class Main26 {
    // 已知数组为已升序排好序的数组
    // [0,0,1,1,1,2,2,3,3,4] -> [0,1,2,3,4,  0,1,1,2,3]  res = 5
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        Solution26 s26 = new Solution26();
        int res = s26.removeDuplicates(nums);
        System.out.println(res);
    }
}
