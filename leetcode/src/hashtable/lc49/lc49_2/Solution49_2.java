package hashtable.lc49.lc49_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution49_2 {
    // 方法二： 哈希法
    // 类似于方法一的思路，只不过此时组内的标志不是排序所得的母字符串
    // 而是将放于同组的字符串按照出现次数取得的count数组的哈希值
    public List<List<String>> groupAnagrams(String[] strs) {
        // 用来存结果的map，键就是每组的哈希值（即特征数组的哈希值，每组只有一个特征数组）
        Map<Integer, ArrayList<String>> map = new HashMap<>();
        // 遍历字符串数组
        for (String s : strs) {
            // 获取字符串s的“特征数组”的哈希值，作为key
            int key = getHash(s);
            // 如果当前key已经存在，那么就不需要新开辟键值对了
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            // 然后将当前字符串s放入对应的组中
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    // 获取字符串的哈希值（对于此题来说，实际上是获取字符串s的“特征数组”的哈希值）
    public int getHash(String s) {
        char[] charArray = s.toCharArray();
        int[] cnt = new int[26]; // 由题目只有小写字母
        for (char c : charArray) {
            cnt[c - 97]++;
        }
        // 根据当前的特征数组返回一个与当前特征数组唯一对应的哈希值
        int hash = 0;
        for (int val : cnt) {
            // 够大则一定程度可以避免哈希冲突
            hash = hash * 101 + val; // 额哈希真秒
        }
        return hash;
    }
}
