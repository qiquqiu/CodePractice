package liststackqueue.lc71;

import java.util.Stack;

public class Solution71 {
    // 总结：
    // 1.头部和尾部的“/”：
    // 头部的“/”总是存在的，所以拆入栈的时候索性跳过它开始
    // 尾部的“/”原题有无都无所谓，题意说不能以“/”结尾，所以说不需要考虑后续加还是不加
    // 2.split(str)方法：
    // 如果首尾有分割符的话，首尾的处理并不会相同！
    // 详情参考：https://yiyan.baidu.com/share/n0x1npSeZG
    public String simplifyPath(String path) {
        Stack<String> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int len = path.length();
        // 1.先做恶心的重字符化一处理
        for (int i = 0; i < len - 1; i++) {
            if (path.charAt(i) == '/') {
                if (path.charAt(i + 1) != '/') {
                    sb.append(path.charAt(i));
                }
            } else {
                sb.append(path.charAt(i));
            }
        }
        sb.append(path.charAt(len - 1));

        // 2.开始遍历，并实现不同符号的逻辑
        String[] arr = sb.toString().split("/");
        if (arr.length == 0) {
            return "/";
        }
        int begin = arr[0].equals("") ? 1 : 0;
        for (int i = begin; i < arr.length; i++) {
            if (arr[i].equals(".")) {
                // 无其他操作，当前就是路径末尾（栈顶）
            } else if (arr[i].equals("..")) {
                if (!stk.isEmpty()) {
                    stk.pop();
                }
            } else {
                stk.push(arr[i]);
            }
        }
        StringBuilder ret = new StringBuilder();
        if (stk.isEmpty()) {
            return "/";
        }
        for (String s : stk) {
            ret.append("/");
            ret.append(s);
        }
        return ret.toString();
    }
}