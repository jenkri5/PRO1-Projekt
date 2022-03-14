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
        System.out.println(listOfStrings.size());
        listOfStrings.add(2, "Jane");
        System.out.println(listOfStrings);
        listOfStrings.remove(1);
        listOfStrings.add(0, "Pia");
        listOfStrings.add(listOfStrings.size(), "Ib");
        System.out.println(listOfStrings.size());
        listOfStrings.set(2, "Hansi");
        System.out.println(listOfStrings.size());
        System.out.println(listOfStrings);
        for(int i = 0; i < listOfStrings.size(); i++)
            System.out.print(listOfStrings.get(i).length()+" ");
        System.out.println();
        for(String string : listOfStrings)
            System.out.print(string.length()+" ");
    }
}
