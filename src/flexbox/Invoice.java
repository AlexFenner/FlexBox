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
    public static void printReciept(ArrayList<Box> boxList){
        int numOfBoxes = boxList.size();
        System.out.println("FlexBox Invoice");
        System.out.println("---------------");
        System.out.println();
        System.out.println("Boxes");
        System.out.println("-----");
        
        for(int i=0;i<numOfBoxes;i++){
            Box currBox = boxList.get(i);
            System.out.println("ID: " +i+1);
            System.out.println("Dimensions: " + currBox.getLenght() + " x " +
                    currBox.getWidth() +" x "+ currBox.getHeight());
            System.out.println("Grade: " + currBox.getGrade());
            System.out.println("Number of colours: " + currBox.getColour());
            if(currBox.getBottomReinforcement() == true){
                System.out.println("Bottom reinforcement : Yes");
            }
            else{
                System.out.println("Bottom reinforcement : No");
            }
            if(currBox.getCornerReinforcement() == true){
                System.out.println("Corner reinforcement : Yes");
            }
            else{
                System.out.println("Corner reinforcement : No");
            }
            if(currBox.getSealable() == true){
                System.out.println("Sealable top : Yes");
            }
            else{
                System.out.println("Sealable top : No");
            }
            System.out.println("Quantity: " + currBox.getQuantity());
            System.out.println();
        }
        System.out.println("Total Price: £" + totalPrice);
        System.exit(0);
        
        
         
    }
}
