package hashtable.lc128;

public class Solution128_method1 {
    // 初步考虑可以使用类似桶排序的思路
    // 额实际上也不能算是O(n)的时间复杂度，严格说应该是O(max-min)的时间复杂度...
    // 并且重复的也认为是连续的，所以说重复的这点也没有考虑上

    // 大部分可以是可以，但是在案例：
    // 0,1,2,4,8,5,6,7,9,3,55,88,77,99,999999999 的时候超出了内存限制...
    public int longestConsecutive(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int min = getMin(arr);
        int max = getMax(arr);
        int[] bucket = new int[max - min + 1];

        // 初始化桶
        for (int i = 0; i < bucket.length; i++) {
            // 初始化为一个不影响连续的值
            bucket[i] = max + 1;
        }

        // 将源数据存入桶中，（索引）容量是可以保证最高需求的
        for (int val : arr) {
            bucket[val - min] = val;
        }
        int res = 0, cnt = 1;
        // 遍历桶
        for (int i = 0; i < bucket.length; i++) {
            if (i + 1 < bucket.length && bucket[i] + 1 == bucket[i + 1]) {
                cnt++;
            } else {
                res = Math.max(res, cnt);
                cnt = 1;
            }
        }
        return res;
    }

    // O(n)
    public int getMax(int[] arr) {
        int maxVal = arr[0];
        for (int val : arr) {
            if (val > maxVal) {
                maxVal = val;
            }
        }
        return maxVal;
    }

    // O(n)
    public int getMin(int[] arr) {
        int minVal = arr[0];
        for (int val : arr) {
            if (val < minVal) {
                minVal = val;
            }
        }
        return minVal;
    }
}