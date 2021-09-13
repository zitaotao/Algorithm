package leetcode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/group-anagrams/
 * 字母异位词分组
 *
 * @Date 2020-12-14 12:45
 * @Version 1.0
 **/
public class GroupAnagrams {
    public static  List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> groupAnagramsMap = new HashMap<>();
        for (String str : strs) {
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            if (!groupAnagramsMap.containsKey(Arrays.toString(strArray))){
                groupAnagramsMap.put(Arrays.toString(strArray),new ArrayList<>());
            }
            groupAnagramsMap.get(Arrays.toString(strArray)).add(str);
        }
        return new ArrayList<>(groupAnagramsMap.values());
    }

    public static void main(String[] args) {
        groupAnagrams(new String[]{
                "eat", "tea", "tan", "ate", "nat", "bat"
        });
    }
}
