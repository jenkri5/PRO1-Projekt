package ex3;

import java.util.ArrayList;

public class Team {

    private final String name;
    private final ArrayList<Player> players;

    public Team(String name) {
        this.name = name;
        players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player p) {
        players.add(p);
    }

    public void printPlayers() {
        for(Player player : players) {
            System.out.println("Name: "+player.getName()+", Age: "+player.getAge()+", Score: "+player.getScore());
        }
    }

    public double calcAverageAge() {
        int total = 0;
        for(Player player : players) {
            total += player.getAge();
        }
        return total/players.size();
    }

    public int calcTotalScore() {
        int total = 0;
        for(Player player : players) {
            total += player.getScore();
        }
        return total;
    }

    public int calcOldPlayersScore(int ageLimit) {
        int total = 0;
        for(Player player : players) {
            if(player.getAge() > ageLimit) {
                total += player.getScore();
            }
        }
        return total;
    }

    public int maxScore() {
        int max = 0;
        for(Player player : players) {
            max = Math.max(max, player.getScore());
        }
        return max;
    }

    public ArrayList<String> bestPlayerNames() {
        ArrayList<String> best = new ArrayList<>();
        for(Player player : players) {
            if(player.getScore() == maxScore())
                best.add(player.getName());
        }
        return best;
    }
}
