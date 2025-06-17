package twopointer.lc844;

public class Solution844 {
    // 1.使用栈实现
    // 就算直到了使用栈实现，也要注意如何来使用
    // 实现的方式并不是将所有字符压栈再逆序依次取，这其实与逆序无关
    // 事实上，先把字符串逆序可能还会出现更多的麻烦：例如abcs#kt###
    // 但是逆序的话使用双指针的思路更加的简单，也是可以实现的
    // 只需要按照正常的打字顺序，遇见非#就压栈，遇见#就弹栈即可
    public boolean backspaceCompare(String s, String t) {
        return dealBackspace(s).equals(dealBackspace(t));
    }

    public String dealBackspace(String s) {
        // 注意这里使用StringBuilder来模拟栈
        // 一方面可以不用真正创建栈这个结构，不用导包
        // 另一方面，我们后序需要进行一些栈并不利于我们进行的操作
        // 例如我们之后还要按照从栈底到栈顶的顺序获取到结果的字符串
        // 而用栈我们还要逆序一遍，又因为最后要获取的是字符串，所以
        // 也没有用ArrayList来实现
        // 使用StringBuilder实现栈在与操作字符串、栈有关的题很好用

        // 这里必须自定义长度
        StringBuilder sb = new StringBuilder(s.length());
        int last = -1; // 指向当前栈顶的指针
        for (char c : s.toCharArray()) {
            if (c != '#') {
                sb.append(c);
                last++;
            } else {
                // 这里通过指针访问栈顶，而不是通过sb.length() - 1来访问
                // 通过后一种方式当然也可以！
                if (last > -1) {
                    // 最多如果已经删完了就不让再删了
                    sb.deleteCharAt(last--);
                }
            }
        }
        return sb.toString();
    }
}