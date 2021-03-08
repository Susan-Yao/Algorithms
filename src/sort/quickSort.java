package sort;

public class quickSort {

//    快速排序 时间：O(N*logN)   空间：O(logN)     稳定性：No
//    在数组中随机取一个数p，将数组划分为<p，=p，>p区域，

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    // arr[L..R]排好序
    public static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            int random = (int) (Math.random() * (R - L + 1)); // 在L-R上取一个随机数 - 随机位置
            swap(arr, L + random, R); //将这个数与最后一个数交换
            int[] p = partition(arr, L, R); // 返回等于区域(左边界，右边界) - 不可能没有
            quickSort(arr, L, p[0] - 1); // < 区
            quickSort(arr, p[1] + 1, R); // > 区
        }
    }

    // 这是一个处理arr[l..r]的函数
    // 默认以arr[r]做划分，arr[r] -> p     <p   ==p   >p
    // 返回等于区域(左边界，右边界), 所以返回一个长度为2的数组res, res[0] res[1]
    // 返回的为index
    public static int[] partition(int[] arr, int L, int R) {
        int less = L - 1; // <区 右边界
        int more = R; // >区 左边界
        while (L < more) { // L表示当前数的位置   arr[R]  ->  划分值
            // 当前数   <  划分值
            if (arr[L] < arr[R]) {
                swap(arr, L, less+1); // 当前数与<区下一个交换
                less++; // <区右扩
                L++; // 当前数跳下一个
            // 当前数   >  划分值
            } else if (arr[L] > arr[R]) {
                swap(arr, L, more-1); // 当前数与>区前一个交换
                more--; // >区左扩
            // 当前数   =  划分值
            } else {
                L++; // 当前数跳下一个
            }
        }
        swap(arr, more, R); // 将 >区左边界 与 最后一个数 交换
        return new int[] { less + 1, more };
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args){
        int [] arr = {1,9,2,4,6,7,3,2,1,10,0};
        quickSort(arr);
        int i = 0;
        while(i<arr.length){
            System.out.println(arr[i]);
            i++;
        }
    }
}
