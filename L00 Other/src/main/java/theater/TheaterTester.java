package theater;

public class TheaterTester {

    public static void main(String[] args) {

        TheaterTickets tickets = new TheaterTickets(10, 9);
        tickets.printSeats();
        System.out.println();
        tickets.printStats();
        System.out.println();
        tickets.sellByPrice(50);
        tickets.sellByPosition(5, 4);
        System.out.println();
        tickets.printSeats();
        System.out.println();
        tickets.printStats();

    }

}