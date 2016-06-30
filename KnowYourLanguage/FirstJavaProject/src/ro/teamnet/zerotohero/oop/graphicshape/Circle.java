package ro.teamnet.zerotohero.oop.graphicshape;
import java.lang.Math;

/**
 * Created by Lorena on 6/30/2016.
 */
public class Circle extends Shape {

    private int xPos,yPos,radius;

    private Circle(){
        xPos = 12;
        yPos = 7;
        radius = 10;
    };

    public Circle(int posx){
        xPos = posx;
    };

    public Circle(int xpos, int ypos){
        xPos = xpos;
        yPos = ypos;
    };

    public Circle(int xpos, int ypos, int radiuss){
        xPos = xpos;
        yPos = ypos;
        radius = radiuss;

    };


   public double area(){
       return radius * radius * Math.PI;
   };


    public String toString(){
        return "center = (" + xPos + "," + yPos + ")" + "and radius = " + radius;
    }

    public void fillColor(){
        System.out.println("The super color is" + super.color);
    };

    public void fillColor(int aColor){
        super.color = aColor;
        System.out.println("The circle color is now" + aColor);
    };

    public void  fillColor(float aSaturation){
        super.saturation = aSaturation;
        System.out.println("The saturation is now" + aSaturation);
    };

    public void getAreaDef(){
        Circle aCircle = new Circle();
        fillColor();
        fillColor(color);
        fillColor(saturation);
    };

}


