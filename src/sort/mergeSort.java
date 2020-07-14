package sort;

public class mergeSort {

//    归并排序 - 递归 时间：O(N*logN)   空间：O(N)        稳定性：Yes
//    分两半，左边有序，右边有序，左右合并（合并时 谁小拿谁）

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    // 在arr上，L-R有序
    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1); // 找中点
        // 递归
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    // 在arr上，把L-M 与 M-R合并
    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1]; // 辅助数组，长度为L~R
        int i = 0;
        // 两个指针
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            // 谁小拿谁
            if(arr[p1] <= arr[p2]){
               help[i] = arr[p1];
               p1++;
            }
            else{
                help[i] = arr[p2];
                p2++;
            }
            i++;
        }

        // 将剩下的数，照抄下来 （一下两个while，只会发生一个）
        while (p1 <= M) {
            help[i] = arr[p1];
            i++;
            p1++;
        }
        while (p2 <= R) {
            help[i] = arr[p2];
            i++;
            p2++;
        }

        // 将辅助数组 赋给原数组
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    public static void main(String[] args){
        int [] arr = {1,9,2,4,6,7,3,2,1,10,0};
        mergeSort(arr);
        int i = 0;
        while(i<arr.length){
            System.out.println(arr[i]);
            i++;
        }
    }
}
