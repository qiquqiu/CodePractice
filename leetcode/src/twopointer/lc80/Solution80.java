package twopointer.lc80;

/**
 * 2025年6月26日 11:34:38，虽然以 O(n) 100% 通过，但是我觉得代码还不够好啊，不过逻辑上来说够通顺
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150
 */
public class Solution80 {

    /**
     * 原地将有序数组nums中的重复项移除，使每个元素最多出现两次，并返回移除后数组的新长度
     * 直接思路：双指针之快慢指针，快指针遍历不停，慢指针指向实际填充位置，最终返回慢指针索引
     * 慢指针要实现的效果：当连续出现>=3次时，慢指针应当指向第三个并且不再随着重复而移动
     * TODO 哈希map应当也能完成，但是不符合题目的规定了
     */
    public int removeDuplicates(int[] arr) {
        // 题有保证，无需判空；repeatCnt：维护实时区间内重复数个数
        int slow = 0, fast, cnt = 1;
        int len = arr.length;
        for (fast = 1; fast < len; fast++) {
            if (arr[fast] == arr[fast - 1]) {
                cnt++;
            } else {
                cnt = Math.min(2, cnt);
                for (int i = 0; i < cnt; i++) {
                    arr[slow++] = arr[fast - cnt + i];
                }
                cnt = 1;
            }
        }
        cnt = Math.min(2, cnt); // 最后可能是超2的也可能是新的，所以依然取一遍最小
        for (int i = 0; i < cnt; i++) {
            arr[slow++] = arr[len - cnt + i];
        }
        return slow;
    }
}
