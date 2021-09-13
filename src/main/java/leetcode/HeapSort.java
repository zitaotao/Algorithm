package leetcode;

/**
 * 请描述类的业务用途
 *
 * @author jzt
 * @version 1.0
 * @date 2021-02-25 10:35
 **/
public class HeapSort {
    public static void heapSort(int arr[]) {
        return;
    }

    public void adjustHeap(int arr[], int left, int right){
        int root = arr[left];

        for (int son = left*2+1;son<right;son = son*2+1){
            //选择当前大的子节点
            if (son+1<right&&arr[son]<arr[son+1]){
                son++;
            }
            //如果子节点大那么置顶
            if (arr[son]>root){
                arr[left] = arr[son];
                left = son;
            }else {
                break;
            }
        }

        arr[left] = root;
    }
}
