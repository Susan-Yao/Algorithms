package jianzhi_offer;

import java.util.HashMap;

public class Q31_40 {

    // JZ 34 第一个只出现一次的字符 的位置
    public int FirstNotRepeatingChar(String str) {
        int l = str.length();
        // hashmap的顺序 是不会变的 - 怎么存进去的，就是什么顺序
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int i = 0;
        // 遍历str，将frequency存入map
        while(i<l){
            if (!map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), 1);
            }
            else{
                int value = map.get(str.charAt(i));
                map.put(str.charAt(i), value+1);
            }
            i++;
        }
        //遍历str，找到第一个frequency是1 的位置
        for(int j = 0; j < str.length();j++){
            if(map.get(str.charAt(j)) == 1){
                return j;
            }
        }
        return -1;
    }

    public static void main(String[] args){
    }
}
