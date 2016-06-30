package ro.teamnet.zerotohero.oop;

import ro.teamnet.zerotohero.oop.graphicshape.Shape;

/**
 * Created by Lorena on 6/30/2016.
 */
public class Square extends Shape {
    private int side;

    public Square(int initialSide){
        this.side = initialSide;
    };

    public double area (){
        return side * side;
    }
}

