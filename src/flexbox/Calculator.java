/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author up880268
 */
public class Calculator extends Order{

    double length;
    int colour;
    double width;
    double heigth;
    int grade;
    double area;
    double cost;
    boolean bottomReinforcement;
    boolean cornerReinforcement;
    boolean sealable;
    Calculator(int boxGrade,int boxColour,double boxLength,double boxWidth,double boxHeight,boolean btmRein, boolean crnrRein, boolean boxSeal){
        length=boxLength;
        width = boxWidth;
        heigth=boxHeight;
        grade = boxGrade;
        colour = boxColour;
        bottomReinforcement = btmRein;
        cornerReinforcement = crnrRein;
        sealable = boxSeal;
    }
    public void Area(){
        area=2*(heigth*width)+2*(heigth*length)+2*(width*length);
    }
    public double getArea(){
    
    return area;
    }
    public void calculateCost(){
        if(grade==1)
            cost=area*0.55;
        else if(grade==2)
            cost=area*0.65;
        else if(grade==3)
            cost=area*0.82;
        else if(grade==4)
            cost=area*0.98;
        else if(grade==5)
            cost=area*1.5;
        if(bottomReinforcement==true)
            cost=cost+cost*0.13;
        if(cornerReinforcement==true)
            cost=cost+cost*0.12;
        if(sealable==true)
            cost=cost+cost*0.10;
        if(colour==1)
            cost=cost+cost*0.12;
        else if(grade==2)
            cost=cost+cost*0.15;
    
    }
    public double getCost(){
    return cost;
    }
}

    

