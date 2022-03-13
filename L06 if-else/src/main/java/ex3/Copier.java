package ex3;

public class Copier {

    private int paperCount;
    private boolean paperStuck;

    public Copier() {
        paperCount = 0;
        paperStuck=false;
    }

    public Copier(int paperCount) {
        this.paperCount = paperCount;
        paperStuck=false;
    }

    public void insertPaper(int amount) {
        if (paperCount+amount>500) {
            System.out.println("ERROR! TOO MUCH PAPER.");
        } else {
            paperCount = paperCount + amount;
        }
    }

    public int getPaperCount() {
        return paperCount;
    }

    public void makeCopy() {
        if (paperStuck == true) {
            System.out.println("ERROR! PAPER STUCK.");
        } else {
            if (paperCount <= 0) {
                System.out.println("ERROR! NO PAPER.");
            } else {
                paperCount = paperCount - 1;
            }
        }

    }

    public void makeCopy(int copies) {
        if (paperStuck == true) {
            System.out.println("ERROR! PAPER STUCK.");
        } else {
            if (paperCount - copies <= 0) {
                System.out.println("ERROR! NO PAPER.");
            } else {
                paperCount = paperCount - copies;
            }
        }
    }

    public void makePaperJam() {
        paperStuck = true;
    }

    public void fixJam() {
        paperStuck = false;
    }

}
