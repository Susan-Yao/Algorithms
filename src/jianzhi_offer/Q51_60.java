package jianzhi_offer;
import java.util.regex.Pattern;

public class Q51_60 {

    // 52 '.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）
    public boolean match(char[] str, char[] pattern)
    {
        if (str == null || pattern == null)
            return false;
        return matchCore(str, 0, pattern, 0);
    }
    private boolean matchCore(char[] str, int s, char[] pattern, int p) { // s - str的指针，p - pattern的指针

        //下面4行是递归结束标志，两个指针都指到了最后，才是匹配，否则不匹配
        if (s == str.length && p == pattern.length)
            return true;
        if (s < str.length && p == pattern.length)
            return false;

        //如果出现了*
        if (p + 1 < pattern.length && pattern[p + 1] == '*') {
            //出现了*，并且当前s和P指向的相同，3种情况并列

            // 比如abcd和ab*cf，其中s和p都指向了b。此时应该s+1和p+2。
            // 比如abbcd和ab*cf，其中s和p都指向了b。由于b出现了多次，应该不着急移动p，所以此时s+1即可。
            // 比如"cba","cb*a*a"，我也可以认为，p指向的第1个a没出现过，即使你相等。因此此时可以s不动，p+2。
            if (s < str.length && (pattern[p] == str[s] || pattern[p] == '.')) {
                // 如果三个有一个是true，就是return true
                return matchCore(str, s, pattern, p + 2)
                        || matchCore(str, s + 1, pattern, p)
                        || matchCore(str, s + 1, pattern, p + 2);
            } else { //出现了*，并且s和p指向的不同，那就把*前面的字符 理解为出现了0次，p+2
                return matchCore(str, s, pattern, p + 2);
            }
        }

        //如果当前位相同 / pattern的当前位是.
        if (s < str.length && (pattern[p] == str[s] || pattern[p] == '.'))
            return matchCore(str, s + 1, pattern, p + 1);
        //p后面又不是*，也没有.给你撑腰，你还敢出现不同，那必然false
        return false;
    }

    // 53 判断字符串是否表示数值（包括整数和小数）- 正则表达
    public boolean isNumeric(char[] str) {

        String pattern = "^[-+]?\\d*(?:\\.\\d*)?(?:[eE][+\\-]?\\d+)?$";
        String s = new String(str);
        return Pattern.matches(pattern,s);
    }

    // 54

    public static void main(String[] args){

    }
}
