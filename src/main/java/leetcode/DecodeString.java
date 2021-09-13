package leetcode;

import java.util.LinkedList;

/**
 * 请描述类的业务用途
 *
 * @author jzt
 * @version 1.0
 * @date 2021/7/19 5:43 下午
 **/
public class DecodeString {
    /**
     *给定一个经过编码的字符串，返回它解码后的字符串。
     *
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     *
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     *
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像3a或2[4]的输入。
     * 输入：s = "3[a]2[bc]"
     * 输出："aaabcbc"
     * 输入：s = "3[a2[c]]"
     * 输出："accaccacc"
     * 输入：s = "2[abc]3[cd]ef"
     * 输出："abcabccdcdcdef"
     * 输入：s = "abc3[cd]xyz"
     * 输出："abccdcdcdxyz"
     **/
    public String decodeString(String s) {
        return help(s);
    }

    public String help(String s){
        if (s==null||s==""){
            return "";
        }
        LinkedList<String> sta = new LinkedList<>();
        int len = s.length();
        int e = 0;
        int xCount = 0;
        while (e<len){
            char ele = s.charAt(e);
            if (Character.isDigit(ele)){
                // 获取一个数字并进栈
                String digits = helpDigits(s,e);
                sta.addLast(digits);
                e+=digits.length()-1;
            }else if (ele=='['){
                sta.addLast(String.valueOf(ele));
                xCount++;
            }else if (Character.isLetter(ele)){
                sta.addLast(String.valueOf(ele));
            }else {
                //出
                StringBuilder temp = new StringBuilder();
                String last = "";
                while (!"[".equals(last = sta.removeLast())){
                    temp.append(last);
                }
                xCount--;
                int num = Integer.parseInt(sta.removeLast());
                last = temp.toString();
                for (int i=1;i<num;i++){
                    temp.append(last);
                }
                if (xCount==0){
                    sta.addLast(temp.reverse().toString());
                }
                else {
                    sta.addLast(temp.toString());
                }

            }
            e++;
        }
        return getString(sta);
    }

    public String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }


    public String helpDigits(String s,int i){
        StringBuilder eles = new StringBuilder();
        while (Character.isDigit(s.charAt(i))){
            eles.append(s.charAt(i));
            i++;
        }
        return eles.toString();
    }

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("100[leetcode]"));
    }


}
