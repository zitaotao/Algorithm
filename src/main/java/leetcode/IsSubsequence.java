package leetcode;

/**
 * 判断子序列
 * https://leetcode-cn.com/problems/is-subsequence/
 * 后续思考
 * https://leetcode-cn.com/problems/is-subsequence/solution/dui-hou-xu-tiao-zhan-de-yi-xie-si-kao-ru-he-kuai-s/
 * 扩展：字符串匹配算法
 * @author jzt
 **/
public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        if (s==null||"".equalsIgnoreCase(s)){
            return true;
        }
        if (t==null ||"".equalsIgnoreCase(t)){
            return false;
        }
        int length = 0;
        for (int index = 0;index<t.length();index++){
            if(s.substring(length,length+1).equalsIgnoreCase(t.substring(index,index+1))){
                length++;
            }
            if (length==s.length()){
                return true;
            }
        }
        return length==s.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc","ahbgdc"));

        String[] strings = "git@git.17usoft.com:test_generate_project/demo02.git".split("[:/.]");
        for (String string : strings) {
            System.out.println(string);
        }
    }


    public static  void PreprocessMorrisPratt(String patttern){
        int nextTable[] =new int[patttern.length()+1];
        int i = 0;
        int j = nextTable[0] = -1;
        int size = patttern.length();
        char[] strArray = patttern.toCharArray();
        while(i < size){
            while(j > -1 && strArray[i] != strArray[j]){
                j = nextTable[j];
            }//while
            nextTable[++i] = ++j;
        }//while
        for ( int index =0;index<nextTable.length;index++){
            System.out.println(nextTable[index]);
        }
    }
}
