package ex3;

public class Driver {

    public static void main(String[] args) {
        Copier c1 = new Copier();
        Copier c2 = new Copier(200);

        System.out.println(c1.getPaperCount()+" "+c2.getPaperCount());

        c1.insertPaper(501);
        c2.insertPaper(300);

        System.out.println(c1.getPaperCount()+" "+c2.getPaperCount());

        c1.makeCopy();
        c2.makeCopy(4);

        System.out.println(c1.getPaperCount()+" "+c2.getPaperCount());

        c2.makePaperJam();
        c2.makeCopy();
        c2.fixJam();
        c2.makeCopy();

        System.out.println(c1.getPaperCount()+" "+c2.getPaperCount());
    }
}
