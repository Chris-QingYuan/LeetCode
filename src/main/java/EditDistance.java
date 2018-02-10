import java.util.Arrays;

/**
 * Created by Qing (Chris) Yuan on Feb/08/2018 3:42 PM
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
 * (each operation is counted as 1 step.)
 * <p>
 * You have the following 3 operations permitted on a word:
 * <p>
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 */
public class EditDistance {

    public static void main(String[] args) {
        String word1 = "prosperity", word2 = "properties";
        EditDistance editDistance = new EditDistance();
        System.out.println(editDistance.minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();

        // make sure word1 is the shorter one
        if (word1.length() > word2.length()) {
            String tmp = word1;
            word1 = word2;
            word2 = tmp;
        }

        char[] chars1 = word1.toCharArray(),
                chars2 = word2.toCharArray();

        //create an array to store the corresponding position info for characters in word1
        int[][] matches = new int[chars2.length + chars1.length][chars1.length];
        int k;

        for (int i = 0; i < matches.length; i++) {
            k = i - chars1.length + 1;
            for (int j = 0; j < chars1.length && j < chars2.length - k; j++) {
                if (j + k < 0) continue;
                if (chars1[j] == chars2[j + k]) matches[i][j] = j + k + 1;
            }
        }

        for (int i = 0; i < matches.length; i++) {
            for (int j = 0; j < matches[i].length; j++) {
                System.out.print(matches[i][j] + ", ");
            }
            System.out.println();
        }

        int curMatchEnd = chars1.length, curMatchDis = 0, maxMatchLen = 0, minDistance = chars2.length;
        int[] curMatchInfo = new int[chars1.length];

        for (int i = 0; i < matches.length; i++) {
            for (int j = 0; j < chars1.length; j++) {
                if (matches[i][j] > 0) {
                    if (j <= curMatchEnd) {
                        curMatchDis = distanceOfMatch(curMatchInfo, chars1.length, chars2.length);
                        if (curMatchDis < minDistance) minDistance = curMatchDis;
                        for (int l = curMatchEnd; l < chars1.length; l++) {
                            curMatchInfo[l] = 0;
                        }
                    }
                    curMatchInfo[j] = matches[i][j];
                    curMatchEnd = j;

                }
            }
        }
        curMatchDis = distanceOfMatch(curMatchInfo, chars1.length, chars2.length);
        if (curMatchDis < minDistance) minDistance = curMatchDis;


        return minDistance;
    }

    private int distanceOfMatch(int[] MatchInfo, int len1, int len2) {
        int res = 0, prev1 = -1, prev2 = 0;
        for (int i = 0; i < MatchInfo.length; i++) {
            if (MatchInfo[i] > 0) {
                res += Math.max(i - prev1 - 1, MatchInfo[i] - prev2 - 1);
                prev1 = i;
                prev2 = MatchInfo[i];
            }
        }
        res += Math.max(len1 - prev1 - 1, len2 - prev2);

        return res;
    }

}
