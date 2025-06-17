package hashtable.lc202;

public class Solution202_2 {
    // 双指针-快慢指针法
    // 此方法有点类似于“寻找循环链表开始入环的地方”
    // 主要的特征就是在while操作中，慢指针一次走一个单位，而快指针一次走两个单位
    // 最终如果客观上是一个环形结构，那么 快指针最终会追上慢指针；此可作为退出条件
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && slow != fast) {
            // 太秒了，0ms
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        // 若不是快乐数，那么必有闭环结构，fast一定追上slow，一定能退出while循环
        // 若是快乐数字，那么最终在某次会出现getNext(...)的结果为1，而且必定是 fast '先'到1
        // 实际上fast到1之后，fast就不会变了，也可以以slow作为判断标准
        return fast == 1;
    }

    public int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}
