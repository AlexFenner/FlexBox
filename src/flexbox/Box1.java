/**
 * Box 1 class used for a box that is of type 1 which extends the abstract class Box
 */
package flexbox;

public class Box1 extends Box {
    //constructor for Box1
    Box1(double boxLength, double boxWidth, double boxHeight, int boxGrade,
            int boxColour, boolean btmRein, boolean crnrRein, boolean boxSeal, int qnty) {
        //references values that are within the superclass Box's constructor 
        super(boxLength, boxWidth, boxHeight, boxGrade,
                boxColour, btmRein, crnrRein, boxSeal, qnty);
    }
}
