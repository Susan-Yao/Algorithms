package sort;

public class heapSort {

//    堆排序 时间：O(N*logN)   空间：O(1)        稳定性：No
//    堆 - 是一个完全二叉树，分为大根堆/小根堆
//    堆的实现 - 用数组结构，但脑海里想的是完全二叉树

//  以下均为index
//    左孩子 2*i+1
//    右孩子 2*i+2
//    父节点 (i-1)/2

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 把整个数组 调整成大根堆
        for (int i = 0; i < arr.length; i++) { // O(N)
            heapInsert(arr, i); // O(logN)
        }
        // for(int i = arr.length -1; i >=0; i--) {
        // heapify(arr, i, arr.length);
        // }


        int heapSize = arr.length;
        swap(arr, 0, heapSize-1);  // 将最后一个数与第一个数交换 （第一个数一定是最大的）
        heapSize = heapSize - 1; // 有效长度 - 1

        while (heapSize > 0) { // O(N) 当heapsize减为0时，都排好了
            heapify(arr, 0, heapSize); // O(logN)
            swap(arr, 0, heapSize-1); // O(1) 将最后一个数与第一个数交换 （第一个数一定是最大的）
            heapSize = heapSize - 1; // 有效长度 - 1
        }
    }

    // 某个数现在处在index位置，往上继续移动 - 加在末尾，向上移动，调整成大根堆
    public static void heapInsert(int[] arr, int index) {
        // 跳出循环 - 不再大了 / 已经到root了
        while (arr[index] > arr[(index - 1) / 2]) { // 这个数 > 父
            swap(arr, index, (index - 1) / 2); // 与父亲交换
            index = (index - 1) / 2; // index来到父亲的位置
        }
    }

    // 某个数在index位置，能否往下移动 - 已经在root，向下移动
    // 结果：最大值在root - [0]位置
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1; // 左孩子的下标
        int right = index * 2 + 2; // 右孩子的下标
        while (left < heapSize) { // 下方还有孩子的时候
            // 两个孩子中，谁的值大，把下标给largest
            int largest = 0;
            if(right<heapSize && arr[right]>arr[left]){ // 有右孩子，并且右孩子>左孩子
                largest = right;
            }
            else{ // 没有右孩子 / 右孩子<=左孩子
                largest = left;
            }

            // 父和较大的孩子之间，谁的值大，把下标给largest
            if(arr[largest] > arr[index]){
               // largest 不变
            }
            else{
                largest = index;
            }

            // 如果在自己和两个孩子中，自己最大，则无需调整
            if (largest == index) {
                break;
            }
            swap(arr, largest, index); // 交换父与较大孩子
            index = largest; //不断向下沉
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args){
        int [] arr = {1,9,2,4,6,7,3,2,10};
        heapSort(arr);
        int i = 0;
        while(i<arr.length){
            System.out.println(arr[i]);
            i++;
        }
    }
}
