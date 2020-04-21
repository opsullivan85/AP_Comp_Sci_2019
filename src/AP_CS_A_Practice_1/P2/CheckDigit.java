package AP_CS_A_Practice_1.P2;

public class CheckDigit<checkDigit> {
    /**
     * Returns the check digit for num, as described in part (b).
     * Precondition: The number of digits in num is between one and
     * six, inclusive.
     * num >= 0
     */
    public static int getCheck(int num) {
        /* to be considered in part (b) */

        /*
        Just as I was turning this in I realised that there were the two included methods,
        that would have made this problem like 200x easier...
         */

        int checkDigit = 0;
        int tmp;
        int j;
        int i = 0;

        while (num > 0) {
            tmp = num;

            j = 0;
            while (tmp >= 10) {
                tmp /= 10;
                j++;
            }
            checkDigit += j * i;

            //...

        }

        return (checkDigit);
    }

    /**
     * Returns true if numWithCheckDigit is valid, or false
     * otherwise, as described in part (b).
     * Precondition: The number of digits in numWithCheckDigit
     * is between two and seven, inclusive.
     * numWithCheckDigit >= 0
     */
    public static boolean isValid(int numWithCheckDigit) {
        /* to be implemented in part (a) */
        int checkDigit = numWithCheckDigit % 10;
        int num = numWithCheckDigit / 10;

        return checkDigit == getCheck(num);
    }

    /**
     * Returns the number of digits in num.
     */
    public static int getNumberOfDigits(int num) {
        /* implementation not shown */
        return -1;
    }

    /**
     * Returns the nthdigit of num.
     * Precondition: n >= 1 and n <= the number of digits in num
     */
    public static int getDigits(int num, int n) {
        /* implementation not shown */
        return -1;
    }

    /** There may be instance variables, constructors, and
     *  methods not shown.
     */
}

