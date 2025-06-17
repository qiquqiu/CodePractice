package dp.lc139;

import java.util.Arrays;
import java.util.List;

public class Main139 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("aaaa", "aaa");
        String str = "aaaaaaa";
//        Solution139_failed s = new Solution139_failed();
//        boolean ret = s.wordBreak(str, list);
//        System.out.println(ret);

        Solution139_dp sdp = new Solution139_dp();
        boolean ret2 = sdp.wordBreak(str, list);
        System.out.println(ret2);
    }
}
