package leetcode;

/**
 * 反转字符串
 * https://leetcode-cn.com/leetbook/read/array-and-string/cacxi/
 * @author jzt
 * @version 1.0
 * @date 2021/4/18 3:07 下午
 **/
public class ReverseString {

    public void reverseString(char[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int herd = 0;
        int tail = nums.length - 1;
        while (herd < tail) {
            //获取尾部下标数据
            char str = nums[tail];
            //尾部数据 = 头步数据
            nums[tail] = nums[herd];
            //头部数据 = 尾部数据
            nums[herd] = str;
            herd ++;
            tail --;
        }
    }
}
