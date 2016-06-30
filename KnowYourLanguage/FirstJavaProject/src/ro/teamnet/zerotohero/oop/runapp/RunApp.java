package ro.teamnet.zerotohero.oop.runapp;

import ro.teamnet.zerotohero.canvas.Canvas;
import ro.teamnet.zerotohero.oop.graphicshape.Circle;
import ro.teamnet.zerotohero.oop.Circles;


/**
 * Created by Lorena on 6/30/2016.
 */


public class RunApp {

    public void  main(){
        Circle newcircle = new Circle();
        Circles circles = new Circles();
        System.out.println("Circle area is" + circles.getAreaPub() );

        RunApp runapp = new RunApp();
        newcircle.getAreaDef();
        Canvas newCanvas = new Canvas();
        newCanvas.getArea();



    };


}
