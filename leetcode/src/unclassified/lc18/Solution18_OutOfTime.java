package unclassified.lc18;

import java.util.*;

public class Solution18_OutOfTime {
    List<List<Integer>> ret;
    int[] arr;
    int target;
    Set<List<Integer>> set;

    // 四数之和，类似java俱乐部洛谷招新题
    // 貌似逻辑上没什么问题，可是超时了
    public List<List<Integer>> fourSum(int[] nums, int target) {
        arr = nums;
        this.target = target;
        ret = new ArrayList<>();
        set = new HashSet<>();
        dfs(new ArrayList<>(), 0, 4);
        // 但是由于nums=[2,2,2,2,2]， target=8这种例子，还是会有重复，所以还要去重
        // 又由于题目中对于重复的定义：如果两个四元组按照同一种排序方式排序之后所有位置数值一一对应，则认为是重复四元组
        // 所以使用Set去重之前还要对列表进行排序，因为Set默认的判断列表是否相等是看对应位置内容
        // 注意与 https://programmercarl.com/0454.%E5%9B%9B%E6%95%B0%E7%9B%B8%E5%8A%A0II.html 此题区别
        // 所以本题和↑这题相比是不适合使用哈希表的

        return ret;
    }

    /**
     * 参考上次的通过递归解决的不定k数之和来解决本题指定4数之和
     *
     * @param sum   当前已经加上了m个数的和（m <= k）
     * @param index 此次开始加的数的索引
     * @param k     还剩k个数才能凑够4个数
     */
    public void dfs(List<Integer> sum, int index, int k) {
        if (k == 0) {
            if (sum.get(0) + sum.get(1) + sum.get(2) + sum.get(3) == target) {
                Collections.sort(sum, (o1, o2) -> {
                    return Integer.compare(o1, o2);
                });
                if (!set.contains(sum)) {
                    ret.add(sum);
                    set.add(sum);
                }
            }
            return;
        }
        for (int i = index; i <= arr.length - k; i++) {
            List<Integer> temp = new ArrayList<>(sum);
            temp.add(arr[i]);
            dfs(temp, i + 1, k - 1);
        }
    }
}
