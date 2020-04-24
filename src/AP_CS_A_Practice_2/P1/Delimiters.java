package AP_CS_A_Practice_2.P1;

import java.util.ArrayList;

public class Delimiters{
    /** The open and close delimiters. */
    private String openDel;
    private String closeDel;

    /** Constructs a Delimiters object where open is the open
     *  delimiter and close is the close delimiter.
     *  Precondition: open and close are non-empty strings.
     */
    public Delimiters(String open, String close){
        openDel = open;
        closeDel = close;
    }


    /** Returns an ArrayList of delimiters from the array
     *  tokens, as described in part (a).
     */
    public ArrayList<String> getDelimitersList(String[] tokens){
        /* to be implemented in part (a) */

       ArrayList<String> delimiters = new ArrayList<>();

        for (String token : tokens) {
            if(token.equals(openDel) || token.equals(closeDel))
                delimiters.add(token);
        }

        return delimiters;
    }

    /** Returns true is the delimiters are balanced and false
     *  otherwise, as described in part (b).
     *  Precondition: delimiters contains only valid open and close
     *  delimiters.
     */
    public boolean isBalanced(ArrayList<String> delimiters){
        /* to be considered in part (b) */

        /*
        This function needs to keep track of the amount of open and close delimiters. To do this it would be helpful
        to have a variable representing the difference between the amount of occurrences of each variable. For this
        example, every open delimiter encountered should increment the comparison variable, and all close delimiters
        should decrement it. While traversing the delimiters parameter, this function would return false if the
        comparison variable was ever negative. If this never happens, the array would finish being traversed and the
        function would return whether or not the comparison variable is equal to zero. This is because the comparison
        variable would only be zero if there are the same amount of open and close delimiters
         */

        int comparison = 0;

        //This loop will exit if comparison is ever negative
        for(int i = 0; i < delimiters.size() && comparison >= 0; i--){

            //An if statement is used here instead of a conditional for readability
            if(delimiters.get(i).equals(openDel)){
                comparison++;
            } else{
                comparison--;
            }
        }

        return(comparison == 0);
    }

/* There may be instance variables, constructors, and methods
 *  that are not shown.
 */
}
