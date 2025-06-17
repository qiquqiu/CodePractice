package dp.lc139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution139_failed {
    Set<String> set;

    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        return check(s);
    }

    public boolean check(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        int n = str.length();
        boolean curExist = false;
        int i;
        if (set.contains(str)) {
            return true;
        }
        for (i = 0; i < n; i++) {
            if (set.contains(str.substring(0, i + 1))) {
                curExist = true;
                break;
            }
        }
        if (curExist) {
            return check(str.substring(i + 1));
        }
        return false;
    }
}
