package twopointer.lc26;

public class Solution26 {
    // [0,0,1,1,1,2,2,3,3,4] -> [0,1,2,3,4,  0,1,1,2,3]  res = 5
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int slow = 0; // 慢指针，指向"不重复序列"的下一个位置(也就是不重复的数将要去被存放的位置)
        for (int fast = 1; fast < nums.length; fast++) { // 快指针，用于遍历数组
            if (nums[fast] != nums[slow]) { // 如果找到不同的元素
                slow++; // 慢指针向后移动一个
                nums[slow] = nums[fast]; // 将不同元素放到新序列中
            }
        }

        return slow + 1; // 返回新数组的长度
    }
}
