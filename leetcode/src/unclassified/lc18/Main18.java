package unclassified.lc18;

import java.util.List;

public class Main18 {
    public static void main(String[] args) {
        Solution18_OutOfTime s18 = new Solution18_OutOfTime();
        int[] nums = new int[]{-493, -482, -482, -456, -427, -405, -392, -385, -351, -269, -259, -251, -235, -235, -202, -201, -194, -189, -187, -186, -180, -177, -175, -156, -150, -147, -140, -122, -112, -112, -105, -98, -49, -38, -35, -34, -18, 20, 52, 53, 57, 76, 124, 126, 128, 132, 142, 147, 157, 180, 207, 227, 274, 296, 311, 334, 336, 337, 339, 349, 354, 363, 372, 378, 383, 413, 431, 471, 474, 481, 492};
        int target = 6189;
        List<List<Integer>> list = s18.fourSum(nums, target);
        System.out.println(list.toString());
    }
}
