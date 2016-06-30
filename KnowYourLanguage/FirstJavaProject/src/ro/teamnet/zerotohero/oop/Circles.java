package ro.teamnet.zerotohero.oop;

import ro.teamnet.zerotohero.oop.graphicshape.Circle;


/**
 * Created by Lorena on 6/30/2016.
 */
public class Circles {

    public double getAreaPub(){
        Circle circle = new Circle();
        return circle.area();
    };

    public void getAreaDef(){
        Circle aCircle = new Circle();
        aCircle.fillColor();
        aCircle.fillColor(2);
        aCircle.fillColor(3);
    };


}
