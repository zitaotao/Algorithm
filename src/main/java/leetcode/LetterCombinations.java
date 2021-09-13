package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * @author jzt
 * @version 1.0
 * @date 2021/5/23 12:38 下午
 **/
public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
        if (digits==null||digits.length()==0){
            return new ArrayList<>();
        }

        List<List<String>> numberWords = init();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            Integer ele = Integer.valueOf(digits.charAt(i)+"")-1;
            res = help(res,numberWords.get(ele));
        }
        return res;
    }

    public List<String> help(List<String> a,List<String> b){
        if (a.isEmpty()){
            return b;
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < b.size(); j++) {
                res.add(a.get(i)+b.get(j));
            }
        }
        return res;
    }
    public List<List<String>> init() {
        List<List<String>> numberWords = new ArrayList<>();
        numberWords.add(Arrays.asList("","",""));
        numberWords.add(Arrays.asList("a","b","c"));
        numberWords.add(Arrays.asList("d","e","f"));
        numberWords.add(Arrays.asList("g","h","i"));
        numberWords.add(Arrays.asList("j","k","l"));
        numberWords.add(Arrays.asList("m","n","o"));
        numberWords.add(Arrays.asList("p","q","r","s"));
        numberWords.add(Arrays.asList("t","u","v"));
        numberWords.add(Arrays.asList("w","x","y","z"));
        return numberWords;
    }
}
