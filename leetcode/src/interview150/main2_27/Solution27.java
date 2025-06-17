package interview150.main2_27;

import java.util.Arrays;

public class Solution27 {
    // 二刷：先暴力（已经可以100%）
    public int removeElement(int[] nums, int val) {
        // 原地删除nums中的val，并且将其他非val的提到前面
        // 可能有多种思路，但是由于是原地“移除”，所以并不会有极其简单的思路
        int ans = 0, loop = 0, len = nums.length;
        for (int i = 0; i < len; loop++) {
            if (loop > len) {
               // 循环次数绝对是小于len的
               break;
            }
            if (nums[i] == val) {
                // 移动一个完毕之后，先不能下一个，可能当前位置又成了val
                moveToEnd(nums, i);
            } else {
                i++;
            }
        }
        for (int num : nums) {
            if (num != val) {
                ans++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return ans;
    }

    /**
     * 将index索引出的元素移动到数组末尾，同时让前面的数均所有前移一个单位
     */
    private void moveToEnd(int[] arr, int index) {
        int len = arr.length;
        if (index == len - 1) {
            return;
        }
        // 先保存
        int theMoveVal = arr[index];

        // 将[index+1, len-1]区间的所有值向前移动一个单位，遍历次数 len-1-index
        for (int i = index; i < len - 1; i++) {
            arr[i] = arr[i + 1];
        }

        // 将theMoveVal插入到arr[len-1]
        arr[len - 1] = theMoveVal;
    }
}
