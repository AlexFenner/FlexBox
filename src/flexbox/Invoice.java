package flexbox;

import java.util.ArrayList;

public class Invoice extends Order {
    public ArrayList<Box> boxes = new ArrayList<Box>();
    public static double totalPrice=0;

    //Constructor
    Invoice(ArrayList<Box> orderbox, double price) {
        boxes = orderbox;
        double totalPrice = price;
    }
    public ArrayList getBoxes(){
        return boxes;
    }

    public static void addToTotal(Box box){
        
        String cost = String.format("%.2f", box.getCost(box));
        double addon = Double.valueOf(cost);
        totalPrice += addon;
    }

    public static void takeFromTotal(Box box){
        double price = box.getCost(box);
        totalPrice -= price;
    }
    public static double getTotal(){
        return totalPrice;
    }
}
