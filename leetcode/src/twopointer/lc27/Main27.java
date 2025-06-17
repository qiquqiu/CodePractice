package twopointer.lc27;

import java.util.Arrays;

public class Main27 {
    public static void main(String[] args) {
        Solution27 s27 = new Solution27();
        int[] arr = {0, 1, 2, 2, 3, 0, 4, 2};
//        s27.toEnd(arr,1);
//        System.out.println(Arrays.toString(arr));
//        s27.toEnd(arr,0);
//        System.out.println(Arrays.toString(arr));
        int ret = s27.removeElement(arr, 2);
        System.out.println(ret);
        System.out.println(Arrays.toString(arr));
    }
}
