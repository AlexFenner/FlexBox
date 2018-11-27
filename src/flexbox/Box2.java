
package flexbox;


public class Box2 extends Box{
    Box2(double boxLength, double boxWidth, double boxHeight, int boxGrade,
            int boxColour, boolean btmRein, boolean crnrRein, boolean boxSeal, int qnty) {
        super(boxLength, boxWidth, boxHeight, boxGrade,
             boxColour, btmRein, crnrRein, boxSeal, qnty);
    
                
    }
    
    @Override 
    public int getColour(){
        return 1;
    }
}
