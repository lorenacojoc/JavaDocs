package ro.teamnet.zerotohero.oop.runapp;

import ro.teamnet.zerotohero.oop.Square;
import ro.teamnet.zerotohero.oop.graphicshape.Circle;
import ro.teamnet.zerotohero.oop.Circles;
import ro.teamnet.zerotohero.oop.graphicshape.Shape;
import ro.teamnet.zerotohero.oop.graphicshape.ShapeBehaviour;
import ro.teamnet.zerotohero.oop.graphicshape.Point;


/**
 * Created by Lorena on 6/30/2016.
 */


public class RunApp {

    public static void  main( String[] args){


        Circles circles = new Circles();
        System.out.println("Circle area is" + circles.getAreaPub() );

        circles.getAreaDef();

        //Canvas newCanvas = new Canvas();
        //newCanvas.getArea();

        Shape newshape = new Circle(10);
        System.out.println("The new shape area is" + newshape.area());

        ShapeBehaviour shapeBehaviour = new Square(10);
        System.out.println("the area is " + shapeBehaviour.area());

        Object p1 = new Point(10, 20);
        Object p2 = new Point(50, 100);
        Object p3 = new Point(10, 20);

        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));


    }


}
