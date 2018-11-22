package flexbox;

import java.util.ArrayList;

public class Invoice extends Order {
    public ArrayList<Box> boxes = new ArrayList<Box>();
    public double totalPrice;

    //Constructor
    Invoice(ArrayList<Box> orderbox, double price) {
        boxes = orderbox;
        double totalPrice = price;
    }
    public ArrayList getBoxes(){
        return boxes;
    }

    public void addToTotal(Box box){
        //
        totalPrice += box.getCost(box);
    }

    public void takeFromTotal(Box box){
        //
        totalPrice -= box.getCost(box);
    }
}
