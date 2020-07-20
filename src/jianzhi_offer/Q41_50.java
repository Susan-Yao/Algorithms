package jianzhi_offer;
import java.util.*;

public class Q41_50 {

    // JZ 43 坐旋转字符串, 左移n位
    public String LeftRotateString(String str,int n) {
        int initial = str.length();
        String  news = str + str;
        int i = 0;
        String  result = new String();
        while (i<initial){
            result = result + news.charAt(i+n);
            i++;
        }
        return result;
    }

    // JZ 44 翻转句子中的单词
    public static String ReverseSentence(String str) {
        String [] sp = str.split("\\s+"); //这是一个数组，类型是string
        int l = sp.length;
        if (l == 0){ // 如果全是空格，就返回本身
            return str;
        }
        String  result = new String();
        while(l>0){
            if (l==1){
                result = result + sp[l-1];
            }
            else{
                result = result + sp[l-1] + ' ';
            }
            l--;
        }
        return result;
    }

    // JZ 45 扑克牌随机抽5张，是否为顺子
    public static boolean isContinuous(int [] numbers) { // 输入5个数
        boolean res = true;
        int i = 0;
        int len = numbers.length;
        if(len!=5){
            return false;
        }
        boolean have_zero = false; // 有没有0
        int num_zero = 0; // 0的个数
        Arrays.sort(numbers); // 将数组排序
        while (i<len){
            if(numbers[i] == 0){
                have_zero = true;
                num_zero++; // 有几个0，第一个非0数就在几
            }
            i++;
        }
        if (!have_zero){ // 如果没有0
            int j = 0;
            while(j<len-1){
                if(numbers[j+1]-numbers[j] != 1){
                    res = false;
                }
                j++;
            }
        }

        else{ // 如果有0
            int num_z = num_zero;
            System.out.println("0的个数是：" + num_zero);
            int sum_diff = 0; // 间隔和
            while(num_zero<len-1){
                if(numbers[num_zero+1]==numbers[num_zero]) {
                    res = false;
                    break;
                }
                else{
                    sum_diff = sum_diff + (numbers[num_zero+1]-numbers[num_zero]-1);
                }
                num_zero++;
            }
            System.out.println("间隔和是：" + sum_diff);
            if(sum_diff > num_z){
                System.out.println("dale");
                res = false;
            }
        }
        return res;
    }

    // 49
    public int StrToInt(String str) {
        if (str.length() == 0 || "".equals(str)) { // 如果str为空
            return 0;
        }
        boolean isNeg = false; // 判断正负
        if (str.charAt(0) == '+') {
            str = str.substring(1);
        } else if (str.charAt(0) == '-') {
            isNeg = true;
            str = str.substring(1);
        }

        char[] s = str.toCharArray();
        double res = 0;
        for (int i = 0; i < s.length; i++) {
            if (!Character.isDigit(s[i])) { // 如果这一位不是数字
                return 0;
            } else { // 如果是数字
                res += Math.pow(10, s.length - i - 1) * (s[i] - 48); // 在ascii表中，字符0对应48
            }
        }
        if(isNeg==false) { // 如果是正数
            if(res>Integer.MAX_VALUE) { // 大于最大的正数
                return 0;
            }else {
                return (int)res;
            }
        }else { // 如果是负数
            if((0-res)<Integer.MIN_VALUE) { // 小于最小的负数
                return 0;
            }else {
                return (int)(0-res);
            }
        }
    }

    public static void main(String[] args){
//        int[] num = {1,0,0,1,0};
//        boolean a = isContinuous(num);
//        System.out.println(a);
        String s = new String ("34276");
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i] * 10);
        }


    }


}
