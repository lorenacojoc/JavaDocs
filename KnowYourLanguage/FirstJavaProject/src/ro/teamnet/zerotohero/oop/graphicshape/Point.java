package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Lorena on 6/30/2016.
 */
public class Point {
    public int xPos, yPos;

    public Point(int posx, int posy) {
        this.xPos = posx;
        this.yPos = posy;
    }

    ;


    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }

        Point point = (Point) o;
        if (o instanceof Point) {
            Point anotherPoint = (Point) o;
            // two points are equal only if their x and y positions are equal
            if ((xPos == anotherPoint.xPos) && (yPos == anotherPoint.yPos))
                return true;
            }
            return false;
        }


    }


