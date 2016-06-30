package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Lorena on 6/30/2016.
 */
public class Shape extends AbstractShape implements ShapeBehaviour {

    public double area(){ return 0; };


    protected int color;
    protected float saturation;

    public int getColor() {
        return this.color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getSaturation() {
        return this.saturation;
    }

    public void setSaturation(float saturation) {
        this.saturation = saturation;
    }
}
