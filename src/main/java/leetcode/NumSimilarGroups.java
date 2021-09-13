package leetcode;

/**
 * 相似字符串组
 *
 * @author jzt
 * @version 1.0
 * @date 2021-01-31 15:53
 **/
public class NumSimilarGroups {
    int [] parent;
    /**
     * 寻找相似字符串组
     *
     **/
    public int numSimilarGroups(String[] strs) {
        int arrayLen = strs.length;
        int strLen = strs[0].length();
        init(arrayLen);
        for (int i=0;i<arrayLen;i++){
            for (int j = i+1;j<arrayLen;j++){
                if (check(strs[i],strs[j],strLen)){
                    union(i,j);
                }
            }
        }
        int cnt = 0;
        for (int index=0;index<arrayLen;index++){
            if (parent[index]==index){
                cnt++;
            }
        }
        return cnt;
    }

    public int find(int x){
        return parent[x]==x?x:find(parent[x]);
    }

    public void union(int x,int y){
        int x_root = find(x);
        int y_root = find(y);
        if (x_root==y_root){
            return;
        }
        parent[x_root] = y_root;
    }

    public void init(int len){
        parent = new int[len];
        for (int index=0;index<len;index++){
            parent[index] = index;
        }
    }

    /**
     * 判断字符串是否相似
     **/
    public boolean check(String a, String b, int len) {
        int num = 0;
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                num++;
                if (num > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
