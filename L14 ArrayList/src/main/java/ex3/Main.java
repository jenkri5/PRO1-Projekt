package ex3;

public class Main {

    public static void main(String[] args) {
        Team t = new Team("Red Pandas");
        Player p1 = new Player("Bo", 10);
        Player p2 = new Player("Lis", 12);
        Player p3 = new Player("Morten", 30);
        Player p4 = new Player("Soren", 15);
        t.addPlayer(p1);
        t.addPlayer(p2);
        t.addPlayer(p3);
        t.addPlayer(p4);
        p1.addScore(25);
        p3.addScore(30);
        p4.addScore(30);
        t.printPlayers();
        System.out.println("Average age: "+t.calcAverageAge());
        System.out.println("Total score: "+t.calcTotalScore());
        System.out.println("Old player score: "+t.calcOldPlayersScore(16));
        System.out.println("Max score: "+t.maxScore());
        System.out.println(t.bestPlayerNames());
    }
}
