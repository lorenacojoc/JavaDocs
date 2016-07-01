package exercise.exercise3;

import java.util.List;
import java.lang.String;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Comparator;



/**
 * Created by Radu.Hoaghe on 04/20/2015.
 *
 * Exercise 3: Fill three Set implementations that you know (Hint: they were described during
 *             the earlier presentation) with the List<String> that is given to this class by
 *             its constructor.
 *
 *             Check out the elements that the list mentioned above contains and then, add them
 *             to your three Sets. After this check out the elements of your Sets. What do you
 *             remark? What could be the reason?
 *
 *             Finally, add to the one of the three Sets some elements
 *             that already exist in the Set (e.g add("that") and add("collection"))
 *
 *             To run your implementation, run the Exercise3Test class.
 */
public class Exercise3 {

    // List containing some elements that need to be added into the Set
    private List<String> listToAdd;

    public Exercise3(List<String> l) {
        listToAdd = l;
    }

    public void addElementsToSets() {

        Set<String> firstSet = new HashSet<String>();
        Set<String> secondSet = new HashSet<String>();
        Set<String> thirdSet = new HashSet<String>();
        Set<String> treeSet = new TreeSet<String>();


        System.out.println("The elements that will be added to the Sets: ");
        // TODO Exercise #3 a) Check the content of the elements you will add into the Set

        for (int iter = 0; iter < listToAdd.size(); iter++) {
            System.out.println(listToAdd.get(iter));
        }

        // TODO Exercise #3 b) add the elements from listToAdd to the Sets
        for (String elem : listToAdd) {
            firstSet.add(elem);
            secondSet.add(elem);
            thirdSet.add(elem);
        }


        // TODO Exercise #3 c) Check the content of the Sets
        System.out.println("\nThe elements contained in the first Set: ");
        for (String elem : firstSet) {
            System.out.println(elem);
        }

        System.out.println("\nThe elements contained in the second Set: ");
        for (String elem : secondSet) {
            System.out.println(elem);
        }
        System.out.println("\nThe elements contained in the third Set: ");
        for (String elem : thirdSet) {
            System.out.println(elem);
        }

        System.out.println("\nThe elements contained in the TreeSet after inserting two duplicates: ");

        // TODO Exercise #3 d) Add to the TreeSet two elements that already exist in the Set
        // TODO Exercise #3 d) and print again the TreeSet. What do you see?
        for (String elem : listToAdd) {
            treeSet.add(elem);
        }
        treeSet.add(listToAdd.get(0));

        for (String elem : treeSet) {
            System.out.println(elem);
        }


    }

    public static void main(String[] args) {
        Set<String> treeset = new TreeSet<String>(new myComp());
        treeset.add("RED");
        treeset.add("BLUE");
        treeset.add("yellow");
        System.out.println(treeset);

    }

}

    class myComp implements Comparator<String>{


        public int compare(String e1, String e2) {
            return e1.compareTo(e2);
        }

    }












