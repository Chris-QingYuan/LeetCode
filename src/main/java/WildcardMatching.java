/**
 * Created by Qing (Chris) Yuan on Feb/02/2018 4:53 PM
 */
public class WildcardMatching {

    public static void main(String[] args) {
        String s = "a";
        String p = "a*****";
        WildcardMatching wildcardMatching = new WildcardMatching();
        System.out.println(wildcardMatching.isMatch(s, p));

    }

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        while (p.indexOf("**") != -1) {
            p = p.replace("**", "*");
        }
        if(p.equals("*")) return true;
        if(s.length() == 0) return (p.length() == 0);

        int sLen = s.length(),
                pLen = p.length();

        boolean[][] flags = new boolean[sLen + 1][pLen + 1];
        flags[sLen][pLen] = true;
        char pCur;

        for (int j = pLen - 1; j >= 0; j--) {
            for (int i = sLen - 1; i >= 0; i--) {
                pCur = p.charAt(j);

                if (pCur == '*') {
                    flags[i+1][j] = (flags[i+1][j+1] || flags[i+1][j]);
                    flags[i][j] = (flags[i + 1][j] || flags[i][j + 1]);
                } else if (pCur == '?') {
                    flags[i][j] = flags[i+1][j+1];
                } else {
                    flags[i][j] = (flags[i+1][j+1] && pCur == s.charAt(i));
                }
            }

        }


        return flags[0][0];
    }

/*    public static void main(String[] args) {
        String s = "aaaskfuhknibvvafiugbniasfghjawethgiawhgahsgiobasiugb";
        String p = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
        WildcardMatching wildcardMatching = new WildcardMatching();
        System.out.println(wildcardMatching.isMatch(s, p));

    }


    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        while (p.indexOf("**") != -1) {
            p = p.replace("**", "*");
        }
        return isMatch(s, 0, p, 0);
    }


    private boolean isMatch(String s, int sIndex, String p, int pIndex) {
        if (sIndex == s.length() && pIndex == p.length()) return true;
        if (pIndex == p.length()) return false;
        if (sIndex == s.length()) {
            if (p.charAt(pIndex) != '*') return false;
            else return isMatch(s, sIndex, p, pIndex + 1);
        }

        char pCur = p.charAt(pIndex),
                sCur = s.charAt(sIndex);
        if (pCur == '*') {
            if (pIndex == p.length() - 1) return true;
            return (isMatch(s, sIndex, p, pIndex + 1) || isMatch(s, sIndex + 1, p, pIndex));
        } else if (pCur == '?') {
            return isMatch(s, sIndex + 1, p, pIndex + 1);
        } else {
            if (pCur != sCur) return false;
            else return isMatch(s, sIndex + 1, p, pIndex + 1);
        }
    }*/
}
