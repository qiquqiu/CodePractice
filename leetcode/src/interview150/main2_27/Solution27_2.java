package interview150.main2_27;

public class Solution27_2 {
    // 双指针法，尤其是快慢指针，最妙
    // leetcode/twopointer/lc27/Solution27.java
    public int removeElement(int[] nums, int val) {
        int slow = 0, fast; // slow用于记录前部数据，fast用于遍历与判断
        for (fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                // 遍历到的不为val，则让其前移（覆盖）到slow的位置
                // 若遍历的等于val，则slow指针不做处理，因为slow指针仅维护非val值
                nums[slow++] = nums[fast];
            }
        }
        // {0,1,2,2,3,0,4,2}  val=2
        return slow;
    }
}

/*
    这类题都是极度典型的'基本情况（题型）'，逻辑总能够恰好自洽
    比如该题，等于val时候移动的位置（废位置），恰给后面不等于val时的覆盖slow位置做铺垫
    而覆盖之后又使得当前位置可以接连连续上前面的的废弃位置为后面的继续做铺垫...
 */
