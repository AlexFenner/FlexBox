/**
 * Box 2 class used for a box that is of type 2 which extends the abstract class Box
*/
package flexbox;


public class Box2 extends Box{
    //constructor for Box2
    Box2(double boxLength, double boxWidth, double boxHeight, int boxGrade,
            int boxColour, boolean btmRein, boolean crnrRein, boolean boxSeal, int qnty) {
        //references values that are within the superclass Box's constructor 
        super(boxLength, boxWidth, boxHeight, boxGrade,
             boxColour, btmRein, crnrRein, boxSeal, qnty);
    
                
    }
    /**
     * Overrides the method for returning the class in the main Box method
     * @return the number of colours for a type 2 box
     */
    @Override 
    public int getColour(){
        return 1;
    }
}
