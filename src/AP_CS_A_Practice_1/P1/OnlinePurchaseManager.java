package AP_CS_A_Practice_1.P1;

import java.util.ArrayList;

public class OnlinePurchaseManager {

    /**
     * An ArrayList of purchased Gizmo objects,
     * instantiated in the constructor.
     */
    private ArrayList<Gizmo> purchases;

    /**
     * Returns the number of purchased Gizmo objects that are
     * electronic whose manufacturer is maker, as described in
     * part (a).
     */
    public int countElectronicsByMaker(String maker) {
        /* to be implemented in part (a) */

        int count = 0;

        //if the gizmo is electronic and the maker matches increment count
        for (Gizmo g : purchases) {
            count += (g.isElectronic() && g.getMaker().equals(maker)) ? 1 : 0;
        }

        return count;
    }

    /**
     * Returns true if any pair of adjacent purchased Gizmo objects
     * are equivalent, and false otherwise, as described in
     * part (b).
     */
    public boolean hasAdjacentEqualPair() {
        /* to be considered in part (b) */

        /*
         This method would be called just before an order is placed.
         if this method then returns true the user would be warned
         that they may have unintended items in their cart
         */


        // No check is needed if the cart is empty or only has one item
        if (purchases.size() < 2) {
            return false;
        }

        // i starts as the second to last element of the array
        for (int i = purchases.size() - 2; i >= 0; i--) {
            if (purchases.get(i).equals(purchases.get(i + 1)))
                return true;
        }

        // If no adjacent equal pairs are found return false
        return false;
    }

    /** There may be instance variables, constructors, and
     *  methods not shown.
     */

}
