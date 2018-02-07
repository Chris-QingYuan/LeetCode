import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Qing (Chris) Yuan on Feb/06/2018 6:34 PM
 */
public class TextJustification {

    public static void main(String[] args) {
        String[] words  = {"What","must","be","shall","be."};
        int maxWidth = 12;
        TextJustification textJustification = new TextJustification();
        textJustification.fullJustify(words, maxWidth);

    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new LinkedList<>();

        if(words == null || words.length == 0 || maxWidth < 0) return list;

        int[] lengths = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > maxWidth) return list; else lengths[i] = words[i].length();
        }


        int curStart = 0,
                curWordCount,
                curWidth,
            totWord = words.length;


        while(curStart < totWord){
            curWordCount = 0;
            curWidth = 0;
            while(curStart + curWordCount < totWord && curWidth +  words[curStart + curWordCount].length() <= maxWidth){
                curWidth += words[curStart + curWordCount].length() + 1;
                curWordCount++;
            }
            list.add(getEntry(words, curStart, curWordCount, maxWidth));
            curStart += curWordCount;
        }

        String lastEntry = list.get(list.size() - 1),
            aBlank = " ";
        while(lastEntry.contains("  ")) lastEntry = lastEntry.replace("  ", aBlank);
        while(lastEntry.length() != maxWidth) lastEntry = lastEntry.concat(aBlank);
        list.remove(list.size() - 1);
        list.add(lastEntry);

        return list;
    }

    private String getEntry(String[] words, int curStart, int curWordCount, int maxWidth) {
        int sumLen = 0,
                blanks,
                minBlank,
                extraBlank = 0;
        for(int i = 0; i < curWordCount; i++){
            sumLen += words[curStart + i].length();
        }
        blanks = maxWidth - sumLen;
        if(curWordCount > 1){
            minBlank = blanks / (curWordCount - 1);
            extraBlank = blanks % (curWordCount - 1);
        }else {
            minBlank = blanks;
        }

        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < curWordCount; i++){
            stringBuilder.append(words[curStart + i]);
            for (int j = 0; j < minBlank; j++) stringBuilder.append(" ");
            if (index < extraBlank) stringBuilder.append(" ");
            index++;
        }

        String res = stringBuilder.toString();
        if (res.length() > maxWidth) res = res.substring(0, maxWidth);

        return res.length() == 0 ? "" : res;
    }

}
