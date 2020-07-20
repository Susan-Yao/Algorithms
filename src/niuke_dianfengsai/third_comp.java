package niuke_dianfengsai;
import java.util.*;

public class third_comp {

    // A
    public static long sum (int n, int m) {
        // write code here
        if(n == 0){
            return 0;
        }

        long res = 0;
        // 长度为n的数 的个数
        int num = (int)Math.pow(10, n) - (int)Math.pow(10, n-1);
        int i = (int)Math.pow(10, n-1);
        
        while(i<num+i){
            String str = Integer.toString(i);
            int j = 0;
            int sum = 0;
            while(j<n){
                sum = str.charAt(j) - 48 + sum;
                j++;
            }
            if(sum == m){
               res = res + i;
               System.out.println("hahaha: "+ i);
            }
            i++;
        }
        return res;
    }

    // C
//    public int solve (int n, int[] a, int k) {
//        // write code here
//
//
//
//    }

    public static void main(String[] args){
        int a = 456;
        String str = Integer.toString(456);
        for (int i=0;i<3;i++){
            System.out.println(str.charAt(i) -48 + 5);
        }

        System.out.println((int)Math.pow(10, 2) - (int)Math.pow(10, 1));
        System.out.println(sum(2,3));
    }
}
