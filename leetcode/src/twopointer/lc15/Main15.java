package twopointer.lc15;

import java.util.List;

public class Main15 {
    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        List<List<Integer>> resList = solution15.threeSum(
                new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(resList);
    }
}
