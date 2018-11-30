package flexbox;

/**
 * The invoice class keeps the total price of the order as well as printing out
 * the final invoice in the console
 */
import java.util.ArrayList;

/**
 * @author Group A4
 */
public class Invoice extends Order {

    public ArrayList<Box> boxes = new ArrayList<Box>();
    public static double totalPrice = 0;

    /**
     * Constructor for Invoice
     *
     * @param orderbox The list of boxes in the order
     * @param price A running total for the order
     */
    Invoice(ArrayList<Box> orderbox, double price) {
        boxes = orderbox;
        double totalPrice = price;
    }

    /**
     * @return The boxes within the order
     */
    public ArrayList getBoxes() {
        return boxes;
    }

    /**
     * This method adds the price of a box to the running total
     *
     * @param box The box to be added to the running total
     */
    public static void addToTotal(Box box) {
        String cost = String.format("%.2f", box.getCost(box));
        double addon = Double.valueOf(cost);
        totalPrice += addon;
    }

    /**
     * This method takes away the price of a box being removed from the order
     *
     * @param box The box to be taken away from the total
     */
    public static void takeFromTotal(Box box) {
        String cost = String.format("%.2f", box.getCost(box));
        double takeOff = Double.valueOf(cost);
        totalPrice -= takeOff;
    }

    /**
     * @return The total cost of the order
     */
    public static double getTotal() {
        return totalPrice;
    }

    /**
     * This method prints out a receipt for the order once it is complete
     *
     * @param boxList The boxes within the order
     */
    public static void printReciept(ArrayList<Box> boxList) {
        int numOfBoxes = boxList.size();
        if (numOfBoxes > 0) {
            System.out.println("FlexBox Invoice");
            System.out.println("---------------");
            System.out.println();
            System.out.println("Boxes");
            System.out.println("-----");

            for (int i = 0; i < numOfBoxes; i++) { // prints details for each box
                Box currBox = boxList.get(i);
                int id = i + 1;
                System.out.println("ID: " + id);
                System.out.println("Dimensions: " + currBox.getLenght() + " x "
                        + currBox.getWidth() + " x " + currBox.getHeight());
                System.out.println("Grade: " + currBox.getGrade());
                System.out.println("Number of colours: " + currBox.getColour());
                //Following if statements priovide more user friendly outputs
                if (currBox.getBottomReinforcement() == true) {
                    System.out.println("Bottom reinforcement : Yes");
                } else {
                    System.out.println("Bottom reinforcement : No");
                }
                if (currBox.getCornerReinforcement() == true) {
                    System.out.println("Corner reinforcement : Yes");
                } else {
                    System.out.println("Corner reinforcement : No");
                }
                if (currBox.getSealable() == true) {
                    System.out.println("Sealable top : Yes");
                } else {
                    System.out.println("Sealable top : No");
                }

                System.out.println("Quantity: " + currBox.getQuantity());
                System.out.println("Price: £" + String.format("%.2f", currBox.getCost(currBox)));
                System.out.println();
            }
            System.out.println("Total Price: £" + String.format("%.2f", totalPrice));
        }
        else{
            System.out.println("No boxes ordered");
        }
    }
}
