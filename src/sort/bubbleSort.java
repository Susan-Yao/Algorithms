package sort;

public class bubbleSort {
//    冒泡排序 时间：O(N^2)      空间：O(1)        稳定：Yes
//    两个相邻的数两两去比，哪个数大，哪个数向后换，每次搞定最后一个数

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int i = 0;
        while(i<arr.length-1){
            int j = 0;
            while(j<arr.length-1){
                if(arr[j]>arr[j+1]){
                    swap(arr, j, j+1);
                }
                j++;
            }
            i++;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args){
        int [] arr = {1,9,2,4,6,7,3,2,1,10,0};
        bubbleSort(arr);
        int i = 0;
        while(i<arr.length){
            System.out.println(arr[i]);
            i++;
        }
    }
}
