
package flexbox;


public class Box3 extends Box{
    Box3(int boxID, double boxLength, double boxWidth, double boxHeight, int boxGrade,
            int boxColour, boolean btmRein, boolean crnrRein, boolean boxSeal, int qnty) {
        super(boxID, boxLength, boxWidth, boxHeight, boxGrade,
             boxColour, btmRein, crnrRein, boxSeal, qnty);
    
                
    }
    
    @Override 
    public int getColour(){
        return 2;
    }
}
