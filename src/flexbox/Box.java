/**
 *The Abstract Box class is used as a template for the different box types
 *(box1 - box5). Some methods are overridden  by the subclasses. The Box class
 * is a child class of the main Order class as an order contains many boxes.
 *
 */
package flexbox;

/**
 * @author Group A4
 */
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

    /**
     * The constructor for Box class
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
    Box(double boxLength, double boxWidth, double boxHeight, int boxGrade,
            int boxColour, boolean btmRein, boolean crnrRein, boolean boxSeal,
            int qnty) {

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

    /**
     * @return The length of the box
     */
    public double getLenght() {
        return length;
    }

    /**
     * @param len the length of the box to be set
     */
    public void setLength(double len) {
        length = len;
    }

    /**
     * @return the width of the box
     */
    public double getWidth() {
        return width;
    }

    /**
     * @param wid the width of the box to be set
     */
    public void setWidth(double wid) {
        width = wid;
    }

    /**
     * @return the height of the box
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param hig the height of the box to be set
     */
    public void setHeight(double hig) {
        height = hig;
    }

    /**
     * @return the grade of the box
     */
    public int getGrade() {
        return grade;
    }

    /**
     * @param gr the grade of the box to be set
     */
    public void setGrade(int gr) {
        grade = gr;
    }

    /**
     * @return the colour of the box (is overridden by child classes)
     */
    public int getColour() {
        return 0;
    }

    /**
     * @param col the number of colours to be set for the box
     */
    public void setColour(int col) {
        colour = col;
    }

    /**
     * @return whether or not the box has bottom reinforcement (overridden by
     * child class)
     */
    public boolean getBottomReinforcement() {
        return false;
    }

    /**
     * @param bottom value for whether or not the box has bottom reinforcement
     */
    public void setBottomReinforcement(boolean bottom) {
        bottomReinforcement = bottom;
    }

    /**
     * @return whether or not the box has corner reinforcement (overridden by
     * child class)
     */
    public boolean getCornerReinforcement() {
        return false;
    }

    /**
     * @param corner value for whether or not the box has corner reinforcement
     */
    public void setCornerReinforcement(boolean corner) {
        cornerReinforcement = corner;
    }

    /**
     * @return whether or not the box has a sealable top
     */
    public boolean getSealable() {
        return sealable;
    }

    /**
     * @param seal Setting the value for whether or not the box is sealable
     */
    public void setSealable(boolean seal) {
        sealable = seal;
    }

    /**
     * @return the quantity of boxes
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quant the number of boxes to be set
     */
    public void setQuantity(int quant) {
        quantity = quant;
    }

    /**
     * @return the area of the box
     */
    public double getArea() {
        /**
         * calculates the area of the box by adding the surface area of each
         * side together
         */
        return 2 * (height * width) + 2 * (height * length) + 2
                * (width * length);
    }

    /**
     *
     * @param box the box that the price needs to be calculated for
     * @return The cost of the box
     */
    public double getCost(Box box) {
        double cost = 0;
        double area = box.getArea();
        double percentIncrease = 0;
        /**
         * Calculates the base price of the box considering the grade
         */
        switch (grade) {
            case 1:
                cost
                        = (0.55 * area);
                break;
            case 2:
                cost
                        = (0.65 * area);
                break;
            case 3:
                cost
                        = (0.82 * area);
                break;
            case 4:
                cost
                        = (0.98 * area);
                break;
            case 5:
                cost
                        = (1.50 * area);
                break;
        }
        /**
         * Calculates the percentage to be added on based on the attributes of
         * the box.
         */

        if (bottomReinforcement == true) {
            percentIncrease += 0.13; //+13% if the box has bottom reinforcement
        }
        if (cornerReinforcement == true) {
            percentIncrease += 0.12; //+12% if the box has corner reinforcement
        }
        if (sealable == true) {
            percentIncrease += 0.10; //+10% if the box has a sealable top
        }
        if (colour == 1) {
            percentIncrease += 0.12; //+12% if the box has 1 colour
        }
        if (colour == 2) {
            percentIncrease += 0.15;//+15% if the box has 2 colours
        }

        cost = cost * (percentIncrease + 1);// adds on price from above values

        cost *= box.getQuantity(); // Multiplies the price by number of boxes

        return cost;

    }

}
