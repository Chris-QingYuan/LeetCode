import java.util.HashMap;
import java.util.Map;

/**
 * Created by Qing (Chris) Yuan on Feb/11/2018 12:43 AM
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println(minimumWindowSubstring.minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length() || t.length() == 0) return "";

        Map<Character, Integer> map = new HashMap<>();
        char curChar;
        for (int i = 0; i < t.length(); i++) {
            curChar = t.charAt(i);
            if (map.get(curChar) == null) map.put(curChar, 1);
            else map.put(curChar, map.get(curChar) + 1);
        }

        int curStart = 0, remain = t.length(),
                minWindow = Integer.MAX_VALUE, resStart = 0, resEnd = 0, tmp;
        boolean found = false;

        for (int i = 0; i < s.length(); i++) {
                curChar = s.charAt(i);
                if (t.indexOf(curChar) != -1) {
                    tmp = map.get(curChar);
                    map.put(curChar, tmp - 1);
                    if (tmp > 0) remain--;
                    if(remain == 0){
                        found = true;
                        while (remain == 0) {
                            curChar = s.charAt(curStart);
                            if (t.indexOf(curChar) != -1) {
                                tmp = map.get(curChar);
                                map.put(curChar, tmp + 1);
                                if (tmp == 0) {
                                    if (i - curStart + 1 < minWindow) {
                                        minWindow = i - curStart + 1;
                                        resStart = curStart;
                                        resEnd = i + 1;
                                    }
                                    remain++;
                                }
                            }
                            curStart++;
                        }
                    }
                }
        }


        return found ? s.substring(resStart, resEnd) : "";
    }
}
