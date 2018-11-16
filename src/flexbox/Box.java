package flexbox;

public class Box extends Order {

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
        ID = boxID;
        length = boxLength;
        width = boxWidth;
        height = boxHeight;
        grade = boxGrade;
        colour = boxColour;
        bottomReinforcement = btmRein;
        cornerReinforcement = crnrRein;
        sealable = boxSeal;
        quantity = qnty;

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
        return colour;
    }

    public void setColour(int col) {
        colour = col;
    }

    public boolean getBottomReinforcement() {
        return bottomReinforcement;
    }

    public void setBottomReinforcement(boolean bottom) {
        bottomReinforcement = bottom;
    }

    public boolean getCornerReinforcement() {
        return cornerReinforcement;
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
        if (grade == 1) {
            cost = area * 0.55;
        } else if (grade == 2) {
            cost = area * 0.65;
        } else if (grade == 3) {
            cost = area * 0.82;
        } else if (grade == 4) {
            cost = area * 0.98;
        } else if (grade == 5) {
            cost = area * 1.5;
        }
        if (bottomReinforcement == true) {
            cost = cost + cost * 0.13;
        }
        if (cornerReinforcement == true) {
            cost = cost + cost * 0.12;
        }
        if (sealable == true) {
            cost = cost + cost * 0.10;
        }
        if (colour == 1) {
            cost = cost + cost * 0.12;
        } else if (grade == 2) {
            cost = cost + cost * 0.15;
        }

        cost *= box.getQuantity();
        
        return cost;

    }

}
