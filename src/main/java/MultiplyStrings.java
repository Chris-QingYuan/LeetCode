/**
 * Created by Qing (Chris) Yuan on Feb/01/2018 6:57 PM
 */
public class MultiplyStrings {

    public static void main(String[] args) {
        String num1 = "99";
        String num2 = "99";
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        System.out.println(multiplyStrings.multiply(num1, num2));

    }


    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0 || num1.equals("0") || num2.equals("0"))
            return "0";

        char[] num1Chars = num1.toCharArray(),
                num2Chars = num2.toCharArray(),
                result = new char[num1Chars.length + num2Chars.length];

        int product = 0,
                k = 0;

        for (int i = num2Chars.length - 1; i >= 0; i--) {
            for (int j = num1Chars.length - 1; j >= 0; j--) {
                if (result[i + j + 1] < '0' || result[i + j + 1] > '9') result[i + j + 1] = '0';
                product = (num2Chars[i] - '0') * (num1Chars[j] - '0');
                k = i + j + 1;
                while (product > 0) {
                    product += result[k] - '0';
                    result[k] = (char) (product % 10 + '0');
                    product = product/10;
                    k--;
                }

            }
        }

        int i = 0;
        while ((i < result.length - 1) && (result[i] < '1' || result[i] > '9')) i++;

        return (new String(result)).substring(i);

    }
}
