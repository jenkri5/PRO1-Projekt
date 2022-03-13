package theater;

import java.util.Arrays;

public class TheaterTickets {

    private final int[][] seats;

    public TheaterTickets(int x, int y) {
        seats = new int[y][x];
        generateSeatPrizes();
    }

    public void generateSeatPrizes() {
        double y20 = (double) Math.round((double) seats.length / 100 * 30);
        double y30 = (double) Math.round((double) seats.length / 100 * 70);
        double y40 = (double) Math.round((double) seats.length / 100 * 70);
        double y50 = (double) Math.round((double) seats.length / 100 * 80);
        double x20 = (double) Math.round((double) seats[0].length * 0.2);
        double x30 = 0;
        double x40 = (double) Math.round((double) seats[0].length * 0.4);
        double x50 = (double) Math.round((double) seats[0].length * 0.4);


        for (int y = 0; y < seats.length; y++) {
            if (y >= y40)
                x30 = x40 - 2;
            for (int x = 0; x < seats[y].length; x++) {
                seats[y][x] = 10;
                if (y >= y20 && x >= x20 && x < seats[y].length - x20)
                    seats[y][x] = 20;
                if (y >= y40)
                    seats[y][x] = 20;
                if (y >= y30 && x >= Math.round(x30) && x < seats[y].length - Math.round(x30))
                    seats[y][x] = 30;
                if (y >= y40 && x >= Math.round(x40) && x < seats[y].length - Math.round(x40))
                    seats[y][x] = 40;
                if (y >= y50 && x >= Math.round(x50) && x < seats[y].length - Math.round(x50))
                    seats[y][x] = 50;
            }
            if (y >= y50)
                x50 *= 0.4;
            if (y >= y50 - 1)
                x40 = x50 - 1;

        }

    }

    public void sellByPosition(int x, int y) {
        if (seats[y][x] != 0) {
            seats[y][x] = 0;
            System.out.println("You have bought a ticket.");
        } else
            System.out.println("That seat is unavailable.");
    }

    public void sellByPrice(int p) {

        boolean seatExist = false;
        boolean seatFound = false;

        for (int[] y : seats) {
            for (int x : y) {
                if (x == p) {
                    seatExist = true;
                    break;
                }
            }
        }

        if(!seatExist)
            System.out.println("No seats available for that price.");

        while (!seatFound && seatExist) {
            for (int y = 0; y < seats.length; y++) {
                if(seatFound)
                    break;
                for (int x = 0; x < seats[y].length; x++) {
                    if(seatFound)
                        break;
                    if (seats[y][x] == p) {
                        System.out.printf("Your seat is at [x: %d, y: %d]\n", x, y);
                        seats[y][x] = 0;
                        seatFound = true;
                    }
                }
            }
        }
    }

    public void printSeats() {
        for (int[] rows : seats) {
            System.out.println(Arrays.toString(rows));
        }
    }

    public void printStats() {
        int     count0=0,
                count10=0,
                count20=0,
                count30=0,
                count40=0,
                count50=0,
                count=0;
        for(int[] y : seats) {
            for(int x : y) {
                if(x == 0)
                    count0++;
                if(x == 10)
                    count10++;
                else if(x == 20)
                    count20++;
                else if(x == 30)
                    count30++;
                else if(x == 40)
                    count40++;
                else if(x == 50)
                    count50++;
                count++;
            }
        }
        System.out.printf("Sold: %d\n", count0);
        System.out.printf("$10: %d\n",count10);
        System.out.printf("$20: %d\n",count20);
        System.out.printf("$30: %d\n",count30);
        System.out.printf("$40: %d\n",count40);
        System.out.printf("$50: %d\n",count50);
        System.out.printf("Total: %d\n",count);
    }

}
