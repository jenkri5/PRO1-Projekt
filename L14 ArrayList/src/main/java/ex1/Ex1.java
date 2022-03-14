package ex1;

import java.util.ArrayList;

public class Ex1 {

    public static void main(String[] args) {
        ArrayList<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("Hans");
        listOfStrings.add("Viggo");
        listOfStrings.add("Jens");
        listOfStrings.add("Bente");
        listOfStrings.add("Bent");
        System.out.println("List: "+listOfStrings);
        System.out.println("Size of list: "+listOfStrings.size());
        listOfStrings.add(2, "Jane");
        System.out.println("Add \"Jane\" at index 2: " +listOfStrings);
        listOfStrings.remove(1);
        System.out.println("Remove object at index 1: " +listOfStrings);
        listOfStrings.add(0, "Pia");
        System.out.println("Add \"Pia\" at index 0: " +listOfStrings);
        listOfStrings.add(listOfStrings.size(), "Ib");
        System.out.println("Add \"Ib\" at end of list: " +listOfStrings);
        System.out.println("Size of list: "+listOfStrings.size());
        listOfStrings.set(2, "Hansi");
        System.out.println("Set index 2 to \"Hansi\": "+listOfStrings);
        System.out.println("Size of list: "+listOfStrings.size());
        System.out.print("Get size of each value with for loop: ");
        for(int i = 0; i < listOfStrings.size(); i++)
            System.out.print(listOfStrings.get(i).length()+" ");
        System.out.println();
        System.out.print("Get size of each value with for-each loop: ");
        for(String string : listOfStrings)
            System.out.print(string.length()+" ");
    }
}
