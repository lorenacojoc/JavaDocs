package ro.teamnet.zerotohero.oop.graphicshape.Immutable;


/**
 * Created by Lorena on 6/30/2016.
 */
public class TestImmutable {

    public static void main(String[] args)
    {
        Immutable im = Immutable.createNewInstance(100,50);
        System.out.println(im);
        tryModification(im.getHigh(),im.getLength());
        System.out.println(im);
    }

    private static void tryModification(int high, int length)
    {
        high = 1000;
        length = 100;

    }
}
