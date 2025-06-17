package dp.lc120;

import java.util.Arrays;
import java.util.List;

public class Main120 {
    public static void main(String[] args) {
        Solution120 s = new Solution120();
        List<List<Integer>> list = Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3));
        int ret = s.minimumTotal(list);
        System.out.println(ret);
    }
}
