package ro.teamnet.zerotohero.oop.graphicshape.Immutable;

/**
 * Created by Lorena on 6/30/2016.
 */
public class Immutable {

        private final int high;
        private final int length;

        public Immutable(int high, int length) {
            this.high = high;
            this.length = length;
        }

        public int getHigh(){
            return high;
        }

        public int getLength(){
            return length;
        }

        public static Immutable createNewInstance(int high, int length)
        {
            return new Immutable(high, length);
        }

        public String toString() {
        return "The high" + high + " " + "The length" + length ;
    }

    }


