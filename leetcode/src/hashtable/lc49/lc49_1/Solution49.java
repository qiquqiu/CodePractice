package hashtable.lc49.lc49_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution49 {
    // 这里实际上就是方法二：哈希法
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        // key:字符串特征值 value:对应列表数组的索引
        Map<Integer, Integer> indexTable = new HashMap<>();
        for (String str : strs) {
            // 计算该字符串的特征值
            int pattern = getPattern(str);
            // 如果对应特征值已存在
            if (indexTable.containsKey(pattern)) {
                // 获取对应索引,并添加至对应list
                result.get(indexTable.get(pattern)).add(str);
            } else {
                // 否则将其添加至末尾
                List<String> temp = new ArrayList<>();
                temp.add(str);
                result.add(temp);
                // 并保存特征值和list索引的对应关系
                indexTable.put(pattern, result.size() - 1);
            }
        }
        return result;
    }

    private int getPattern(String str) {
        int[] pattern = new int[26];
        int hash = 0;
        for (char c : str.toCharArray()) {
            pattern[c - 'a']++;
        }
        /*
         计算str特征数组的hash值并返回
         如果想更快的话，可以直接返回Arrays.toString(pattern)
         */
        for (int i = 0; i < 26; i++) {
            // 避免哈希冲突
            hash = hash * 31 + pattern[i];
        }
        return hash;
    }
}
