package interview150.main3_26;

public class Solution26_3 {
    // 经典妙解，双指针之快慢指针
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast;
        for (fast = 1; fast < nums.length; fast++) {
            // 让快指针遍历，遇到与前一个值相等的跳过，直到遇到分界线（新‘唯一元素’出现）再让slow更新
            // 并且快指针遍历的对比对象就是与最新更新的nums[slow]
            if (nums[fast] != nums[slow]) {
                // 必须是++slow，nums[0]无论如何存的原始值都认为是该元素的代表元素
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1; // 加上第一个
    }
}
