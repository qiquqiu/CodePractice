package hashtable.lc01;

import java.util.Arrays;

public class Main01 {
    public static void main(String[] args) {
        Solution01 solution01 = new Solution01();
        int[] arr = {2, 7, 1, 5};
        int[] res = solution01.twoSum(arr, 6);
        System.out.println(Arrays.toString(res));
    }
}
