package flexbox;

import java.util.ArrayList;

public class Invoice extends Order {

    public ArrayList<Box> boxes = new ArrayList<Box>();
    //Constructor
    Invoice(ArrayList<Box> orderbox) {
        boxes = orderbox;
    }
    public ArrayList getBoxes(){
        return boxes;
    }
    

}
