package sort;

public class insertSort {

//    插入排序 时间：O(N^2)      空间：O(1)        稳定：Yes
//    0-1 上有序，0-2上有序，0-3上有序......
//    0-i 上有序，从i-1开始与i比，若i-1大，则交换。直到0位置结束

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int i = 1; // 0-0 上肯定是有序的，那么就从1开始
        while(i<arr.length){ // 0~i 想有序
            int j = i-1;
            while(j>=0 && arr[j] > arr[j + 1]){
                swap(arr, j, j + 1);
                j--;
            }
            i++;
        }
    }

    // 不引入新的变量，交换两个数 - 异或
    // i和j是一个位置的话，会出错
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args){
        int [] arr = {1,9,2,4,6,7,3,2,1,10,0};
        insertionSort(arr);
        int i = 0;
        while(i<arr.length){
            System.out.println(arr[i]);
            i++;
        }
    }
}
