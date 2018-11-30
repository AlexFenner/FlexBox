package flexbox;

/**
 * The superclass of the program. Manages adding and taking away from the order
 * and determining the type of box
 */
import java.util.ArrayList;

/**
 * @author Group A4
 */
public class Order {

    public static GUI gui = new GUI(); //Initialises a new GUI
    public static ArrayList<Box> boxes = new ArrayList<Box>();//Creates box list

    /**
     * Main method In which the program starts by displaying the GUI
     */
    public static void main(String[] args) {
        gui.setVisible(true);
    }

    /**
     * Method used to add a box to the order
     *
     * @param lengthS Length of box to be converted
     * @param widthS width of box to be converted
     * @param heightS height of box to be converted
     * @param grade grade of box
     * @param colour number of colours of box
     * @param quantityS number of boxes
     * @param btmRein whether or not the box has reinforced bottom
     * @param crnrRein whether or not the box has reinforced corners
     * @param seal whether or not the box has sealable top
     */
    public static void addToOrder(String lengthS, String widthS, String heightS,
            int grade, int colour, String quantityS, boolean btmRein,
            boolean crnrRein, boolean seal) {
        int numOfBoxes = boxes.size();
        boolean valid = true;
        double length = 0, width = 0, height = 0;
        int quantity = 0;
        String cost = "";

        try {
            length = Double.valueOf(lengthS);
            width = Double.valueOf(widthS);
            height = Double.valueOf(heightS);
            quantity = Integer.valueOf(quantityS);
        } catch (Exception IllegalArgumentException) {
            gui.inputError();
            valid = false;
        }
        if (quantity <= 0 || width <= 0 || length <= 0 || height <= 0) {
            valid = false;
            gui.boxNumError();
        }
        if(width > 50 || length > 50 || height > 50){
            valid = false;
            gui.tooLarge();
        }
        if (valid == true) {
            numOfBoxes++;
            int type = getBoxType(grade, colour, btmRein, crnrRein);

            if (type == 1) {
                //creates box of type 1
                Box1 box = new Box1(length, width, height, grade, colour,
                        btmRein, crnrRein, seal, quantity);
                cost = String.format("%.2f", box.getCost(box));
                Invoice.addToTotal(box);
                boxes.add(box);// adds box to box list
            }
            if (type == 2) {
                //creates box of type 2
                Box2 box = new Box2(length, width, height, grade, colour,
                        btmRein, crnrRein, seal, quantity);
                cost = String.format("%.2f", box.getCost(box));
                Invoice.addToTotal(box);
                boxes.add(box);//Adds box to list
            }
            if (type == 3) {
                //creates box of type 3
                Box3 box = new Box3(length, width, height, grade, colour,
                        btmRein, crnrRein, seal, quantity);
                cost = String.format("%.2f", box.getCost(box));
                Invoice.addToTotal(box);
                boxes.add(box);//Adds box to list
            }
            if (type == 4) {
                //creates box of type 4
                Box4 box = new Box4(length, width, height, grade, colour,
                        btmRein, crnrRein, seal, quantity);
                cost = String.format("%.2f", box.getCost(box));
                Invoice.addToTotal(box);
                boxes.add(box);//Adds box to list
            }
            if (type == 5) {
                //creates box of type 5
                Box5 box = new Box5(length, width, height, grade, colour,
                        btmRein, crnrRein, seal, quantity);
                cost = String.format("%.2f", box.getCost(box));
                Invoice.addToTotal(box);
                boxes.add(box);//Adds box to list
            }
            if (type == 6) { //A box that cannot be supplied
                numOfBoxes--;
                valid = false;
                gui.notAvailable();

            }
            if (valid) {//Adds the box the the order table
                gui.addToTable(length, width, height, grade, colour, btmRein,
                        crnrRein, seal, quantity, cost, boxes.size());
                gui.changeTotal(Invoice.getTotal());
            }
        }

    }

    /**
     * Method used to delete a box from the order
     *
     * @param ID The ID of the box to be deleted
     */
    public static void removeFromOrder(String ID) {
        boolean valid = true;
        int id = 0;
        //Validating user input
        try {
            id = Integer.valueOf(ID);
        } catch (Exception IllegalArgumentException) {
            gui.inputError();
            valid = false;
        }
        //removes from order if input isvalid and box exists
        if (valid && id <= boxes.size() && id > 0) {
            Invoice.takeFromTotal(boxes.get(id - 1));
            gui.changeTotal(Invoice.getTotal());
            boxes.remove(id - 1);
            gui.clearTable(id - 1);
            gui.reloadTable(boxes);
        } else {
            gui.noBoxError(); // error incase box does not exist

        }

    }

    /**
     * Method to print out final receipt of order
     */
    public static void completeOrder() {
        Invoice.printReciept(boxes);
        System.exit(0); // Closes the program
    }

    /**
     * Method to determine box type if it has no colours
     *
     * @param botReinf whether or not the box has reinforced bottom
     * @param cornReinf whether or not the box has reinforced corners
     * @return The box type
     */
    public static int noColours(boolean botReinf, boolean cornReinf) {
        boolean bot = botReinf;
        boolean corn = cornReinf;
        if (!bot) {
            if (!corn) {
                return 1;
            } else {
                return 6;
            }
        } else {
            return 6;
        }
    }

    /**
     * Method to determine box type if it has 1 colour
     *
     * @param botReinf whether or not the box has reinforced bottom
     * @param cornReinf whether or not the box has reinforced corners
     * @return The box type
     */
    public static int oneColours(boolean botReinf, boolean cornReinf) {
        boolean bot = botReinf;
        boolean corn = cornReinf;
        if (!bot && !corn) {
            return 2;
        } else {
            return 6;
        }
    }

    /**
     * Method to determine box type if it has 2 colours
     *
     * @param botReinf whether or not the box has reinforced bottom
     * @param cornReinf whether or not the box has reinforced corners
     * @return The box type
     */
    public static int multiColors(boolean botReinf, boolean cornReinf) {
        boolean bot = botReinf;
        boolean corn = cornReinf;
        if (!bot) {
            if (!corn) {
                return 3;
            } else {
                return 6;
            }
        } else {
            if (!corn) {
                return 4;
            } else {
                return 5;
            }
        }
    }

    /**
     * Method to determine box type
     *
     * @param grade grade of the box
     * @param colour colour of the box
     * @param bottomReinforcement whether or not the box has reinforced bottom
     * @param cornerReinforcement whether or not the box has reinforced corners
     * @return
     */
    public static int getBoxType(int grade, int colour,
            boolean bottomReinforcement, boolean cornerReinforcement) {
        int type;
        switch (grade) {
            case 1: {
                if (colour == 0) {
                    //box has no colours so is passed to noColours method
                    type = noColours(bottomReinforcement, cornerReinforcement);
                    return type;
                } else {
                    type = 6;
                    return type;
                }
            }
            case 2: {
                switch (colour) {
                    case 0:
                        //box has no colours so is passed to noColours method
                        type = noColours(bottomReinforcement,
                                cornerReinforcement);
                        return type;
                    case 1:
                        //box has 1 colour so is passed to noColours method
                        type = oneColours(bottomReinforcement,
                                cornerReinforcement);
                        return type;
                    default:
                        if (!bottomReinforcement) {
                            if (!cornerReinforcement) {
                                type = 3;
                                return type;
                            } else {
                                type = 6;
                                return type;
                            }
                        } else {
                            if (!cornerReinforcement) {
                                type = 4;
                                return type;
                            } else {
                                type = 6;
                                return type;
                            }
                        }
                }
            }
            case 3: {
                switch (colour) {
                    case 0: {
                        //box has no colours so is passed to noColours method
                        type = noColours(bottomReinforcement,
                                cornerReinforcement);
                        return type;
                    }
                    case 1: {
                        //box has 1 colour so is passed to noColours method
                        type = oneColours(bottomReinforcement,
                                cornerReinforcement);
                        return type;
                    }
                    default: {
                        //box has 2 colours so is passed to noColours method
                        type = multiColors(bottomReinforcement,
                                cornerReinforcement);
                        return type;
                    }
                }
            }
            case 4: {
                switch (colour) {
                    case 0: {
                        type = 6;
                        return type;
                    }
                    case 1: {
                        //box has 1 colour so is passed to noColours method
                        type = oneColours(bottomReinforcement,
                                cornerReinforcement);
                        return type;
                    }
                    default: {
                        //box has 2 colours so is passed to noColours method
                        type = multiColors(bottomReinforcement,
                                cornerReinforcement);
                        return type;
                    }
                }
            }
            default: {
                switch (colour) {
                    case 0: {
                        type = 6;
                        return type;
                    }
                    case 1: {
                        type = 6;
                        return type;
                    }
                    default: {
                        //box has 2 colours so is passed to noColours method
                        type = multiColors(bottomReinforcement,
                                cornerReinforcement);
                        return type;
                    }
                }
            }
        }
    }
}
