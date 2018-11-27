package flexbox;

import java.util.ArrayList;

public class Order {

    public static GUI gui = new GUI();
    public static ArrayList<Box> boxes = new ArrayList<Box>();

    public static void main(String[] args) {
        gui.setVisible(true);
    }

    public static void addToOrder(String lengthS, String widthS, String heightS, int grade, int colour, String quantityS, boolean btmRein, boolean crnrRein, boolean seal) {
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
        if (valid == true) {
            numOfBoxes++;
            int type = getBoxType(grade, colour, btmRein, crnrRein);

            if (type == 1) {
                Box1 box = new Box1(numOfBoxes, length, width, height, grade, colour, btmRein, crnrRein, seal, quantity);
                cost = String.format("%.2f", box.getCost(box));
                Invoice.addToTotal(box);
                boxes.add(box);
            }
            if (type == 2) {
                Box2 box = new Box2(numOfBoxes, length, width, height, grade, colour, btmRein, crnrRein, seal, quantity);
                cost = String.format("%.2f", box.getCost(box));
                Invoice.addToTotal(box);
                boxes.add(box);
            }
            if (type == 3) {
                Box3 box = new Box3(numOfBoxes, length, width, height, grade, colour, btmRein, crnrRein, seal, quantity);
                cost = String.format("%.2f", box.getCost(box));
                Invoice.addToTotal(box);
                boxes.add(box);
            }
            if (type == 4) {
                Box4 box = new Box4(numOfBoxes, length, width, height, grade, colour, btmRein, crnrRein, seal, quantity);
                cost = String.format("%.2f", box.getCost(box));
                Invoice.addToTotal(box);
                boxes.add(box);
            }
            if (type == 5) {
                Box5 box = new Box5(numOfBoxes, length, width, height, grade, colour, btmRein, crnrRein, seal, quantity);
                cost = String.format("%.2f", box.getCost(box));
                Invoice.addToTotal(box);
                boxes.add(box);
            }
            if (type == 6) {
                numOfBoxes--;
                valid = false;
                gui.notAvailable();

            }
            if (valid) {
                gui.addToTable(length, width, height, grade, colour, btmRein, crnrRein, seal, quantity, cost, numOfBoxes);
                gui.changeTotal(Invoice.getTotal());
            }
        }

    }

    public static void removeFromOrder(String ID) {
        boolean valid = true;
        int id = 0;
        try {
            id = Integer.valueOf(ID);
        } catch (Exception IllegalArgumentException) {
            gui.inputError();
            valid = false;
        }
        if (valid && id-1>boxes.size()) {
            boxes.remove(id - 1);
            gui.clearTable(id - 1);
            gui.reloadTable(boxes);
        }
        else{
            
        }

    }

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

    public static int oneColours(boolean botReinf, boolean cornReinf) {
        boolean bot = botReinf;
        boolean corn = cornReinf;
        if (!bot) {
            return 6;
        } else {
            if (!corn) {
                return 2;
            } else {
                return 6;
            }
        }
    }

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

    public static int getBoxType(int grade, int colour, boolean bottomReinforcement, boolean cornerReinforcement) {
        int type;
        switch (grade) {
            case 1: {
                if (colour == 0) {
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
                        type = noColours(bottomReinforcement, cornerReinforcement);
                        return type;
                    case 1:
                        type = oneColours(bottomReinforcement, cornerReinforcement);
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
                        type = noColours(bottomReinforcement, cornerReinforcement);
                        return type;
                    }
                    case 1: {
                        type = oneColours(bottomReinforcement, cornerReinforcement);
                        return type;
                    }
                    default: {
                        type = multiColors(bottomReinforcement, cornerReinforcement);
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
                        type = oneColours(bottomReinforcement, cornerReinforcement);
                        return type;
                    }
                    default: {
                        type = multiColors(bottomReinforcement, cornerReinforcement);
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
                        type = multiColors(bottomReinforcement, cornerReinforcement);
                        return type;
                    }
                }
            }
        }
    }
}
