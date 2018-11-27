
package flexbox;


public class Box5 extends Box{
    Box5(double boxLength, double boxWidth, double boxHeight, int boxGrade,
            int boxColour, boolean btmRein, boolean crnrRein, boolean boxSeal, int qnty) {
        super(boxLength, boxWidth, boxHeight, boxGrade,
             boxColour, btmRein, crnrRein, boxSeal, qnty);
    
                
    }
    
    @Override 
    public int getColour(){
        return 2;
    }
    
    @Override
    public boolean getBottomReinforcement(){
        return true;
    }
    
    @Override
    public boolean getCornerReinforcement(){
        return true;
    }
}
