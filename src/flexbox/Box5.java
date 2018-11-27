/**
 * Box 5 class used for a box that is of type 4 which extends the abstract class Box
*/
package flexbox;
public class Box5 extends Box{
    //constructor for Box5
    Box5(double boxLength, double boxWidth, double boxHeight, int boxGrade,
            int boxColour, boolean btmRein, boolean crnrRein, boolean boxSeal, int qnty) {
        //references values that are within the superclass Box's constructor 
        super(boxLength, boxWidth, boxHeight, boxGrade,
             boxColour, btmRein, crnrRein, boxSeal, qnty);
     }
     /**
     * Overrides the method for returning the class in the main Box method
     * @return the number of colours for a type 5 box
     */
    @Override 
    public int getColour(){
        return 2;
    }
    /**
     * Overrides the method for returning whether or not the box has a reinforced bottom
     * @return The boolean value for bottom reinforcement for box 5 which is true
     */
    @Override
    public boolean getBottomReinforcement(){
        return true;
    }
    /**
     * Overrides the method for returning whether or not the box has a reinforced corners
     * @return The boolean value for corner reinforcement for box 5 which is true
     */
    @Override
    public boolean getCornerReinforcement(){
        return true;
    }
}
