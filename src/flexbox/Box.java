package flexbox;

public abstract class Box extends Order {

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
    Box(int boxID, double boxLength, double boxWidth, double boxHeight, int boxGrade,
            int boxColour, boolean btmRein, boolean crnrRein, boolean boxSeal, int qnty) {
        
        this.ID = boxID;
        this.length = boxLength;
        this.width = boxWidth;
        this.height = boxHeight;
        this.grade = boxGrade;
        this.colour = boxColour;
        this.bottomReinforcement = btmRein;
        this.cornerReinforcement = crnrRein;
        this.sealable = boxSeal;
        this.quantity = qnty;
        

    }

    //Get and setters
    public int getID() {
        return ID;
    }

    public void setID(int id) {
        ID = id;
    }

    public double getLenght() {
        return length;
    }

    public void setLength(double len) {
        length = len;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double wid) {
        width = wid;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double hig) {
        height = hig;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int gr) {
        grade = gr;
    }

    public int getColour() {
        return 0;
    }

    public void setColour(int col) {
        colour = col;
    }

    public boolean getBottomReinforcement() {
        return false;
    }

    public void setBottomReinforcement(boolean bottom) {
        bottomReinforcement = bottom;
    }

    public boolean getCornerReinforcement() {
        return false;
    }

    public void setCornerReinforcement(boolean corner) {
        cornerReinforcement = corner;
    }

    public boolean getSealable() {
        return sealable;
    }

    public void setSealable(boolean seal) {
        sealable = seal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quant) {
        quantity = quant;
    }

    public double getArea() {
        return 2 * (height * width) + 2 * (height * length) + 2 * (width * length);
    }
    
    public double getCost(Box box) {
        double cost = 0;
        double area = box.getArea();
        double percentIncrease = 0;
        
        switch (grade) {
            case 1:  cost = 
                     (0.55*area);
                     break;
            case 2:  cost = 
                     (0.65*area);
                     break;
            case 3:  cost = 
                     (0.82*area);
                     break;
            case 4:  cost = 
                     (0.98*area);
                     break;
            case 5:  cost = 
                     (1.50*area);
                     break;
        }
                     
        
        
        if (bottomReinforcement == true) {
            percentIncrease =+ 0.13;
        }
        if (cornerReinforcement == true) {
            percentIncrease =+ 0.12;
        }
        if (sealable == true) {
            percentIncrease =+ 0.10;
        }
        if (colour == 1) {
            percentIncrease =+ 0.12;
        } 
        else if (grade == 2) {
            percentIncrease =+ 0.15;
        }
        
        
        
        cost = cost * (percentIncrease + 1);
        cost *= box.getQuantity();
        
        return cost;

    }

}
