package twopointer.lc904;

public class Solution904 {
    // 滑动窗口练习：这题与上一个滑动窗口思想类似
    // 不过对于窗口内的元素的操作改变了，不是求和了
    // 而是求内部的元素的种类的个数
    // 下面是初稿，可以用，但是会超时，主要的思路没有问题
    // 就是哈希表如果生硬的用一个方法，内部套循环来实现的话太慢了
    // 所以我们直接在对窗口操作的同时处理哈希表！
    public int totalFruit(int[] fruits) {
        int left = 0, right = 0, subLen = 0, type = 0, res = 0;
        int[] hash = new int[fruits.length];
        while (right < fruits.length) {
            hash[fruits[right]]++;
            if (hash[fruits[right]] == 1) {
                type++;
            }
            while (type > 2) {
                if (hash[fruits[left]] == 1) {
                    type--;
                }
                hash[fruits[left]]--;
                left++;
            }
            subLen = right - left + 1;
            res = Math.max(res, subLen);
            right++;
        }
        return res;
    }

    public int getType(int[] arr, int beginIndex, int endIndex) {
        if (beginIndex == endIndex) {
            return 1;
        }
        int[] hash = new int[arr.length];
        for (int i = beginIndex; i <= endIndex; i++) {
            hash[arr[i]]++;
        }
        int count = 0;
        for (int i : hash) {
            if (i != 0) {
                count++;
            }
        }
        return count;
    }
}
