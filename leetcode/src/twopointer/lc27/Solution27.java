package twopointer.lc27;

public class Solution27 {
    // 暴力解法
    public int removeElement(int[] nums, int val) {
        int count = 0, len = 0;
        // count是计数器，只要每个都被遍历过了就停止
        // len是删除（移动）了的数据个数
        for (int i = 0; i < nums.length; ) {
            count++;
            if (nums[i] == val) {
                toEnd(nums, i);
                len++;
                // 这种情况i不能自增，因为后移会导致
                // 当前元素下一个元素的下标要变为当前的下标
                // 简单说就是导致后一个前移一位，下标又变为当前下标
            } else {
                i++;
            }
            if (count == nums.length) {
                break;
                //但是为了能退出for
            }
        }
        return nums.length - len;
    }

    public void toEnd(int[] arr, int index) {
//        注意这里是由画图得到的循环次数：len - 1 - index
//        小于号(不取等)的for循环，模型: for(i=k;i<l;i++)
//        则循环次数为 l - k
        int len = arr.length;
        int val = arr[index];
        for (int i = index; i < len - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[len - 1] = val;
    }
}

class Solution27_2 {
    // 双指针法1：快慢指针法
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}

class Solution27_3 {
    // 双指针法2：双向指针法
    // 也可以简化代码：省略两次将right置于从右往左数第一个不为val的值的代码
    // 而把left++与前面的几行代码用if-else包括，则当判断nums[left] == val之后
    // left不会++（但是right会--），也就是说下一次还会判断，以防上次交换过来的还是val
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        // 使right指向从右数第一个不为val的值（将要被交换）
        while (right >= 0 && nums[right] == val) {
            right--;
        }
        while (left <= right) {
            if (nums[left] == val) {
                // left索引位置的元素需要移除并新放过来一个从右边
                // 获取到的不为val的值（可以使仅仅的覆盖，也可以使交换，但没必要）
                nums[left] = nums[right]; // 覆盖
                right--;
            }
            left++; // 从左开始遍历无论是否是val，都继续遍历
            // 重新再次操作，使right指向从右数第一个不为val的值
            while (right >= 0 && nums[right] == val) {
                right--;
            }
        }
        // 最终退出while循环的时候，说明已经达到效果了
        // 因为最后一次当left==right的时候说明:right右边已经全部是val
        // 而left左边已经没有val
        return left;
    }
}