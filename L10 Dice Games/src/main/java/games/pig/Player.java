package games.pig;

public class Player {

    private final String name;
    private int totalPoints = 0, totalValue = 0, lostValue = 0, throwCount = 0, turnCount = 0;
    private double averageValue = 0;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public int getTotalValue() { return totalValue; }

    public double getAverageValue() { return averageValue; }

    public int getLostValue() { return lostValue; }

    public int getThrowCount() { return throwCount; }

    public int getTurnCount() { return turnCount; }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public void updateTotalPoints(int points) {
        totalPoints += points;
    }

    public void updateTotalValue(int points) { totalValue += points; }

    public void incrementThrowCount() { throwCount++; }

    public void incrementTurnCount() { turnCount++; }

    public void calculateAverageValue() {
        if (totalValue != 0 && turnCount != 0) {
            averageValue = (double) totalValue / turnCount;
        }
    }

    public void calculateLostValue() { lostValue = totalValue - totalPoints; }

}
