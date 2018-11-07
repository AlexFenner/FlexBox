package flexbox;

public class Box extends Order{
    int ID;
    double length;
    double width;
    double height;
    int grade;
    int colour;
    boolean bottomReinforcement;
    boolean cornerReinforcement;
    boolean sealable;
    int quantity;
    //Constructor
    Box(int boxID,double boxLength,double boxWidth,double boxHeight, int boxGrade,
    int boxColour,boolean btmRein, boolean crnrRein, boolean boxSeal, int qnty){
        ID = boxID;
        length=boxLength;
        width = boxWidth;
        height=boxHeight;
        grade = boxGrade;
        colour = boxColour;
        bottomReinforcement = btmRein;
        cornerReinforcement = crnrRein;
        sealable = boxSeal;
        quantity = qnty;
        
    }
    //Get and setters
    public int getID(){
        return ID;
    }
    public void setID(int id){
        ID=id;
    }
    public double getLenght(){
        return length;
    }
    public void setLength(double len){
        length = len;
    }
    public double getWidth(){
        return width;
    }
    public void setWidth(double wid){
        width = wid;
    }
    public double getHeight(){
        return height;
    }
    public void setHeight(double hig){
        height = hig;
    }
    public int getGrade(){
        return grade;
    }
    public void setGrade(int gr){
        grade = gr;
    }
    public int getColour(){
        return colour;
    }
    public void setColour(int col){
        colour = col;
    }
    public boolean getBottomReinforcement(){
        return bottomReinforcement;
    }
    public void setBottomReinforcement(boolean bottom){
        bottomReinforcement = bottom;
    }
    public boolean getCornerReinforcement(){
        return cornerReinforcement;
    }
    public void setCornerReinforcement(boolean corner){
        cornerReinforcement = corner;
    }
    public boolean getSealable(){
        return sealable;
    }
    public void setSealable(boolean seal){
        sealable = seal;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quant){
        quantity = quant;
    }
            
    
    
}
    
    
    
    

      