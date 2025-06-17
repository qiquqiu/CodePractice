package twopointer.lc15;

import java.util.*;

public class Solution15_2 {
    public static void main(String[] args) {
        Solution15_2_hash solution15_2_hash = new Solution15_2_hash();
        List<List<Integer>> list = solution15_2_hash.threeSum(new int[]{-2, 0, 1, 1, 2});
        System.out.println(list);
    }
}

class Solution15_2_hash {
    //         -1, 0, 1, 2, -1 排序-> -1, -1, 0, 1, 2
    //         [-1, 0, 1] 与 [0, 1, -1]的去重
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 如果第一个元素大于零，不可能凑成三元组
            if (nums[i] > 0) {
                return result;
            }
            // 三元组元素a去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 之所以满足就continue的原因是：以-1, -1, 0, 1, 2为例
                // 第一次a是第一个-1的时候，会产生[-1, 0, 1]和[-1, -1, 2]两个结果集
                // 第二次如果a还是紧接着与上一个相同，那么即便此a还能够组成结果集，
                // 其组成的结果集也必定都是上一个a所组成过的（子集关系），所以无需重复
                // 不用担心第一次a与第二个重复的a能够产生组成结果集的关系而导致第二个a出现问题
                // 因为我们为a组成结果集总是朝后看的，即便第一个a在组成结果集的时用上了第二个a
                // 那么第二次a顶多也就是少这一种情况，但是无论如何，它所能组成的所有结果集必定是之前
                // 已经组成过的子集；如第二次就只能组成（假设没有此处if-continue语法）：{[-1, 0, 1]}
                // 显然是{[-1, 0, 1], [-1, -1, 2]}的子集
                continue;
            }

            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                // 三元组元素b去重
                if (j > i + 2 && nums[j] == nums[j - 1] && nums[j - 1] == nums[j - 2]) {
                    // 用例： -3, 1, 1, 1, 1, 7, 8

                    // 这里我对“nums[j] == nums[j - 1] && nums[j - 1] == nums[j - 2]”
                    // 的理解是；因为num[j]是代表（内层循环）当前元素，即b，如果出现了三次即...b b b(当前)
                    // 那么先跳转一下：
                    // 【如果出现了两个b，即...b b(当前)，则此时不能直接continue，因为第一个b被加入set了，
                    // 完全有可能第一个b是c，从而满足a+b+b=0】
                    // 接上面的解释：而如果出现了三次即...b b b(当前)，那么当前的b完全就可以跳过了，两次之后的
                    // 就已经没有任何作用了，要是是两次，还有可能一个作为c，一个作为当前b

                    // 至于为0，0，0的特殊情况则完全无需担心，因为必有a=0（外层循环），c=0，b=0
                    continue;
                }

                int c = -nums[i] - nums[j];
                if (set.contains(c)) {
                    result.add(Arrays.asList(nums[i], nums[j], c));
                    set.remove(c); // 三元组元素c去重
                    // 一旦检索到了一个三元组，就把三元组中所有内容移除哈希表（实际上这里的“所有内容”就是指c）
                    // 如果不移除c，下一个还是num[j]的话，就由c导致了重复情况
                } else {
                    set.add(nums[j]);
                }
            }
        }
        return result;
    }
}
