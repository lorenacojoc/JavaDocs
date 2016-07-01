package exercise.exercise0;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 *
 * Exercise 0: Create a List (ArrayList or LinkedList), add elements to it and print all of them using ListIterator
 *             for loop and foreach loop.
 *
 */
public class Exercise0 {

    public Exercise0(){

    }

    public void iterateThroughList(){

        // TODO Exercise #0 a) Create a list (ArrayList or LinkedList) and add elements to it
        ArrayList<Integer> elements = new ArrayList<Integer>();
        elements.add(0);
        elements.add(1);
        elements.add(2);
        // TODO Exercise #0 a) Don't forget to specify the type of the list (Integer, String etc.)

        // TODO Exercise #0 b) Iterate through the list using ListIterator and print all its elements
        for(ListIterator<Integer> iter = elements.listIterator() ; iter.hasNext();){
            Integer element = iter.next();
            System.out.println("The element:" + element);

        }

        // TODO Exercise #0 c) Iterate through the list using classic for loop and print all its elements
        for( int i = 0; i< elements.size();i++){
            System.out.println(elements.get(i));
        }

        // TODO Exercise #0 d) Iterate through the list using foreach loop and print all its elements
        for(Integer iter : elements){
            System.out.println(elements.get(iter));
        }
    }

    public static void main(String[] args) {
        // TODO Exercise #0 e) Create a new instance of Exercise0 class and call the iterateThroughList() method
        Exercise0 exercise0 = new Exercise0();
        exercise0.iterateThroughList();
    }
}
