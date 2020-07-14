package sort;

public class selectionSort {

//    选择排序 时间：O(N^2)      空间：O(1)        稳定：No
//    在 0 ~ N-1 上找最小值，放在0位置上（把找到的最小值与0位置上的数字交换）

    public static void selectionSort(int[] arr) {
        // 如果数组为空，或数组中只有一个数
        if (arr == null || arr.length < 2) {
            return;
        }
        int i = 0;
        while(i<arr.length-1){ // 如果长度为length，length-1位已经有序了，那么最后一位也不用排了
            int minIndex = i;
            int j = i+1;
            while(j<arr.length){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
                j++;
            }
            swap(arr, i, minIndex);
            i++;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args){
        int [] arr = {1,9,2,4,6,7,3,2,10};
        selectionSort(arr);
        int i = 0;
        while(i<arr.length){
            System.out.println(arr[i]);
            i++;
        }
    }
}
