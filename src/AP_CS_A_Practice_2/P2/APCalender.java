package AP_CS_A_Practice_2.P2;

public class APCalender{
    /** Returns true if year is a leap year and false otherwise. */
    private static boolean isLeapYear(int year){
        /* implementation not shown */
        return false;
    }

    /** Returns the number of leap years between year1 and year2,
     *  inclusive.
     *  Precondition: 0 <= year1 <= year2
     */
    public static int numberOfLeapYears(int year1, int year2){
        /* to be implemented in part (a) */

        int count = 0;

        for(int year = year1; year <= year2; year++){
            if(isLeapYear(year))
                count++;
        }

        return count;
    }

    /** Returns the value representing the day of the week for the
     *  first day of year, where 0 denotes Sunday, 1 denotes
     *  Monday, ..., and 6 denotes Saturday.
     */
    private static int firstDayOfYear(int year){
        /* implementation not shown */
        return -1;
    }

    /** Returns n, where month, day, and year specify the nth day of
     *  the year. Returns 1 for January 1(month = 1, day = 1) of any
     *  year.
     *  Precondition: The date represented by month, day, year is a
     *  valid date.
     */
    private static int dayOfYear(int month, int day, int year){
        /* implementation not shown */
        return -1;
    }


    /** Returns the value representing the day of the week for the
     *  given date (month, day, year), where 0 denotes Sunday,
     *  1 denotes Monday, ..., and 6 denotes Saturday.
     *  Precondition: The date represented by month, day, year is
     *  a valid date.
     */
    public static int dayOfWeek(int month, int day, int year){
        /* to be considered in part (b) */

        /*
        This method would first need to convert the date into an absolute date of the year, using 'dayOfYear()'. This
        would be a number 'n' between 1 and 366. Then, this function would need the first day of the year 'd' by calling
        'firstDayOfYear()'. Then the function would add 'n' to 'd' then take that value and modulo it by 7, and once
        again store the result in 'n'. Finally 'n' would be returned.
         */

        return -1;
    }

/* There may be instance variables, constructors, and methods
 *  that are not shown.
 */
}
