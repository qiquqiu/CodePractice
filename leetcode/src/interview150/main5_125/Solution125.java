package interview150.main5_125;

public class Solution125 {
    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int slow = 0;
        // 遍历一遍，移除所有不是字母的字符，其他字符相对顺序保留
        for (int i = 0; i < arr.length; i++) {
            if (Character.isLetter(arr[i]) || Character.isDigit(arr[i])) {
                // 此处去除无关字符使用了前几题中频繁出现的快慢指针思路
                arr[slow++] = Character.toLowerCase(arr[i]);
            }
        }
        // 再来遍历一遍slow长度，校验即可
        int l = 0, r = slow - 1;
        while (l <= r) {
            if (arr[l++] != arr[r--]) {
                return false;
            }
        }
        return true;
    }
}
