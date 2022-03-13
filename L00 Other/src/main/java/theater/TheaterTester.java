package theater;

public class TheaterTester {

    public static void main(String[] args) {

        TheaterTickets tickets = new TheaterTickets(10, 9);

        tickets.sellByPrice(50);
        tickets.sellByPosition(5, 4);
        tickets.printSeats();
        tickets.printStats();

    }

}