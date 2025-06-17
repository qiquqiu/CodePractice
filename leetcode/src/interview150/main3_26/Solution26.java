package interview150.main3_26;

public class Solution26 {
    // 优秀题解：https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/comments/2484832/


    // 二刷：半暴力，哈希，还是能达到O(n)的，但是只能击败5%
    public int removeDuplicates(int[] nums) {
        short[] hash = new short[20001];
        int ans = 0, index = 0;
        for (int num : nums) {
            if (hash[num + 10000] == 0) {
                hash[num + 10000]++;
                ans++;
            }
        }

        int flag = 0;
        for (int i = 0; i < hash.length; i++) {
            if (flag == ans) {
                break;
            }
            if (hash[i] != 0) {
                nums[index++] = i - 10000;
                flag++;
            }
        }

        return ans;
    }
}
