/**
 * Created by Qing (Chris) Yuan on Feb/06/2018 3:29 PM
 */
public class AddBinary {

    public static void main(String[] args) {
        String a = "111",
                b = "1111111";
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary(a, b));
    }

    public String addBinary(String a, String b) {

        if (a.length() == 0 || !a.contains("1")) return b;
        if (b.length() == 0 || !b.contains("1")) return a;

        if (b.length() > a.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }

        char[] aChars = a.toCharArray(),
                bChars = b.toCharArray(),
                res = new char[aChars.length + 1];

        int i = aChars.length - 1,
                j = bChars.length - 1,
                quotient = 0,
                sum = 0;

        while (j >= 0) {
            sum = (aChars[i] - '0') + (bChars[j] - '0') + quotient;
            res[i + 1] = (char) (sum % 2 + '0');
            quotient = sum / 2;
            i--;
            j--;
        }

        while (i >= 0) {
            sum = (aChars[i] - '0') + quotient;
            res[i + 1] = (char) (sum % 2 + '0');
            quotient = sum / 2;
            i--;
        }

        if (quotient == 1) res[0] = '1';
        i = 0;
        while (res[i] != '1') i++;
        StringBuilder stringBuilder = new StringBuilder();
        while (i < res.length) {
            stringBuilder.append(res[i]);
            i++;
        }
        return stringBuilder.toString();
    }
}
