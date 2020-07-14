package jianzhi_offer;

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
//    public boolean isContinuous(int [] numbers) {
//        int i = 0;
//        while (i< numbers.length){
//
//            i++;
//
//        }
//
//    }

    public static void main(String[] args){
    }


}
