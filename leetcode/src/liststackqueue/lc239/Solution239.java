package liststackqueue.lc239;

public class Solution239 {
    // 分析：如果使用暴力解法的话，显然时间复杂度为O((n-k)*k) = O(nk)
    // 即便再次基础上优化，还是无法解决时间复杂度为O(nk)的问题
    // 额考察‘单调队列’ 时间复杂度O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        MyDeque deque = new MyDeque();
        int left = 0, right = k, len = nums.length, t = 0;
        int[] res = new int[len - k + 1];

        for (int i = 0; i < k; i++) {
            deque.add(nums[i]);
        }

        while (right <= len) {
            if (nums[left] == deque.peekFirst()) {
                res[t++] = deque.poll();
            } else {
                res[t++] = deque.peekFirst();
            }
            if (right == len) {
                break;
            }
            deque.add(nums[right++]);
            left++;
        }

        return res;
    }
}
