/**
 * Box 2 class used for a box that is of type 2 which extends the abstract class Box
 */
package flexbox;

/**
 * @author Group A4
 */
public class Box2 extends Box {

    /**
     * Constructor for Box2
     *
     * @param boxLength The length of the box
     * @param boxWidth The width of the box
     * @param boxHeight The height of the box
     * @param boxGrade The grade of the box
     * @param boxColour The number of colours the box has
     * @param btmRein Whether or not the box has a reinforced bottom
     * @param crnrRein Whether or not the box has reinforced corners
     * @param boxSeal Whether or not the box has a sealable top
     * @param qnty The number of boxes
     */
    Box2(double boxLength, double boxWidth, double boxHeight, int boxGrade,
            int boxColour, boolean btmRein, boolean crnrRein, boolean boxSeal,
            int qnty) {
        //references values that are within the superclass Box's constructor 
        super(boxLength, boxWidth, boxHeight, boxGrade,
                boxColour, btmRein, crnrRein, boxSeal, qnty);
    }

    /**
     * Overrides the method for returning the class in the main Box method
     *
     * @return the number of colours for a type 2 box
     */
    @Override
    public int getColour() {
        return 1;
    }
}
