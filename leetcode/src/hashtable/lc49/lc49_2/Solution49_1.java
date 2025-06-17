package hashtable.lc49.lc49_2;

import java.util.*;

public class Solution49_1 {
    // 方法一：排序法
    public List<List<String>> groupAnagrams(String[] strs) {
        // 用来存放最终结果的哈希表
        // 其中key是同一组异位字符的sort的结果，即判断的母字符串标准
        // value是每一组异位字符的列表
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String s : strs) {
            // 获取当前字符串的排序结果，将之作为map的key值（如果该组的key值尚未被添加）
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (! map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            // 之后将当前字符串s添加到其对应的组内（根据母字符串作为key判断）
            // map.get(i) 即取出键为key的值，这里取出的结果是一个列表：ArrayList<String>
            map.get(key).add(s);
        }
        // 再将所有的值（ArrayList列表）添加成一个大列表返回
        return new ArrayList<>(map.values());
    }
}
