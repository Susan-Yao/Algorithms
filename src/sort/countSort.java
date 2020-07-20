package sort;

public class countSort {
    // 计数排序 时间：O(N)      空间：O(N)        稳定：Yes
    // 对每个数进行词频统计
    // 缺点：因为整数有范围（-21亿 ~ +21亿），所以对要排序的数的个数有限制

    // e.g. 假如数组中有5个数 [23，45，17，9，38]
    public static void countSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int max = Integer.MIN_VALUE; // 数组[23，45，17，9，38]中的最大值 45
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int[] bucket = new int[max + 1]; // 辅助数组 长度为46 --- 记录0-45 的出现次数
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]] = bucket[arr[i]] + 1;
        }
        int i = 0;
        for (int j = 0; j < bucket.length; j++) { // 根据bucket数组，写出排序后的arr
            while (bucket[j]> 0) {
                arr[i] = j;
                i = i + 1;
                bucket[j] = bucket[j] - 1;
            }
        }
    }

    public static void main(String[] args){
        int [] arr = {1,9,2,4,6,7,3,2,1,10,0};
        countSort(arr);
        int i = 0;
        while(i<arr.length){
            System.out.println(arr[i]);
            i++;
        }
    }
}
