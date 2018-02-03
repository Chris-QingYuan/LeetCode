import java.util.*;

/**
 * Created by Qing (Chris) Yuan on Feb/03/2018 12:09 AM
 */
public class GroupAnagrams {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    private List<List<String>> lol = new LinkedList<>();

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return lol;

        Map<String, List<String>> map = new HashMap<>();
        String curAna = null;
        char[] curChars = null;
        List<String> list = null;

        for (int i = 0; i < strs.length; i++) {
            curChars = strs[i].toCharArray();
            Arrays.sort(curChars);
            curAna = new String(curChars);
            if (map.get(curAna) == null) {
                list = new LinkedList<>();
                list.add(strs[i]);
                map.put(curAna, list);
                lol.add(list);
            }else{
                map.get(curAna).add(strs[i]);
            }

        }
        return lol;
    }


}
