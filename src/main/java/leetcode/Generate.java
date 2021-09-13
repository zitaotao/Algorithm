package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 杨辉三角
 * https://leetcode-cn.com/leetbook/read/array-and-string/cuj3m/
 * @author jzt
 * @version 1.0
 * @date 2021/4/21 8:45 下午
 **/
public class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> generate = new ArrayList<>();
        for (int i=1;i<numRows+1;i++){
            int s=-1,f=0;
            if(i==1){
                generate.add(Arrays.asList(1));
                continue;
            }
            List<Integer> jList = new ArrayList<>();
            generate.add(jList);
            for (int j=0;j<i;j++){
                int sEle = s>-1?generate.get(i-2).get(s):0;
                int fEle = f<generate.get(i-2).size()?generate.get(i-2).get(f):0;
                s++;
                f++;
                jList.add(sEle+fEle);
            }
        }
        return generate;
    }

    public List<Integer> getRow(int rowIndex) {
       return generate(rowIndex).get(rowIndex-1);
    }
    public static void main(String[] args) {
        new Generate().generate(5);
    }
}
