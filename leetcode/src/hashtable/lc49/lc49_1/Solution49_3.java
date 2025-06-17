package hashtable.lc49.lc49_1;

import java.util.*;

public class Solution49_3 {
    // 这里实际上就是方法一：排序法
    public List<List<String>> groupAnagrams(String[] strs) {
        // HashMap和ArrayList应用题，排序+哈希表
        // map<单词排序后的key, 同一key的的单词集合>，遍历一次strs即可，
        // 不过每个单词仍不可避免要遍历每个字符，  O(n*maxlen*logmaxlen)
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 将每个单词转化为字符数组，排序后得到该单词的key
            char[] chr = str.toCharArray();
            Arrays.sort(chr);
            String key = new String(chr);
            // map的key对应value存储key相同的原始单词列表list，取出list，
            // 若没有当前单词的key则创建空list
            List<String> list = map.getOrDefault(key, new ArrayList());
            // 将当前单词加入list，并将key和更新后的list压入map
            list.add(str);
            map.put(key, list);
        }
        // 遍历完成后，map中已经存储了所有单词，获取map中所有value的list集合
        // （相当于按key分好list组），构建List<list>
        return new ArrayList<>(map.values());
    }
}
