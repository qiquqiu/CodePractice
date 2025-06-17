package twopointer.lc15;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 说明：理论上是没有问题的，但是超时了，主要就是因为最后还需要一遍去重，或者说去重逻辑可以边实现边去重...
// 所以说整体用哈希法还是比较困难的，时间复杂度是 O(n^2)
public class Solution15 {
//    输入：nums =[5, 1, -2, -1, -3, 6]
//    输出：[[5, -2, -3]]
//    输入：-1, 0, 1, 2, -1, -4... / -2, 0, 1, 1, 2

    // 初步思路是先遍历数组，依次遍历a=nums[i]，然后再在‘尚未遍历’的部分
    // 找到两数b+c之和为-a，由于最后要返回的是由数组的值组成的元组，而且不能够重复
    // 所以说如果有多个b多个c能够抽成b+c=-a，我们也只取之为一种情况：(a, b, c)
    // 所以到后面找两数之和大致可以借鉴lc01的思路
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            deal(-nums[i], i + 1, nums, list, set);
        }
        return ListDeduplicationUtil.deduplicateLists(list);
//        return list;
    }

    /**
     * 进行核心操作：判断当遍历到当前num时候，在‘尚未遍历’的部分中，是否有两数之和
     * 能够等于-num，若有，则将三数均添加进入列表，并将列表添加进入结果列表
     *
     * @param target 当前正遍历到的数的'相反数'
     * @param index  ‘尚未遍历’部分的起始位置的索引
     * @param nums   源数组
     * @param list   结果列表
     * @param set    哈希表工具，防止重复创建，故设置为参数
     */
    public void deal(int target, int index, int[] nums, List<List<Integer>> list, Set<Integer> set) {
        set.clear();
        while (index < nums.length) {
            if (!set.contains(target - nums[index])) {
                set.add(nums[index]);
            } else {
                //    -1, 0, 1, 2, -1, -4，现在的问题是去重
                ArrayList<Integer> itemList = new ArrayList<>();
                itemList.add(-target);
                itemList.add(target - nums[index]);
                itemList.add(nums[index]);
                list.add(itemList);
            }
            index++;
        }
    }
}

class ListDeduplicationUtil {
    // 去重工具类 @author 文心一言

    /**
     * 去重一个List<List<Integer>>，只考虑子列表的内容而不考虑顺序
     *
     * @param lists 要去重的列表
     * @return 去重后的列表
     */
    public static List<List<Integer>> deduplicateLists(List<List<Integer>> lists) {
        Set<Set<Integer>> uniqueSets = new HashSet<>();
        List<List<Integer>> deduplicatedLists = new ArrayList<>();

        for (List<Integer> list : lists) {
            Set<Integer> setRepresentation = new HashSet<>(list);
            if (!uniqueSets.contains(setRepresentation)) {
                uniqueSets.add(setRepresentation);
                deduplicatedLists.add(list); // 保留原始列表的引用
            }
        }

        return deduplicatedLists;
    }
}
