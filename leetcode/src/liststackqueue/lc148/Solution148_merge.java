package liststackqueue.lc148;

import liststackqueue.lc23.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution148_merge {
    // 若要使用插入排序思路的话就是lc147的源代码，但是O(n^2)会超时
    // 根据题目提示，要寻找一个O(nlogn)的排序：归并？快排？
    // 如果是这样的话那么其实本题可认为就是考察排序了,权当温习归并排序吧！

    // 排序部分使用的是手撕的归并排序，整个代码时间复杂度确实是O(nlogn)了
    // 不过有较多O(n)的板块，所以超过用户不多
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        mergeSort(list, 0, list.size() - 1, new ArrayList<>(list.size()));
        for (int i = 0; i < list.size() - 1; i++) { // 这里细节-1
            list.get(i).next = list.get(i + 1);
        }
        list.getLast().next = null;
        return list.getFirst();
    }

    public void mergeSort(List<ListNode> list, int left, int right, List<ListNode> temple) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(list, left, mid, temple);
            mergeSort(list, mid + 1, right, temple);
            merge(list, left, mid, right, temple);
        }
    }

    // 对list列表中从left到right（闭区间）之间进行排序
    public void merge(List<ListNode> list, int left, int mid, int right, List<ListNode> temple) {
        // 由于是列表不是数组（下面用的是add不是set，即不会覆盖！），所以每次使用前要先置空
        temple.clear();
        int i = left; // 左序列起始索引
        int j = mid + 1; // 右序列起始索引
        // 交错比较；第一次错误地方：为temple列表添加元素用add，不要用set，因为尚未实际分配容量！！！
        while (i <= mid && j <= right) {
            boolean r = list.get(i).val < list.get(j).val ? temple.add(list.get(i++)) : temple.add(list.get(j++));
        }
        // 处理尾巴情况
        if (i > mid) {
            while (j <= right) {
                temple.add(list.get(j++));
            }
        } else {
            while (i <= mid) {
                temple.add(list.get(i++));
            }
        }
        // 复制排好序的到原数组位置
        for (int k = 0; k < right - left + 1; k++) {
            list.set(left + k, temple.get(k));
        }
    }
}
