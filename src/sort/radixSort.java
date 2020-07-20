package sort;

public class radixSort {

//    基数排序 时间：O(N)      空间：O(N)        稳定：Yes

//    找到最大值，看最大值有几位 （例如 有3位）
//    准备10个桶
//    根据个位，决定进哪个桶 （桶：queue 先进先出）
//    根据十位，决定进哪个桶
//    根据百位，决定进哪个桶

    // only for no-negative value
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    public static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) { // 找max
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0) { // max有几位
            res = res + 1;
            max = max/10; // 一位数字/10 = 0
        }
        return res;
    }

    // arr[begin..end]排序
    // 在arr的L-R上排序，digit是最大的数有几个十进制位
    public static void radixSort(int[] arr, int L, int R, int digit) {
        final int radix = 10;
        int i = 0, j = 0;
        // 有多少个数准备多少个辅助空间
        int[] bucket = new int[R - L + 1];
        for (int d = 1; d <= digit; d++) { // 有多少位就进出几次
            // 10个空间
            // count[0] 当前位(d位)是0的数字有多少个
            // count[1] 当前位(d位)是(0和1)的数字有多少个
            // count[2] 当前位(d位)是(0、1和2)的数字有多少个
            // count[i] 当前位(d位)是(0~i)的数字有多少个

            int[] count = new int[radix]; // count[0..9] 长度为10
            for (i = L; i <= R; i++) { // 词频统计
                j = getDigit(arr[i], d);  // arr[i] 右起第d位的数字
                count[j] = count[j] + 1;
            }

            // 经过以下循环，count[]: x位数字<=0的一共有几个，x位数字<=1的一共有几个，x位数字<=2的一共有几个......
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }

            // ****从右向左遍历数组 - 做到了 先进后出，代替了10个队列****
            for (i = R; i >= L; i--) {
                j = getDigit(arr[i], d); // x位上的数字是j
                // count[j] 是<=j的数字一共有几个，那么x位上<=j的数字坐落在0 ~ count[j]-1上
                // 从右向左遍历，让这个数坐落在最后一个位置
                bucket[count[j] - 1] = arr[i];
                count[j] = count[j] - 1;
            }

            // 拷贝回原数组
            for (i = L, j = 0; i <= R; i++, j++) {
                arr[i] = bucket[j];
            }
        }
    }

    // x这个数，右起第d位的数字
    public static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }

    public static void main(String[] args){
        int [] arr = {1,9,2,4,6,7,3,2,1,10,0};
        radixSort(arr);
        int i = 0;
        while(i<arr.length){
            System.out.println(arr[i]);
            i++;
        }
    }
}
