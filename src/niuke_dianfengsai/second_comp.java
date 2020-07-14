package niuke_dianfengsai;
import java.util.*;
public class second_comp {

    // A 牛牛扔牌
    public String Orderofpoker (String x) {
        // write code here
        int i = 0;
        int total = x.length();
        int l = x.length()/2; //有多少张牌
        int num = l; //当前的牌数
        String res = new String();
        while (num>0){

            if (isPrime(num)){ //如果是质数
                res = res + x.charAt(i) + x.charAt(i+1);
                i = i + 2;

            }
            else{
                res = res + x.charAt(total - 2) + x.charAt(total - 1);
                total = total - 2;
            }
            num --;

        }
        return res;
    }

    // 判断素数
    public boolean isPrime(int n) {

        if(n < 2) return false;

        for(int i = 2; i < n; ++i)

            if(n%i == 0) return false;

        return true;

    }

    // B 疯狂过山车 - 找到长度最长的金字塔数组
    // 思路一 ： 看每个数 从前往后循环上升，从后往前循环下降。相加后，找max
    public int getMaxLength1 (int n, int[] num) { // num的长度是n
        int[] left = new int[n]; //长度为n的数组
        int[] right = new int[n]; //长度为n的数组
        int i = 1;
        while(i < n){   // 数组中所有数，每个数左侧的递增串长度
            if(num[i-1] < num[i]){
                left[i] = left[i-1] + 1;
            }
            i++;
        }

        int j = n-2;
        while(j>=0){ // 数组中所有数，每个数右侧的递减串长度
            if(num[j+1] < num[j]){
                right[j] = right[j+1] + 1;
            }
            j--;
        }
        int[] sum = new int[n]; //长度为l的数组
        for(int k =0; k<n; k++){
            sum[k] = left[k] + right[k];
        }
        return MAX(sum) + 1; //加上自己
    }

    public static int MAX(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length-1];
    }

    // 思路二 ： 找到第一个可能是过山车起点的点i，从它开始继续向后找最高的点，再从最高点找到终点j，下一次的i从j开始就好
    public int getMaxLength2 (int n, int[] num) { // num的长度是n
        int anx = 0;
        int l = 0,r = 0;
        while(r < n-1) {
            while ((l < n-1) && (num[l] >= num[l+1]))
                l++;
            r = l;
            while (r < n-1 && num[r] < num[r+1])
                r++;
            while (r < n-1 && num[r] > num[r+1]) {
                r++;
            }
            anx = Math.max(anx, r - l + 1); // 取最大值
            l = r;
        }
        return anx;
    }

    public static void main(String[] args){
    }



}
